//EmailService接口实现类
package com.lp.service.impl;
import com.lp.beans.entity.UserInfoEntity;
import com.lp.beans.pojo.dto.EmailCodeDto;
import com.lp.beans.pojo.dto.EmailDto;
import com.lp.beans.pojo.dto.SeedEmailDto;
import com.lp.beans.pojo.po.EmailCodePo;
import com.lp.mapper.EmailMapper;
import com.lp.service.EmailService;
import com.lp.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.Date;
@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private EmailMapper emailMapper;
    /**
     * 查找邮箱是否注册过了
     * @param email
     * @return
     */
    @Override
    public EmailDto isRegisteredEmail(String email) {
        UserInfoEntity userInfo = emailMapper.selectUserInfoByEmail(email);
        System.out.println(userInfo);
        if (userInfo!=null && userInfo.getEmail()!=null){
            return new EmailDto(userInfo.getEmail());
        }
        return null;
    }

    /**
     * 发送验证码给用户 0失败 1成功 -1表示验证码未过期 2表示已经注册过
     * @param seedEmail
     * @return
     */
    @Override
    public Integer seedEmail(SeedEmailDto seedEmail) {
        //先设置邮箱相关信息
        SimpleMailMessage message = new SimpleMailMessage();
        if (seedEmail.getType() == 1){ //注册
            message.setSubject("【补概App】注册账号邮箱验证");//主题
            //判断该邮箱是否注册过
            UserInfoEntity userInfo = emailMapper.selectUserInfoByEmail(seedEmail.getEmail());
            System.out.println("判断是否邮箱注册过");
            System.out.println(userInfo);
            if (userInfo!=null && userInfo.getEmail()!=null){
                return 2;
            }
        }else{  //找回
            message.setSubject("【补概App】找回密码邮箱验证");//主题
        }
        message.setFrom("15707408@qq.com");//发送人
        message.setTo(seedEmail.getEmail());//接受者
        String code = RandomUtil.code();//生成6未验证码
        Timestamp end;//过期时间
        try {
            //1.第一次使用邮箱，数据库没有该用户信息，进行插入操作 2.有该用户信息，验证码过期，进行更新操作 3.有该用户，验证码未过期，不操作数据库
            EmailCodePo emailCodeByEmail = emailMapper.selectEmailByEmail(seedEmail.getEmail(), seedEmail.getType());
            Timestamp now = new Timestamp(new Date().getTime()); //获取时间
            if (emailCodeByEmail != null){//不为空
                if (now.before(emailCodeByEmail.getEnd())){//时间有效
                    System.out.println("验证码未过期！");
                    return -1;//验证码未过期，可以继续使用！
                }else{ //验证码过期,进行验证码更新
                    System.out.println("验证码过期！");
                    end = new Timestamp(new Date().getTime() + 300000);//生成时间为当前时间后五分钟
                    emailMapper.updateEmailCode(new EmailCodeDto(seedEmail.getEmail(),code,seedEmail.getType(),end));
                }
            }else{                //为空,第一次使用邮箱，进行插入操作
                end = new Timestamp(new Date().getTime() + 300000);//生成时间为当前时间后五分钟
                emailMapper.insertEmailCode(new EmailCodeDto(seedEmail.getEmail(),code,seedEmail.getType(),end));
            }
            message.setText("欢迎使用补概App，您的本次验证码是：" + code + ", 有效期为5分钟。请妥善保管，切勿泄露。");//内容
            javaMailSender.send(message);//发送邮箱
            System.out.println("发送邮箱结束----------------------");
        }catch (Exception e){
            System.out.println("发送邮箱出现异常------------------------------");
            e.printStackTrace();
            return 0;
        }
        System.out.println("发送邮箱成功！-----------------------------------");
        return 1;
    }
}

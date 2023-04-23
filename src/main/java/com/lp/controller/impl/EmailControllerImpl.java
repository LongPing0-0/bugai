//邮箱Controller接口实现类
package com.lp.controller.impl;
import com.lp.beans.pojo.dto.EmailDto;
import com.lp.beans.pojo.dto.SeedEmailDto;
import com.lp.beans.pojo.vo.EmailVo;
import com.lp.beans.pojo.Result;
import com.lp.controller.EmailController;
import com.lp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class EmailControllerImpl implements EmailController {
    @Autowired
    private EmailService emailService;
    /**
     * 查找邮箱是否注册过了
     * @return
     */
    @PostMapping("/isRegisteredEmail")
    @Override
    public Result isRegisteredEmail(@RequestBody EmailVo email) {
        EmailDto registeredEmail = emailService.isRegisteredEmail(email.getEmail());
        if (registeredEmail!=null && registeredEmail.getEmail()!=null){
            return Result.success("已经注册过");
        }
        return Result.error("未注册过");
    }
    /**
     * 发送邮箱验证码给用户
     * @param email
     * @return
     */
    @PostMapping("/email/register")
    @Override
    public Result seedEmailCode(@RequestBody EmailVo email) {
        Integer integer = emailService.seedEmail(new SeedEmailDto(email.getEmail(), 1));        //type 1注册 2找回
        if (integer == 1){
            return Result.success("获取验证码成功！");
        }else if(integer == -1){
            return Result.success("验证码未过期！");
        }else if (integer == 2){
            return Result.error("该邮箱已经注册过！");
        }else{
            return Result.error("获取验证码失败！");
        }
    }
    /**
     * 发送邮箱验证码给用户 忘记密码
     * @param email
     * @return
     */
    @PostMapping("/email/forget")
    @Override
    public Result seedEmailCodeForget(@RequestBody EmailVo email) {
        Integer integer = emailService.seedEmail(new SeedEmailDto(email.getEmail(), 2));        //type 1注册 2找回
        if (integer == 1){
            return Result.success("获取验证码成功！");
        }else if(integer == -1){
            return Result.success("验证码未过期！");
        }else{
            return Result.error("获取验证码失败！");
        }
    }
}

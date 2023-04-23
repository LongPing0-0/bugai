//UserService接口实现类
package com.lp.service.impl;
import com.lp.beans.entity.MenuEntity;
import com.lp.beans.entity.UserEntity;
import com.lp.beans.entity.UserInfoEntity;
import com.lp.beans.pojo.Result;
import com.lp.beans.pojo.dto.UpdatePasswordDto;
import com.lp.beans.pojo.dto.UserDto;
import com.lp.beans.pojo.po.EmailCodePo;
import com.lp.beans.pojo.po.UserInfoPo;
import com.lp.beans.pojo.vo.BanUserCommunicationVo;
import com.lp.beans.pojo.vo.BindUserEmailVo;
import com.lp.beans.pojo.vo.ForgetPasswordVo;
import com.lp.beans.pojo.vo.RegisterUserVo;
import com.lp.mapper.EmailMapper;
import com.lp.mapper.UserMapper;
import com.lp.utils.JwtTokenUtil;
import com.lp.utils.QqAvatarUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class UserServiceImpl implements com.lp.service.UserService{
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private EmailMapper emailMapper;
    @Autowired
    private QqAvatarUtil qqAvatarUtil;
    /**
     * 插入用户用户名，密码，qq邮箱）
     * @param user
     * @return
     */
    @Override
    public Boolean addUserInfo(UserDto user) {
        try {
            user.setAccountCreated(new Timestamp(new Date().getTime()));
            //插入用户信息
            userMapper.insertUser(user);
            emailMapper.insertUserInfo(user);
        }catch (Exception e){
            return false;
        }
        //插入用户邮箱
        return true;
    }
    @Override
    public UserEntity getUserByUserName(String username) {
        UserEntity userEntity = userMapper.selectUserByUsername(username);
        userEntity.setRoles(userMapper.selectRoleByUid(userEntity.getUid()));
        return userEntity;
    }
    /**
     * 用户登录
     * @param username
     * @param password
     * @param request
     * @return
     */
    @Override
    public Result login(String username, String password, HttpServletRequest request) {
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        //登录
        UserDetails userDetails = null;
        try {
            userDetails = userDetailsService.loadUserByUsername(username);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("用户名或密码不正确！");
        }
        System.out.println("输出用户信息：");
        System.out.println(userDetails);
        if (userDetails == null || !passwordEncoder.matches(password,userDetails.getPassword())){
            return Result.error("用户名或密码不正确！");
        }
        if (!userDetails.isEnabled()){
            return Result.error("账号被禁用请联系管理员！");
        }
        //更新用户对象
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                userDetails,null,userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        System.out.println("authenticationToken:"+authenticationToken);
        //生成JWT
        String JWT = jwtTokenUtil.generateJwt(userDetails);
        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token",JWT);
        tokenMap.put("tokenHead",tokenHead);
        return Result.success("登录成功",tokenMap);
    }
    /**
     * 查找用户信息
     */
    @Override
    public UserInfoPo searchUserInfo() {
      return userMapper.selectUserInfoByUid(((UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUid());
    }
    /**
     * 用户找回密码
     * @param forgetPassword
     * @return
     */
    @Override
    public Integer forgetPassword(ForgetPasswordVo forgetPassword) {
        //密码加密
        String encodePassword = passwordEncoder.encode(forgetPassword.getPassword());
        System.out.println("用户密码加密："+encodePassword);
        UpdatePasswordDto updatePassword = new UpdatePasswordDto(forgetPassword.getEmail(),2, forgetPassword.getCode(), encodePassword);
        return userMapper.updateUserPassword(updatePassword);
    }
    /**
     * 用户注册 -1注册过，0注册失败，1注册成功
     * @param registerUser
     * @return
     */
    @Transactional
    @Override
    public Integer registerUser(RegisterUserVo registerUser) {
        UserDto user;
        //-1 表示注册过 0注册失败 1注册成功
        try {
            System.out.println("注册用户");
            //检查邮箱是否注册过
            System.out.println(registerUser.getEmail());
            UserInfoEntity userInfo = emailMapper.selectUserInfoByEmail(registerUser.getEmail());
            System.out.println(userInfo);
            if (userInfo!=null && userInfo.getEmail()!=null){
                //已经注册过邮箱了
                System.out.println("已经注册过");
                return -1;
            }
            //验证邮箱验证码是否合法
            EmailCodePo emailCode = emailMapper.selectEmailByEmail(registerUser.getEmail(), 1);
            if (!emailCode.getCode().equals(registerUser.getCode())){
                return 0;
            }
            //验证码匹配成功！则插入用户
            //插入用户信息
            //密码加密
            String encodePassword = passwordEncoder.encode(registerUser.getPassword());
            System.out.println("用户密码加密："+encodePassword);
            String qqAvatar = qqAvatarUtil.getQQAvatar(registerUser.getEmail());
            user = new UserDto(null, registerUser.getUsername(), encodePassword, registerUser.getEmail(),new Timestamp(
                    new Date().getTime()
            ),qqAvatar);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }

        try {
            userMapper.insertUser(user); //插入用户
            emailMapper.insertUserInfo(user);   //插入用户信息
            userMapper.insertUserRoleInfo(
                    user.getUid(),1);//插入用户角色信息 默认普通用户
        }catch (Exception e){
            throw new RuntimeException();
        }
        return 1;
    }

    /**
     * 用户绑定邮箱
     * @param bindUserEmailVo
     * @return
     */
    @Override
    public Integer bindEmail(BindUserEmailVo bindUserEmailVo) {
        Integer integer;
        //-1 表示注册过 0注册失败 1注册成功
        try {
            System.out.println("注册用户");
            //检查邮箱是否注册过
            System.out.println(bindUserEmailVo.getEmail());
            UserInfoEntity userInfo = emailMapper.selectUserInfoByEmail(bindUserEmailVo.getEmail());
            System.out.println(userInfo);

            if (userInfo!=null && userInfo.getEmail()!=null){
                //已经注册过邮箱了
                System.out.println("已经注册过");
                return -1;
            }
            //验证邮箱验证码是否合法
            EmailCodePo emailCode = emailMapper.selectEmailByEmail(bindUserEmailVo.getEmail(), 1);
            if (!emailCode.getCode().equals(bindUserEmailVo.getCode())){
                return 0;
            }
            //验证码匹配成功！则插入用户
            //插入用户信息
            //密码加密


            integer = emailMapper.updateEmailByUidAndEmail(bindUserEmailVo.getEmail(),
                    ((UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUid()
            );
            //插入用户角色信息 默认普通用户
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return integer >= 1 ? 1 : 0;

    }

    /**
     * 用户查找自己的权限
     * @return
     */
    @Override
    public List<MenuEntity> getMenusByUid() {
        return userMapper.getMenusByUid(((UserEntity)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUid());
    }

    /**
     * 禁言用户交流论坛
     * @param banUserCommunicationVo
     * @return
     */
    @Override
    public Boolean banUserCommunication(BanUserCommunicationVo banUserCommunicationVo) {
        Integer integer;
        try {
            System.out.println("开始");
         integer= userMapper.updateUserInfoByCommunicationEnabled
                    (banUserCommunicationVo.getUid(),
                            banUserCommunicationVo.getCommunicationEnabled());

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        System.out.println(integer);
        return integer >= 1 ? true : false;
    }


}

//用户Controller接口实现类
package com.lp.controller.impl;
import com.lp.beans.pojo.Result;
import com.lp.beans.pojo.po.UserInfoPo;
import com.lp.beans.pojo.vo.BanUserCommunicationVo;
import com.lp.beans.pojo.vo.BindUserEmailVo;
import com.lp.beans.pojo.vo.ForgetPasswordVo;
import com.lp.beans.pojo.vo.RegisterUserVo;
import com.lp.controller.UserController;
import com.lp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserControllerImpl implements UserController {
    @Autowired
    private UserService userService;
    /**
     * 插入用户用户名，密码，qq邮箱）
     * @param  registerUser
     * @return
     */
    @PostMapping("/user/add")
    @Override
    public Result addUser(@RequestBody RegisterUserVo registerUser) {
        Integer integer;
        try {
            integer = userService.registerUser(registerUser);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("系统内部出错，请联系管理员！");
        }

        if (integer == 1){
            return Result.success("添加用户成功！");
        }else if(integer == -1){
            return Result.error("该邮箱已经注册过！");
        }else{
            return Result.error("验证码错误！");
        }
    }
    @PostMapping("/user/info")
    @Override
    public Result searchUserInfo() {
        UserInfoPo userInfo = userService.searchUserInfo();
        if (userInfo!=null){
            return Result.success("获取用户信息成功！",userInfo);
        }
        return Result.error("获取用户信息失败！");
    }
    /**
     * 用户找回密码
     * @param forgetPassword
     * @return
     */
    @PostMapping("/user/forget")
    @Override
    public Result forgetPassword(@RequestBody ForgetPasswordVo forgetPassword) {
        Integer integer = userService.forgetPassword(forgetPassword);
        if (integer != 0){
            return Result.success("找回密码成功！");
        }
        return Result.error("找回密码失败！");
    }

    /**
     * 用户绑定邮箱
     * @param bindUserEmailVo
     * @return
     */
    @PostMapping("/user/emailBind")
    @Override
    public Result bindUserEmail(@RequestBody BindUserEmailVo bindUserEmailVo) {
        Integer integer = userService.bindEmail(bindUserEmailVo);
        if (integer == 1){
            return Result.success("绑定邮箱成功！");
        }else if(integer == -1){
            return Result.error("该邮箱已经注册过！");
        }else{
            return Result.error("验证码错误！");
        }
    }

    /**
     * 用户禁言与解除禁言
     * @param banUserCommunicationVo
     * @return
     */
    @PostMapping("/communication/ban")
    @Override
    public Result banUserCommunication(@RequestBody BanUserCommunicationVo banUserCommunicationVo) {
        System.out.println("传入的值："+banUserCommunicationVo.toString());
        return userService.banUserCommunication(banUserCommunicationVo)?
        Result.success("操作成功！"):Result.error("操作失败！");
    }
}

//登录Controller接口实现类
package com.lp.controller.impl;
import com.lp.beans.pojo.Result;
import com.lp.beans.pojo.vo.RegisterUserVo;
import com.lp.beans.pojo.vo.UserLoginVo;
import com.lp.controller.LoginController;
import com.lp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
@RestController
public class LoginControllerImpl implements LoginController {
    @Autowired
    private UserService userService;
    /**
     * 登录
     * @param userLogin
     * @param request
     * @return
     */
    @PostMapping("/login")
    @Override
    public Result Login(@RequestBody UserLoginVo userLogin, HttpServletRequest request) {
        return userService.login(userLogin.getUsername(), userLogin.getPassword(),request);
    }
    @PostMapping("/user/register")
    @Override
    public Result registerUser(@RequestBody RegisterUserVo registerUser) {
        Integer integer = userService.registerUser(registerUser);
        if (integer == 1){
            return Result.success("恭喜你，注册成功！");
        }else if(integer == -1){
            return Result.error("该邮箱已经注册过");
        }else {
            return Result.error("注册失败");
        }
    }
    /**
     * 退出登录
     * @return
     */
    @PostMapping("/user/logout")
    @Override
    public Result logOut() {
        return Result.success("注销成功！");
    }
    /**
     * 预登录
     * @return
     */
    @GetMapping("/user/doLogin")
    @Override
    public Result doLogin() {
        return Result.success("已经登录过！");
    }
}

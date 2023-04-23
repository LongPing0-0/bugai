//登录Controller接口
package com.lp.controller;
import com.lp.beans.pojo.Result;
import com.lp.beans.pojo.vo.RegisterUserVo;
import com.lp.beans.pojo.vo.UserLoginVo;
import javax.servlet.http.HttpServletRequest;
public interface LoginController {
    Result Login(UserLoginVo userLogin, HttpServletRequest request);    //登录
    Result registerUser(RegisterUserVo registerUser);    //注册用户
    Result logOut();    //退出
    Result doLogin();    //预登录
}

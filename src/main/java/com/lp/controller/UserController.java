//用户Controller接口
package com.lp.controller;
import com.lp.beans.pojo.Result;
import com.lp.beans.pojo.vo.BanUserCommunicationVo;
import com.lp.beans.pojo.vo.BindUserEmailVo;
import com.lp.beans.pojo.vo.ForgetPasswordVo;
import com.lp.beans.pojo.vo.RegisterUserVo;
public interface UserController {
    Result addUser(RegisterUserVo registerUser);    //插入用户用户名，密码，qq邮箱）
    Result searchUserInfo();    //查找用户信息
    Result forgetPassword(ForgetPasswordVo forgetPassword);    //用户找回密码

    //用户绑定邮箱
    Result bindUserEmail(BindUserEmailVo bindUserEmailVo);

    //用户禁言与解除禁言
    Result banUserCommunication(BanUserCommunicationVo banUserCommunicationVo);
}

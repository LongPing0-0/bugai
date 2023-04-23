//邮箱Controller接口
package com.lp.controller;
import com.lp.beans.pojo.vo.EmailVo;
import com.lp.beans.pojo.Result;
public interface EmailController {
    Result isRegisteredEmail(EmailVo email);    //查找邮箱是否注册过了
    Result seedEmailCode(EmailVo email);    //发送邮箱验证码给用户 注册
    Result seedEmailCodeForget(EmailVo email);    //发送邮箱验证码给用户 忘记密码
}

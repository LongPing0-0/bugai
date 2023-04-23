//EmailService接口
package com.lp.service;
import com.lp.beans.pojo.dto.EmailDto;
import com.lp.beans.pojo.dto.SeedEmailDto;
public interface EmailService {
    EmailDto isRegisteredEmail(String email);    //查找邮箱是否注册过了
    Integer seedEmail(SeedEmailDto seedEmail);    //发送验证码给用户
}

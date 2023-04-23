//UserService接口
package com.lp.service;
import com.lp.beans.entity.MenuEntity;
import com.lp.beans.entity.UserEntity;
import com.lp.beans.pojo.Result;
import com.lp.beans.pojo.dto.UserDto;
import com.lp.beans.pojo.po.UserInfoPo;
import com.lp.beans.pojo.vo.BanUserCommunicationVo;
import com.lp.beans.pojo.vo.BindUserEmailVo;
import com.lp.beans.pojo.vo.ForgetPasswordVo;
import com.lp.beans.pojo.vo.RegisterUserVo;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
    Boolean addUserInfo(UserDto user);    //插入用户用户名，密码，qq邮箱）
    UserEntity getUserByUserName(String username);
    Result login(String username, String password, HttpServletRequest request);    //用户登录
    UserInfoPo searchUserInfo();    //查找用户信息
    Integer forgetPassword(ForgetPasswordVo forgetPassword);    //用户找回密码
    Integer registerUser(RegisterUserVo registerUser);    //用户注册
    //用户绑定邮箱
    Integer bindEmail(BindUserEmailVo bindUserEmailVo);
    List<MenuEntity> getMenusByUid();  //用户查找自己的权限

    //禁言用户交流论坛
    Boolean banUserCommunication(BanUserCommunicationVo banUserCommunicationVo);

}

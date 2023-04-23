//EmailMapper接口
package com.lp.mapper;
import com.lp.beans.entity.UserInfoEntity;
import com.lp.beans.pojo.dto.EmailCodeDto;
import com.lp.beans.pojo.dto.UserDto;
import com.lp.beans.pojo.po.EmailCodePo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface EmailMapper {
    //根据邮箱号查找用户信息
    UserInfoEntity selectUserInfoByEmail(@Param("email") String email);
    //根据uid和email插入用户信息
    Integer insertUserInfo(UserDto user);
    //插入userInfo信息
    Integer insertUserInfoByUid(@Param("uid") Integer uid);
    //按照邮箱号和注册类型查找邮箱验证相关信息
    EmailCodePo selectEmailByEmail(@Param("email") String email, @Param("type") Integer type);
    //更新验证码
    Integer updateEmailCode(EmailCodeDto emailCode);
    //插入邮箱验证码相关信息
    Integer insertEmailCode(EmailCodeDto emailCodeDto);

    //用户绑定邮箱
    Integer updateEmailByUidAndEmail(@Param("email") String email, @Param("uid") Integer uid);
}

//UserMapper接口
package com.lp.mapper;
import com.lp.beans.entity.MenuEntity;
import com.lp.beans.entity.RoleEntity;
import com.lp.beans.entity.UserEntity;
import com.lp.beans.pojo.dto.UpUserAvatarDto;
import com.lp.beans.pojo.dto.UpdatePasswordDto;
import com.lp.beans.pojo.dto.UserDto;
import com.lp.beans.pojo.po.UserInfoPo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface UserMapper {
    //通过用户名和密码来注册用户信息
    int insertUser(UserDto user);
    //根据用户uid查找用户角色信息
    List<RoleEntity> selectRoleByUid(Integer uid);
    //根据用户名查询用户信息
    UserEntity selectUserByUsername(@Param("username") String username);
    //根据用名户查找特定用户信息
    UserInfoPo selectUserInfoByUid(@Param("uid") Integer uid);
    //用户找回密码
    Integer updateUserPassword(UpdatePasswordDto updatePasswordDto);
    //根据用户uid查找角色rid
    RoleEntity getRoleInfoByUid(@Param("uid") Integer uid);
    //插入用户角色信息
    Integer insertUserRoleInfo(@Param("uid") Integer uid,@Param("rid") Integer rid);

    //根据用户uid查找用户菜单权限
    List<MenuEntity> getMenusByUid(@Param("uid") Integer uid);

    //查找用户信息表中所有email和uid
    List<UpUserAvatarDto> selectAllUserAvatar();

    //通过uid和avatar更新用户头像信息
    Integer updateUserAvatar(@Param("uid") Integer uid, @Param("avatar") String avatar);

    //用户禁言与解除禁言
    Integer updateUserInfoByCommunicationEnabled(@Param("uid") Integer uid, @Param("communicationEnabled") Integer communicationEnabled);
}

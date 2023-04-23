package com.lp.service.impl;

import com.lp.beans.pojo.dto.UpUserAvatarDto;
import com.lp.mapper.UserMapper;
import com.lp.service.SystemAutoService;
import com.lp.utils.QqAvatarUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class SystemServiceImpl implements SystemAutoService {
    @Autowired
    private QqAvatarUtil qqAvatarUtil;
    @Autowired
    private UserMapper userMapper;
    @Override
    public Boolean autoUpdateUserAvatar() {
        List<UpUserAvatarDto> upUserAvatars = userMapper.selectAllUserAvatar();
        if(ObjectUtils.isEmpty(upUserAvatars)){
            return false;
        }
        try {
            upUserAvatars.forEach(e->{
                String qqAvatar = qqAvatarUtil.getQQAvatar(e.getEmail());
                Integer integer = userMapper.updateUserAvatar(e.getUid(), qqAvatar);
            });
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }
}

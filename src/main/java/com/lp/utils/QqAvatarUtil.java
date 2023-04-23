package com.lp.utils;

import org.springframework.stereotype.Component;

@Component
public class QqAvatarUtil {
    public String getQQAvatar(String email){
        if (email == null || email.equals("")) return null;
        email = email.substring(0,email.indexOf('@'));
        String avatar = "http://q.qlogo.cn/headimg_dl?dst_uin="+email+"&spec=640&img_type=jpg";
        return avatar;
    }
}

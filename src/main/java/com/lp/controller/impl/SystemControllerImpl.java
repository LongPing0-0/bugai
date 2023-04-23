package com.lp.controller.impl;

import com.lp.beans.pojo.Result;
import com.lp.controller.SystemController;
import com.lp.service.SystemAutoService;
import com.lp.service.impl.SystemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemControllerImpl implements SystemController {
    @Autowired
    private SystemAutoService systemAutoService;
    /**
     * 自动更新用户头像
     * @return
     */
    @GetMapping("/system/autoUpdateAvatar")
    @Override
    public Result autoUpdateUserAvatar() {
        return systemAutoService.autoUpdateUserAvatar()?Result.success("更新头像成功！"):Result.error("更新头像失败！");
    }
}

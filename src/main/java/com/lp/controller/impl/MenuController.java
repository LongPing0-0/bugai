package com.lp.controller.impl;

import com.lp.beans.entity.MenuEntity;
import com.lp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController implements com.lp.controller.MenuController {

    @Autowired
    private UserService userService;
    /**
     *     用户获取自己的权限
     */
    @GetMapping("/system/config/menu")
    @Override
    public List<MenuEntity> getMenusByUid() {
        List<MenuEntity> menusByUid = userService.getMenusByUid();
        return menusByUid;
    }
}

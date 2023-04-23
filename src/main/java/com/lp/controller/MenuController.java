package com.lp.controller;

import com.lp.beans.entity.MenuEntity;

import java.util.List;

public interface MenuController {

    //用户获取自己的权限
    List<MenuEntity> getMenusByUid();
}

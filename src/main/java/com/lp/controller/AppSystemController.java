package com.lp.controller;

import com.lp.beans.pojo.Result;
import com.lp.beans.pojo.vo.AppUpdateVo;
import com.lp.beans.pojo.vo.ConcatCommunicationVo;

import javax.servlet.http.HttpServletResponse;

public interface AppSystemController {
    //更新app接口
    void updateApp(HttpServletResponse response);
    //检查是否需要更新
    Result checkAppUpdate(AppUpdateVo appUpdateVo);

    //测试下载
    void download();

    //用户查找更新日志
    Result getAllUpdateInfo(ConcatCommunicationVo concatCommunicationVo);
}

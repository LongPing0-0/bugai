package com.lp.service;

import com.lp.beans.pojo.dto.AppUpdateDto;
import com.lp.beans.pojo.dto.RespPageDto;
import com.lp.beans.pojo.vo.AppUpdateVo;
import com.lp.beans.pojo.vo.ConcatCommunicationVo;

public interface AppUpdateService {
    //app查找是否需要更新
    AppUpdateDto checkAppUpdate(AppUpdateVo appUpdateVo);

    //查找已经下载人数
    Integer getCount();

    //查看更新日志信息
    RespPageDto getAllUpdateInfo(ConcatCommunicationVo concatCommunicationVo);
}

package com.lp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lp.beans.pojo.dto.AppUpdateDto;
import com.lp.beans.pojo.dto.RespPageDto;
import com.lp.beans.pojo.po.UpdateAppInfo;
import com.lp.beans.pojo.vo.AppUpdateVo;
import com.lp.beans.pojo.vo.ConcatCommunicationVo;
import com.lp.mapper.AppUpdateMapper;
import com.lp.service.AppUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class AppUpdateServiceImpl implements AppUpdateService {
    @Autowired
    private AppUpdateMapper appUpdateMapper;
    /**
     * app查找是否需要更新
     * @param appUpdateVo
     * @return
     */
    @Override
    public AppUpdateDto checkAppUpdate(AppUpdateVo appUpdateVo) {
        AppUpdateDto appUpdateDto;
        try {
            appUpdateDto = appUpdateMapper.selectAppUpdate();
        }catch (Exception e){
            e.printStackTrace();
            return new AppUpdateDto(null,null,null,null,null,0);
        }
        if (!ObjectUtils.isEmpty(appUpdateDto)){
            if (appUpdateVo.getVersionCode() < appUpdateDto.getVersionCode()){
                appUpdateDto.setType(1);
            }
            return appUpdateDto;
        }
        return new AppUpdateDto(null,null,null,null,null,0);
    }

    /**
     * 查找下载人数
     * @return
     */
    @Override
    public Integer getCount() {
        Integer integer;
        try {
            integer = appUpdateMapper.selectCount();
        }catch (Exception e){
            return null;
        }

        return integer;
    }

    /**
     * 查看更新日志信息
     * @param concatCommunicationVo
     * @return
     */
    @Override
    public RespPageDto getAllUpdateInfo(ConcatCommunicationVo concatCommunicationVo) {
        PageHelper.startPage(concatCommunicationVo.getCurrentPage(),concatCommunicationVo.getSize());
        List<UpdateAppInfo> updateAppInfos;
        try {
            updateAppInfos = appUpdateMapper.selectAllUpdateInfo();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        PageInfo<UpdateAppInfo> updateAppInfoPageInfo = new PageInfo<>(updateAppInfos);

        return new RespPageDto(updateAppInfoPageInfo.getTotal(),updateAppInfoPageInfo.getList());
    }
}

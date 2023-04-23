package com.lp.mapper;

import com.lp.beans.pojo.dto.AppUpdateDto;
import com.lp.beans.pojo.po.UpdateAppInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUpdateMapper {
    //检查更新
    AppUpdateDto selectAppUpdate();

    //添加人数
    Integer updateAppCount(@Param("count") Integer count);

    //查找app已经下载人数
    Integer selectCount();

    //用户查找更新日志信息
    List<UpdateAppInfo> selectAllUpdateInfo();
}

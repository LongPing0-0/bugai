package com.lp.controller.impl;

import com.lp.beans.pojo.Result;
import com.lp.beans.pojo.dto.AppUpdateDto;
import com.lp.beans.pojo.dto.RespPageDto;
import com.lp.beans.pojo.vo.AppUpdateVo;
import com.lp.beans.pojo.vo.ConcatCommunicationVo;
import com.lp.controller.AppSystemController;
import com.lp.mapper.AppUpdateMapper;
import com.lp.service.AppUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RestController
public class AppSystemControllerImpl implements AppSystemController {
    @Autowired
    private AppUpdateService appUpdateService;
    @Autowired
    private AppUpdateMapper appUpdateMapper;

    @GetMapping("/system/appUpdate")
    @Override
    public void updateApp(HttpServletResponse response) {
        Integer count = appUpdateService.getCount();

        if(!ObjectUtils.isEmpty(count)){
            count++;
            try {
                appUpdateMapper.updateAppCount(count);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
//        System.out.println("downLoad");
//        ServletOutputStream out = null;
//        File file;
//        FileInputStream is = null;
//        try {
//            ClassPathResource classPathResource = new ClassPathResource("/static/apk/");
//            String path = classPathResource.getURL().getPath();
//            file = new File(path,"/bugai.apk");
//            is = new FileInputStream(file);
//            //流形式
//            response.setHeader("content-type","application/octet-stream");
//            //防止中文乱码
//            response.setHeader("content-disposition","attachment;filename="+
//                    URLEncoder.encode("/bugai.apk","UTF-8"));
//            out = response.getOutputStream();
//
//            FileCopyUtils.copy(is,out);
////            try {
////                Integer integer = appUpdateMapper.selectCount();
////                appUpdateMapper.updateAppCount(++integer);
////            }catch (Exception e){
////                e.printStackTrace();
////            }
//
//        }catch (UnsupportedEncodingException e){
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            if (null!=out){
//                try {
//                    is.close();
//                    out.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }

    /**
     * app查找是否需要更新
     * @param appUpdateVo
     * @return
     */
    @PostMapping("/app/checkUpdate")
    @Override
    public Result checkAppUpdate(@RequestBody AppUpdateVo appUpdateVo) {
        System.out.println("客户端版本号："+appUpdateVo.getVersionCode());
        AppUpdateDto appUpdateDto = appUpdateService.checkAppUpdate(appUpdateVo);
        return Result.success("获取更新情况成功！",appUpdateDto);
    }


    @GetMapping("/getmy")
    @Override
    public void download() {

    }

    /**
     * 用户查找更新日志
     * @param concatCommunicationVo
     * @return
     */
    @PostMapping("/app/allUpdateInfo")
    @Override
    public Result getAllUpdateInfo(@RequestBody ConcatCommunicationVo concatCommunicationVo) {
        RespPageDto allUpdateInfo = appUpdateService.getAllUpdateInfo(concatCommunicationVo);
        return !ObjectUtils.isEmpty(allUpdateInfo)?Result.success("获取更新日志成功！",allUpdateInfo):Result.error("获取更新日志失败！ ");
    }
}

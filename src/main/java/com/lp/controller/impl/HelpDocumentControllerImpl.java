package com.lp.controller.impl;

import com.lp.beans.entity.HelpDocumentEntity;
import com.lp.beans.pojo.Result;
import com.lp.beans.pojo.vo.AddInformationVo;
import com.lp.beans.pojo.vo.DeIdVo;
import com.lp.controller.HelpDocumentController;
import com.lp.service.HelpDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelpDocumentControllerImpl implements HelpDocumentController {
    @Autowired
    private HelpDocumentService helpDocumentService;
    @GetMapping("/help/all")
    @Override
    public Result getAllHelp() {
        List<HelpDocumentEntity> allHelp = helpDocumentService.getAllHelp(null);
        if(!ObjectUtils.isEmpty(allHelp)){
            return Result.success("获取所有帮助文档成功！",allHelp);
        }
        return Result.error("获取所有帮助文档失败！");
    }

    /**
     * 获取enabled帮助文档
     * @return
     */
    @GetMapping("/help/enabled")
    @Override
    public Result getEnabledHelp() {
        List<HelpDocumentEntity> allHelp = helpDocumentService.getAllHelp(1);
        if(!ObjectUtils.isEmpty(allHelp)){
            return Result.success("获取所有帮助文档成功！",allHelp);
        }
        return Result.error("获取所有帮助文档失败！");
    }

    /**
     * 新增帮助文档
     * @param addInformationVo
     * @return
     */
    @PostMapping("/help/add")
    @Override
    public Result addHelpDocument(@RequestBody AddInformationVo addInformationVo) {

        return helpDocumentService.addHelpDocument(addInformationVo)?Result.success("新增帮助文档成功！"):Result.error("新增帮助文档失败！");
    }

    /**
     * 删除帮助文档
     * @param deIdVo
     * @return
     */
    @PostMapping("/help/remove")
    @Override
    public Result removeDocument(@RequestBody DeIdVo deIdVo) {
        return helpDocumentService.removeHelpDocument(deIdVo)?Result.success("删除帮助文档成功！"):Result.error("删除帮助文档失败！");
    }
}

package com.lp.controller;

import com.lp.beans.pojo.Result;
import com.lp.beans.pojo.vo.AddInformationVo;
import com.lp.beans.pojo.vo.DeIdVo;

public interface HelpDocumentController {
    //查找所有帮助文档
    Result getAllHelp();
    //获取enabled帮助文档
    Result getEnabledHelp();

    //新增帮助文档
    Result addHelpDocument(AddInformationVo addInformationVo);

    //删除帮助文档
    Result removeDocument(DeIdVo deIdVo);
}

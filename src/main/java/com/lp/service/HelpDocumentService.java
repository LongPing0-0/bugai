package com.lp.service;

import com.lp.beans.entity.HelpDocumentEntity;
import com.lp.beans.pojo.vo.AddInformationVo;
import com.lp.beans.pojo.vo.DeIdVo;

import java.util.List;

public interface HelpDocumentService {
    //查找所有帮助文档
    List<HelpDocumentEntity> getAllHelp(Integer enabled);

    //新增帮助文档
    Boolean addHelpDocument(AddInformationVo addInformationVo);

    //删除帮助文档
    Boolean removeHelpDocument(DeIdVo deIdVo);
}

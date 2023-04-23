package com.lp.service.impl;

import com.lp.beans.entity.HelpDocumentEntity;
import com.lp.beans.pojo.vo.AddInformationVo;
import com.lp.beans.pojo.vo.DeIdVo;
import com.lp.mapper.HelpDocumentMapper;
import com.lp.service.HelpDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelpDocumentServiceImpl implements HelpDocumentService {
    @Autowired
    private HelpDocumentMapper helpDocumentMapper;
    /**
     * 查找所有帮助文档
     * @return
     * @param enabled
     */
    @Override
    public List<HelpDocumentEntity> getAllHelp(Integer enabled) {
        List<HelpDocumentEntity> helpDocumentEntities;
        try {
            helpDocumentEntities = helpDocumentMapper.selectAllHelp(enabled);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return helpDocumentEntities;
    }

    /**
     * 新增帮助文档
     * @param addInformationVo
     * @return
     */
    @Override
    public Boolean addHelpDocument(AddInformationVo addInformationVo) {
        try {
            helpDocumentMapper.insertHelpDocument(addInformationVo.getTitle(), addInformationVo.getContent());
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 删除帮助文档
     * @param deIdVo
     * @return
     */
    @Override
    public Boolean removeHelpDocument(DeIdVo deIdVo) {
        Integer integer;
        try {
            integer = helpDocumentMapper.deleteHelpDocument(deIdVo.getId());
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return integer >= 1 ? true:false;
    }
}

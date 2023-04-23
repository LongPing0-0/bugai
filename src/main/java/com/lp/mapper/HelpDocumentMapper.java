package com.lp.mapper;

import com.lp.beans.entity.HelpDocumentEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HelpDocumentMapper {
    //查找所有帮助文档
    List<HelpDocumentEntity> selectAllHelp(@Param("enabled") Integer enabled);

    //新增帮助文档
    Integer insertHelpDocument(@Param("title") String title, @Param("content") String content);

    //删除帮助文档
    Integer deleteHelpDocument(@Param("id") Integer id);
}

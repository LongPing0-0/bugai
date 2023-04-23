package com.lp.mapper;

import com.lp.beans.pojo.dto.CommentDto;
import com.lp.beans.pojo.dto.CommunicationAndCommentDto;
import com.lp.beans.pojo.dto.CommunicationDto;
import com.lp.beans.pojo.po.CommentFavorPo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface CommunicationMapper {
    //查找分页交流论坛数据
    List<CommunicationDto> selectCommunications(@Param("cmid") Integer cmid);

    //查找myself分页交流论坛数据
    List<CommunicationDto> selectMySelfCommunication(@Param("uid") Integer uid);

    //查找某个文章对应的评论数
    Integer selectCountCommunication(@Param("id") Integer id);
    //查找某个文章对应的点赞数
    Integer selectCountFavorCommunication(@Param("id") Integer id);

    //获取交流论坛文章长度
    Integer selectCommunicationLength();

//    获取圈子和评论详细信息
    List<CommunicationAndCommentDto> selectCommunicationAndComment(@Param("cmid") Integer cmid);

    // 获取某个圈子里的所有评论详细信息
    List<CommentDto> selectCommentByCmid(@Param("cmid") Integer cmid);

    //删除所有圈子点赞信息
    Integer deleteCommunicationFavorByCmid(@Param("cmid") Integer cmid);
    //删除所有圈子评论信息
    Integer deleteCommunicationCommentBycmid(@Param("cmid") Integer cmid);
    //删除该圈子
    Integer deleteCommunicationBycmid(@Param("cmid") Integer cmid);

    //发表圈子
    Integer insertCommunication(@Param("uid") Integer uid, @Param("content") String content, @Param("created") Timestamp created);

    //删除评论
    Integer deleteCommentById(@Param("id") Integer id);

    //查看是否点过赞了
    CommentFavorPo selectIsCommentFavor(@Param("cmid") Integer cmid, @Param("uid") Integer uid);
    //点赞
    Integer insertFavorByCmid(@Param("cmid") Integer cmid, @Param("uid") Integer uid, @Param("favorTime") Timestamp favorTime);

    //取消点赞
    Integer deleteFavorByCmid(@Param("cmid") Integer cmid, @Param("uid") Integer uid);

    //评论
    Integer insertMyComment(@Param("uid") Integer uid, @Param("cmid") Integer cmid, @Param("commentTime") Timestamp commentTime, @Param("content") String content);
}

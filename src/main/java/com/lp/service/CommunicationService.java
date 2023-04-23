package com.lp.service;

import com.lp.beans.pojo.dto.CommunicationDto;
import com.lp.beans.pojo.dto.RespPageDto;
import com.lp.beans.pojo.vo.*;

import java.util.List;

public interface CommunicationService {
    //查找分页交流论坛数据
    RespPageDto getSomeCommunications(ConcatCommunicationVo concatCommunicationVo);

    //查找分页交流论坛数据--自己的
    RespPageDto getMySelfCommunications(ConcatCommunicationVo concatCommunicationVo);

    //获取圈子最大长度
    Integer getCommunicationLength();

    //获取单个交流论坛数据
    List<CommunicationDto> getOneCommunication(DeIdVo deIdVo);

    //删除圈子信息
    Boolean deleteCommunication(DeIdVo deIdVo);

    //发表圈子
    Boolean publishCommunication(InCommunicationVo inCommunicationVo);

    //获取某个圈子里的所有评论详细信
    RespPageDto getCommentByCmid(ConcatCommentVo concatCommentVo);

    //删除评论
    Boolean deleteCommentById(DeIdVo deIdVo);

    //点赞
    Boolean addFavorComment(IdVo idVo);

    //查看是否点过赞了
    Boolean isFavoredComment(IdVo idVo);

    //取消点赞
    Boolean cancelFavorComment(IdVo idVo);

//    评论
    Boolean addMyComment(AddCommentVo addCommentVo);
}

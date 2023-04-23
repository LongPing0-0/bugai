package com.lp.controller;

import com.lp.beans.pojo.Result;
import com.lp.beans.pojo.vo.*;

public interface CommunicationController {
    //查找分页交流论坛数据
    Result getSomeCommunications(ConcatCommunicationVo concatCommunicationVo);



    //用户查找自己的交流论坛数据
    Result getOneselfCommunications(ConcatCommunicationVo concatCommunicationVo);

    //获取最大长度
    Result getCommunicationLength();

    //获取单个交流论坛数据
    Result getOneCommunication(DeIdVo deIdVo);

    //删除某个圈子信息（点赞、评论、圈子一起删除）
    Result deleteCommunication(DeIdVo deIdVo);

    //发布自己的帖子
    Result publishMyCommunication(InCommunicationVo inCommunicationVo);

    //获取某个圈子里的所有评论详细信息
    Result getCommentByCmid(ConcatCommentVo concatCommentVo);

    //删除评论
    Result deleteCommentById(DeIdVo deIdVo);

    //点赞
    Result addFavorComment(IdVo idVo);

    //取消点赞
    Result cancelFavorComment(IdVo idVo);
    //查看是否点过赞了
    Result isFavoredComment(IdVo idVo);

    //评论
    Result addMyComment(AddCommentVo addCommentVo);
}

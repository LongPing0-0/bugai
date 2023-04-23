package com.lp.controller.impl;

import com.lp.beans.pojo.Result;
import com.lp.beans.pojo.dto.CommunicationDto;
import com.lp.beans.pojo.dto.RespPageDto;
import com.lp.beans.pojo.vo.*;
import com.lp.controller.CommunicationController;
import com.lp.mapper.CommunicationMapper;
import com.lp.service.CommunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommunicationControllerImpl implements CommunicationController {
    @Autowired
    private CommunicationService communicationService;
//    查找分页交流论坛数据
    @PostMapping("/communication/get")
    @Override
    public Result getSomeCommunications(@RequestBody ConcatCommunicationVo concatCommunicationVo) {
        RespPageDto someCommunications = communicationService.getSomeCommunications(concatCommunicationVo);
        return !ObjectUtils.isEmpty(someCommunications)?
                Result.success("获取交流论坛数据成功！",someCommunications):Result.error("获取失败！");
    }

    /**
     * 用户查找自己的交流论坛数据
     * @param concatCommunicationVo
     * @return
     */
    @PostMapping("/communication/myself")
    @Override
    public Result getOneselfCommunications(@RequestBody ConcatCommunicationVo concatCommunicationVo) {
        RespPageDto mySelfCommunications = communicationService.getMySelfCommunications(concatCommunicationVo);
        return !ObjectUtils.isEmpty(mySelfCommunications)?
                Result.success("获取交流论坛数据成功！",mySelfCommunications):Result.error("获取失败！");
    }

    @GetMapping("/communication/length")
    @Override
    public Result getCommunicationLength() {
        Integer communicationLength = communicationService.getCommunicationLength();
        return !ObjectUtils.isEmpty(communicationLength)?Result.success("获取交流论坛长度成功！",communicationLength):
                Result.error("获取交流论坛长度失败！");
    }

    /**
     * 获取单个交流论坛数据
     * @param deIdVo
     * @return
     */
    @PostMapping("/communication/one")
    @Override
    public Result getOneCommunication(@RequestBody DeIdVo deIdVo) {
        List<CommunicationDto> oneCommunication = communicationService.getOneCommunication(deIdVo);
        return !ObjectUtils.isEmpty(oneCommunication)?Result.success("获取该圈子信息成功！",oneCommunication):Result.error("获取该圈子信息失败！");
    }

    /**
     * 删除某个圈子信息（点赞、评论、圈子一起删除
     * @param deIdVo
     * @return
     */
    @PostMapping("/communication/deOne")
    @Override
    public Result deleteCommunication(@RequestBody DeIdVo deIdVo) {
        try {
            communicationService.deleteCommunication(deIdVo);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("删除该圈子信息失败！");
        }
        return Result.success("删除该圈子信息成功@！");
    }

    /**
     * 发布自己的帖子
     * @param inCommunicationVo
     * @return
     */
    @PostMapping("/communication/publish")
    @Override
    public Result publishMyCommunication(@RequestBody InCommunicationVo inCommunicationVo) {
        return communicationService.publishCommunication(inCommunicationVo)?Result.success("发布成功！"):Result.error("发布失败！");
    }

    /**
     * 获取某个圈子里的所有评论详细信息
     * @param concatCommentVo
     * @return
     */
    @PostMapping("/communication/commentOne")
    @Override
    public Result getCommentByCmid(@RequestBody ConcatCommentVo concatCommentVo) {
        RespPageDto comments = communicationService.getCommentByCmid(concatCommentVo);
        return !ObjectUtils.isEmpty(comments)?Result.success("获取该评论成功！",comments):Result.error("获取该评论失败！");
    }

    /**
     * 删除评论
     * @param deIdVo
     * @return
     */
    @PostMapping("/comment/deleteOne")
    @Override
    public Result deleteCommentById(@RequestBody DeIdVo deIdVo) {
        return communicationService.deleteCommentById(deIdVo)?Result.success("删除成功！"):Result.error("删除失败");
    }

    /**
     * 点赞
     * @param idVo
     * @return
     */
    @PostMapping("/comment/favor")
    @Override
    public Result addFavorComment(@RequestBody IdVo idVo) {
        return communicationService.addFavorComment(idVo)?Result.success("点赞成功！"):Result.error("点赞失败！");
    }

    /**
     * 取消点赞
     * @param idVo
     * @return
     */
    @PostMapping("/comment/cancel")
    @Override
    public Result cancelFavorComment(@RequestBody IdVo idVo) {
        return communicationService.cancelFavorComment(idVo)?Result.success("取消点赞成功！",true)
                :Result.error("取消点赞失败",false);
    }

    /**
     * 查看是否点过赞了
     * @param idVo
     * @return
     */
    @PostMapping("/comment/isFavored")
    @Override
    public Result isFavoredComment(@RequestBody IdVo idVo) {
        return communicationService.isFavoredComment(idVo)?Result.success("已经点过赞了！",true):Result.success("没有点过赞",false);
    }

    /**
     * 评论
     * @param addCommentVo
     * @return
     */
    @PostMapping("/comment/add")
    @Override
    public Result addMyComment(@RequestBody AddCommentVo addCommentVo) {
        return communicationService.addMyComment(addCommentVo)?Result.success("评论成功！"):Result.error("评论失败！");
    }
}

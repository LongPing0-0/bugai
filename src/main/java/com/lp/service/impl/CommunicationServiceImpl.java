package com.lp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lp.beans.entity.UserEntity;
import com.lp.beans.pojo.dto.CommentDto;
import com.lp.beans.pojo.dto.CommunicationDto;
import com.lp.beans.pojo.dto.RespPageDto;
import com.lp.beans.pojo.po.CommentFavorPo;
import com.lp.beans.pojo.vo.*;
import com.lp.mapper.CommunicationMapper;
import com.lp.service.CommunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class CommunicationServiceImpl implements CommunicationService {

    @Autowired
    private CommunicationMapper communicationMapper;

    /**
     * 查找分页交流论坛数据
     * @return
     */
    @Override
    public RespPageDto getSomeCommunications(ConcatCommunicationVo concatCommunicationVo) {
        PageHelper.startPage(concatCommunicationVo.getCurrentPage(), concatCommunicationVo.getSize());
        List<CommunicationDto> communications;
        try {
            communications = communicationMapper.selectCommunications(null);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        PageInfo<CommunicationDto> communicationDtoPageInfo = new PageInfo<>(communications);
        return new RespPageDto(communicationDtoPageInfo.getTotal(),communicationDtoPageInfo.getList());
    }

    /**
     * 查找分页交流论坛数据--自己的
     * @param concatCommunicationVo
     * @return
     */
    @Override
    public RespPageDto getMySelfCommunications(ConcatCommunicationVo concatCommunicationVo) {
        PageHelper.startPage(concatCommunicationVo.getCurrentPage(), concatCommunicationVo.getSize());
        List<CommunicationDto> communications;
        try {
            communications = communicationMapper.selectMySelfCommunication(
                    ((UserEntity)SecurityContextHolder.getContext().getAuthentication().getPrincipal())
                            .getUid()
            );
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        PageInfo<CommunicationDto> communicationDtoPageInfo = new PageInfo<>(communications);
        return new RespPageDto(communicationDtoPageInfo.getTotal(),communicationDtoPageInfo.getList());
    }

    /**
     * 获取圈子最大长度
     * @return
     */
    @Override
    public Integer getCommunicationLength() {
        Integer integer;
        try {
            integer = communicationMapper.selectCommunicationLength();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return integer;
    }

    /**
     * 获取单个交流论坛数据
     * @param deIdVo
     * @return
     */
    @Override
    public List<CommunicationDto> getOneCommunication(DeIdVo deIdVo) {
        List<CommunicationDto> communications;
        try{
            communications = communicationMapper.selectCommunications(deIdVo.getId());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

        return communications;
    }

    /**
     * 删除圈子信息
     * @param deIdVo
     * @return
     */
    @Transactional
    @Override
    public Boolean deleteCommunication(DeIdVo deIdVo) {
        try {
            //删除点赞
            communicationMapper.deleteCommunicationFavorByCmid(deIdVo.getId());
            //删除评论
            communicationMapper.deleteCommunicationCommentBycmid(deIdVo.getId());
            //删除圈子
            communicationMapper.deleteCommunicationBycmid(deIdVo.getId());
        }catch (Exception e){
            throw new RuntimeException();
        }
        return true;
    }

    /**
     * 发表圈子
     * @param inCommunicationVo
     * @return
     */
    @Override
    public Boolean publishCommunication(InCommunicationVo inCommunicationVo) {
        try {
            communicationMapper.insertCommunication(
                    ((UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUid(),
                    inCommunicationVo.getContent(),
                    new Timestamp(new Date().getTime())
            );
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * 获取某个圈子里的所有评论详细信
     *
     * @param concatCommentVo@return
     */
    @Override
    public RespPageDto getCommentByCmid(ConcatCommentVo concatCommentVo) {
        PageHelper.startPage(concatCommentVo.getCurrentPage(),concatCommentVo.getSize());
        List<CommentDto> comments;
        try{
            comments  = communicationMapper.selectCommentByCmid(concatCommentVo.getId());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        PageInfo<CommentDto> commentDtoPageInfo = new PageInfo<>(comments);
        return new RespPageDto(commentDtoPageInfo.getTotal(),commentDtoPageInfo.getList());
    }

    /**
     * 删除评论
     * @param deIdVo
     * @return
     */
    @Override
    public Boolean deleteCommentById(DeIdVo deIdVo) {
        try {
            communicationMapper.deleteCommentById(deIdVo.getId());
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 点赞
     * @param idVo
     * @return
     */
    @Override
    public Boolean addFavorComment(IdVo idVo) {
        try {
            communicationMapper.insertFavorByCmid(
                    idVo.getId(),
                    ((UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUid(),
                    new Timestamp(new Date().getTime())
            );
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 查看是否点过赞了
     * @param idVo
     * @return
     */
    @Override
    public Boolean isFavoredComment(IdVo idVo) {
        CommentFavorPo commentFavorPo;
        try {
            commentFavorPo = communicationMapper.selectIsCommentFavor(idVo.getId(),
                    ((UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUid()
            );
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return !ObjectUtils.isEmpty(commentFavorPo)?true:false;
    }

    /**
     * 取消点赞
     * @param idVo
     * @return
     */
    @Override
    public Boolean cancelFavorComment(IdVo idVo) {
        Integer integer;
        try {
            integer = communicationMapper.deleteFavorByCmid(idVo.getId(),
                    ((UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUid()
            );
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return integer>=1 ? true:false;
    }

    /**
     * 评论
     * @param addCommentVo
     * @return
     */
    @Override
    public Boolean addMyComment(AddCommentVo addCommentVo) {
        Integer integer;
        try {
            integer = communicationMapper.insertMyComment(
                    ((UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUid(),
                    addCommentVo.getId(),
                    new Timestamp(new Date().getTime()),
                    addCommentVo.getContent()
            );
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return integer>=1 ? true:false;
    }
}

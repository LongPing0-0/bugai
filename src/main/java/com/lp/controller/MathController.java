package com.lp.controller;

import com.lp.beans.pojo.Result;
import com.lp.beans.pojo.vo.MathZTVo;

public interface MathController {

    //获取正态分布fy
    Result getMathZT(MathZTVo mathZTVo);
}

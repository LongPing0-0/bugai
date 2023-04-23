package com.lp.controller.impl;

import com.lp.beans.pojo.Result;
import com.lp.beans.pojo.vo.MathZTVo;
import com.lp.controller.MathController;
import com.lp.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MathControllerImpl implements MathController {

    @Autowired
    private MathService mathService;
    /**
     * 获取正态分布fy
     * @param mathZTVo
     * @return
     */
    @PostMapping("/math/zt")
    @Override
    public Result getMathZT(@RequestBody MathZTVo mathZTVo) {
        System.out.println(mathZTVo);
        List<Double> normalDistribution = mathService.getNormalDistribution(mathZTVo);

        return !ObjectUtils.isEmpty(normalDistribution)?Result.success("获取正态分布成功！",normalDistribution):Result.error("获取正态分布失败！");
    }
}

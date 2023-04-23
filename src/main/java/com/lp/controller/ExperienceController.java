//实验Controller接口
package com.lp.controller;
import com.lp.beans.pojo.Result;
import com.lp.beans.pojo.experience.CoinVo;
public interface ExperienceController {
    Result tossCoin(CoinVo coinVo);    //掷骰子实验
}

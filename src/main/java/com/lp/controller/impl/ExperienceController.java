//实验Controller接口实现类
package com.lp.controller.impl;
import com.lp.beans.pojo.Result;
import com.lp.beans.pojo.experience.CoinDto;
import com.lp.beans.pojo.experience.CoinVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.security.SecureRandom;
@RestController
public class ExperienceController implements com.lp.controller.ExperienceController {
    /**
     * 掷骰子
     * @param coinVo
     * @return
     */
    @PostMapping("/experience/tossCoin")
    @Override
    public Result tossCoin(@RequestBody CoinVo coinVo) {
        Integer count = coinVo.getCount();
        CoinDto coinDto;
        if (count <= 100000){
            SecureRandom random = new SecureRandom();
            int zheng = 0;
            int fan = 0;
            for (int i = 0; i < count;i++){
                int x = random.nextInt(2);
                if (x == 0){
                    zheng++;
                }else {
                    fan++;
                }
            }
            System.out.println(zheng+":"+fan);
            coinDto = new CoinDto(zheng,fan);
            return Result.success("掷硬币成功！",coinDto);
        }
        return Result.error("服务器繁忙！");
    }
}

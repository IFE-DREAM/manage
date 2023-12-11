package com.neu.controller.hr;

import com.neu.dto.BonusDTO;
import com.neu.vo.UserVO;
import com.neu.pojo.Result;
import com.neu.service.BonusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mycom/bonus")
@Slf4j
@Api(tags = "奖惩相关接口")
@CrossOrigin
public class BonusController {

    @Autowired
    private BonusService bonusService;


    /**
     * 员工信息展示
     * @return
     */
    @GetMapping
    @ApiOperation("员工信息展示")
    public Result list(){
        List<UserVO> userVOList = bonusService.list();
        return Result.success(userVOList);
    }

    /**
     * 加奖金
     * @param bonusDTO
     * @return
     */
    @PostMapping("/plus")
    @ApiOperation("加奖金")
    public Result plus(BonusDTO bonusDTO){
        log.info("加奖金:{}",bonusDTO);
        bonusService.plus(bonusDTO);
        return Result.success();
    }

    /**
     * 扣钱
     * @param bonusDTO
     * @return
     */
    @PostMapping("/sub")
    @ApiOperation("扣钱")
    public Result sub(BonusDTO bonusDTO){
        log.info("扣钱:{}",bonusDTO);
        bonusService.sub(bonusDTO);
        return Result.success();
    }

    /**
     * 修改底薪
     * @param bonusDTO
     * @return
     */
    @PostMapping("/update")
    @ApiOperation("修改底薪")
    public Result updateSalary(BonusDTO bonusDTO){
        log.info("修改底薪:{}",bonusDTO);
        bonusService.update(bonusDTO);
        return Result.success();
    }

}

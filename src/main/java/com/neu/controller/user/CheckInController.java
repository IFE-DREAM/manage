package com.neu.controller.user;

import com.neu.pojo.Result;
import com.neu.service.CheckInService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/check")
@Slf4j
@Api(tags = "签到相关接口")
@CrossOrigin
public class CheckInController {

    @Autowired
    private CheckInService checkInService;

    /**
     * 查询签到状态
     * @param id
     * @return
     */
    @GetMapping
    @ApiOperation("查询签到状态")
    public Result getCheck(Integer id){
        log.info("签到用户为：{}",id);
        Integer status = checkInService.getCheck(id);
        return Result.success(status);
    }

    /**
     * 进行签到
     * @param id
     * @return
     */
    @PostMapping
    @ApiOperation("进行签到")
    public Result updateCheck(Integer id){
        log.info("正在签到：{}",id);
        return checkInService.check(id);
    }


}

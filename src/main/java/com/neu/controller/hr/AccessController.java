package com.neu.controller.hr;


import com.neu.dto.AccessDTO;
import com.neu.pojo.Attendrecord;
import com.neu.pojo.Result;
import com.neu.service.AccessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mycom/access")
@Slf4j
@Api(tags = "审批相关接口")
@CrossOrigin
public class AccessController {

    @Autowired
    private AccessService accessService;


    /**
     * 审批列表展示
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("审批列表展示")
    public Result list(String type){
        log.info("列表展示：{}",type);
        List<Attendrecord> list = accessService.list(type);
        return Result.success(list);
    }


    /**
     * 设置金额
     * @param accessDTO
     * @return
     */
    @PostMapping("/set")
    @ApiOperation("设置金额")
    public Result setMoney(AccessDTO accessDTO){
        log.info("设置金额:{}",accessDTO);
        accessService.set(accessDTO);
        return Result.success();
    }

}

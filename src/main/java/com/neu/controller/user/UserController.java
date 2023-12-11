package com.neu.controller.user;

import com.neu.dto.InfoDTO;
import com.neu.vo.InfoVO;
import com.neu.pojo.Result;
import com.neu.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mycom/p_info")
@Slf4j
@Api(tags = "个人信息相关接口")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询个人信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("查询个人信息")
    public Result getInfo(@PathVariable Integer id){
        InfoVO info = userService.getInfo(id);
        return Result.success(info);
    }

    /**
     *
     * @param infoDTO
     * @return
     */
    @PostMapping
    @ApiOperation("修改个人信息")
    public Result update(InfoDTO infoDTO){
        userService.update(infoDTO);
        return Result.success();
    }
}

package com.neu.controller.user;

import com.neu.dto.LoginDTO;
import com.neu.pojo.Result;
import com.neu.service.CheckInService;
import com.neu.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mycom/login")
@Slf4j
@Api(tags = "登录相关接口")
@CrossOrigin
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 用户登录
     * @param
     * @return
     */
    @PostMapping
    @ApiOperation("用户登录")
    public Result Login(LoginDTO loginDTO){
        log.info("登录用户为：{}",loginDTO);
        String userid = loginService.login(loginDTO);
        return Result.success(userid);
    }
}

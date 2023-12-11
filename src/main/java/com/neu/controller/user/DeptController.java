package com.neu.controller.user;

import com.neu.pojo.Dept;
import com.neu.pojo.Result;
import com.neu.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/mycom")
//@RequestMapping
@CrossOrigin
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    public Result list(){
        log.info("查询部门全部信息");
        List<Dept> deptList = deptService.list();
        System.out.println("请求到了");
        return Result.success(deptList);
    }

//    @PostMapping
//    public Result add(Dept dept){
//        log.info("添加用户:{}",dept.getName());
//        int flag = deptService.add(dept);
//        if(flag<1)return Result.error("添加失败");
//        return Result.success();
//    }

}

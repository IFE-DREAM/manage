package com.neu.controller.user;

import com.neu.pojo.Result;
import com.neu.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/mycom")
@CrossOrigin
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping("/jilu")
    public Result atlist(Integer id){
        System.out.println(id);
        if (id==null)id = 1001;
        return empService.list(id);
    }

    @PostMapping("/salary")
    public Result getsalary(@RequestParam("id") Integer id){
        System.out.println(id);
        if (id==null)id = 1001;
        return empService.getsalary(id);
    }

    @PostMapping("/qingjia")
    public Result qingjia(@RequestParam("id") Integer id,
                          @RequestParam("reason") String reason){
        if(id == null){
            return Result.error("提交失败");
        }
        return empService.qingjia(id,reason);
    }

    @PostMapping("/jiaban")
    public Result jiaban(@RequestParam("id") Integer id,
                          @RequestParam("reason") String reason){
        if(id == null){
            return Result.error("提交失败");
        }
        return empService.jiaban(id,reason);
    }

    @GetMapping("/chidao")
    public Result getchidaoList(Integer id){
        System.out.println(id);
        if (id==null)id = 1001;
        return empService.getchidaoList(id);
    }

    @PostMapping("/chidao")
    public Result postchidaoReason(Integer idid, String reason){
        System.out.println(idid);
        return empService.postchidaoReason(idid,reason);
    }

//    @GetMapping("/p_info")
//    public Result personinfo(Integer id){
//        return empService.personinfo(id);
//    }
}

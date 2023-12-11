package com.neu.service.Impl;

import com.neu.mapper.EmpMapper;
import com.neu.pojo.Attendrecord;
import com.neu.pojo.Result;
import com.neu.pojo.Staffsalary;
import com.neu.pojo.chidaoList;
import com.neu.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public Result list(int eid) {
        List<Attendrecord> list = empMapper.atlist(eid);
        for (int i = 0; i < list.size(); i++) {
            Attendrecord attendRecord = list.get(i);
            switch (attendRecord.getReasontype()){
                case "1":
                    attendRecord.setReasontype("准时上班");
                    break;
                case "2":
                    attendRecord.setReasontype("加班");
                    break;
                case "3":
                    attendRecord.setReasontype("请假");
                    break;
                case "4":
                    attendRecord.setReasontype("迟到(早退)");
                    break;
                default:
            }
        }
        return Result.success(list);
    }

    @Override
    public Result getsalary(int id) {
        List<Staffsalary> list = empMapper.getSalaryList(id);
        /*for (int i = 0; i < list.size(); i++) {
            Staffsalary listitem = list.get(i);
            if(listitem.getTypetype()=="1")listitem.setTypetype("奖励");
            else if(listitem.getTypetype()=="2")listitem.setTypetype("惩罚");
        }*/
        for (Staffsalary listitem : list) {
            if(listitem.getTypetype().equals("1")) listitem.setTypetype("奖励");
            else if(listitem.getTypetype().equals("2"))listitem.setTypetype("惩罚");
        }
        //获取考勤方面的奖惩
        float money = empMapper.getmoney1(id);
        LocalDate currentDate = LocalDate.now();
        Staffsalary newsalary = new Staffsalary(id,"考勤奖惩","考勤奖惩",money,currentDate);
        list.add(newsalary);
        return Result.success(list);
    }

    @Override
    public Result qingjia(Integer id, String reason) {
        LocalDateTime localDateTime = LocalDateTime.now();
        int flag = empMapper.qingjia(id, reason,localDateTime);
        if(flag>0)return Result.success();
        return Result.error("添加失败");
    }

    public Result jiaban(Integer id, String reason) {
        LocalDateTime localDateTime = LocalDateTime.now();
        int flag = empMapper.jiaban(id, reason,localDateTime);
        if(flag>0)return Result.success();
        return Result.error("添加失败");
    }

    public Result getchidaoList(Integer id){
        List<chidaoList> list= empMapper.getchidaoList(id);
        return Result.success(list);
//        return Result.error("添加失败");
    }

    public Result postchidaoReason(Integer idid,String reason){
        int flag = empMapper.postchidao(idid, reason);
        if(flag>0)return Result.success();
        return Result.error("添加失败");
    }
    public Result personinfo(Integer id){
//        return empMapper.personinfo3(id);
        return Result.success();
    }
}

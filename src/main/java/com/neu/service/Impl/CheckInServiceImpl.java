package com.neu.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.neu.mapper.CheckInMapper;
import com.neu.mapper.EmpMapper;
import com.neu.pojo.Result;
import com.neu.pojo.User;
import com.neu.service.CheckInService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Slf4j
@Service
public class CheckInServiceImpl implements CheckInService {

    @Autowired
    private CheckInMapper checkInMapper;
    @Autowired
    private EmpMapper empMapper;

    /**
     * 查询签到状态
     * @param id
     * @return
     */
    @Override
    public Integer getCheck(Integer id) {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        lqw.eq(User::getId,id);
        User user = checkInMapper.selectOne(lqw);
        return user.getWorkstatus();
    }

    /**
     * 进行签到
     * @param id
     * @return
     */
    @Override
    @Transactional
    public Result check(Integer id) {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        lqw.eq(User::getId,id);
        User user = checkInMapper.selectOne(lqw);
        //未打卡时
        if(user.getWorkstatus() == 0){
            //先判断当前时间是否超时
            Calendar cale = Calendar.getInstance();  // 取当前日期
            Calendar calendar = new GregorianCalendar(cale.get(Calendar.YEAR),cale.get(Calendar.MONTH),cale.get(Calendar.DAY_OF_MONTH),8,30,0);
            //当前时间
            Date nowTime = cale.getTime();
            //当日早上八点半
            Date checkWorkTime = calendar.getTime();
            //超出上班签到时间
            if(nowTime.after(checkWorkTime)){
                empMapper.chidao(id,"迟到",LocalDateTime.now());
                user.setWorkstatus(1);
                checkInMapper.updateById(user);
                return Result.success("超出上班打卡时间，已记录迟到！");
            }
            //签到
            empMapper.checkWork(id,LocalDateTime.now());
            user.setWorkstatus(1);
            checkInMapper.updateById(user);
            return Result.success("打卡成功！");
        }
        //已经上班签到时，状态为1
        if(user.getWorkstatus() == 1){
            //先判断当前时间是否超时
            Calendar cale = Calendar.getInstance();  // 取当前日期
            Calendar calendar = new GregorianCalendar(cale.get(Calendar.YEAR),cale.get(Calendar.MONTH),cale.get(Calendar.DAY_OF_MONTH),20,30,0);
            //当前时间
            Date nowTime = cale.getTime();
            //当日晚上八点半
            Date checkRestTime = calendar.getTime();
            if(nowTime.before(checkRestTime)){
                return Result.error("还未到下班时间，无法打卡！");
            }
            //先设置状态
            user.setWorkstatus(2);
            checkInMapper.updateById(user);
            LocalDateTime dateBegin = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
            LocalDateTime dateEnd = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
            //更新打卡记录
            empMapper.checkRest(id,LocalDateTime.now(),dateBegin,dateEnd);
            return Result.success("下班打卡成功！");
        }
        return Result.error("当前无法打卡！");
    }
}

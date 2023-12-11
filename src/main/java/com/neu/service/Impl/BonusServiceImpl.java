package com.neu.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.neu.dto.BonusDTO;
import com.neu.vo.UserVO;
import com.neu.mapper.BonusMapper;
import com.neu.mapper.DeptMapper;
import com.neu.mapper.UserMapper;
import com.neu.pojo.Dept;
import com.neu.pojo.Staffsalary;
import com.neu.pojo.User;
import com.neu.service.BonusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BonusServiceImpl implements BonusService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BonusMapper bonusMapper;
    @Autowired
    private DeptMapper deptMapper;

    /**
     * 员工信息展示
     * @return
     */
    public List<UserVO> list() {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        lqw.eq(User::getUsertype,3);
        List<User> users = userMapper.selectList(lqw);
        List<UserVO> userVOList = new ArrayList<>();
        for (User user : users) {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(user, userVO);
            Dept dept = deptMapper.selectById(user.getDeptid());
            userVO.setDeptName(dept.getName());
            //获取底薪
            LambdaQueryWrapper<Staffsalary> lqwSs = new LambdaQueryWrapper<Staffsalary>();
            lqwSs.eq(Staffsalary::getId,user.getId()).eq(Staffsalary::getTypetype,"0");
            Staffsalary staffsalary = bonusMapper.selectOne(lqwSs);
            userVO.setMoney(staffsalary.getMoney());
            userVOList.add(userVO);
        }
        return userVOList;
    }

    /**
     * 加奖金
     * @param bonusDTO
     * @return
     */
    public void plus(BonusDTO bonusDTO) {
        Staffsalary staffsalary = new Staffsalary();
        BeanUtils.copyProperties(bonusDTO,staffsalary);
        staffsalary.setTypetype("1");
        staffsalary.setUpdate_time(LocalDate.now());
        bonusMapper.insert(staffsalary);
    }

    /**
     * 扣钱
     * @param bonusDTO
     * @return
     */
    public void sub(BonusDTO bonusDTO) {
        Staffsalary staffsalary = new Staffsalary();
        BeanUtils.copyProperties(bonusDTO,staffsalary);
        staffsalary.setTypetype("2");
        staffsalary.setUpdate_time(LocalDate.now());
        bonusMapper.insert(staffsalary);
    }

    /**
     * 修改底薪
     * @param bonusDTO
     * @return
     */
    public void update(BonusDTO bonusDTO) {
        Staffsalary staffsalary = new Staffsalary();
        BeanUtils.copyProperties(bonusDTO,staffsalary);
        staffsalary.setUpdate_time(LocalDate.now());
        staffsalary.setReason("底薪");
        LambdaQueryWrapper<Staffsalary> lqw = new LambdaQueryWrapper<Staffsalary>();
        lqw.eq(Staffsalary::getTypetype,"0").eq(Staffsalary::getId,bonusDTO.getId());
        bonusMapper.update(staffsalary,lqw);
    }
}

package com.neu.service.Impl;

import com.neu.dto.InfoDTO;
import com.neu.vo.InfoVO;
import com.neu.mapper.DeptMapper;
import com.neu.mapper.UserMapper;
import com.neu.pojo.Dept;
import com.neu.pojo.User;
import com.neu.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DeptMapper deptMapper;

    /**
     * 查询个人信息
     * @param id
     * @return
     */
    public InfoVO getInfo(Integer id) {
        User user = userMapper.selectById(id);
        Dept dept = deptMapper.selectById(user.getDeptid());
        InfoVO infoVO = new InfoVO();
        BeanUtils.copyProperties(user, infoVO);
        infoVO.setDept(dept.getName());
        return infoVO;
    }

    /**
     * 修改个人信息
     * @param infoDTO
     * @return
     */
    public void update(InfoDTO infoDTO) {
        User user = new User();
        BeanUtils.copyProperties(infoDTO,user);
        userMapper.updateById(user);
    }
}

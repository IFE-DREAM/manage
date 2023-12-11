package com.neu.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.neu.dto.LoginDTO;
import com.neu.mapper.LoginMapper;
import com.neu.pojo.User;
import com.neu.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    /**
     * 用户登录
     * @param
     * @return
     */
    public String login(LoginDTO loginDTO) {
        char type = '0';
        switch (loginDTO.getUsertype()){
            case "admin":
                type = '1';
                break;
            case "hr":
                type = '2';
                break;
            case "employee":
                type = '3';
                break;
        }
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        lqw.eq(User::getId,loginDTO.getUsername()).eq(User::getPassword,loginDTO.getPassword()).eq(User::getUsertype,type);
        User user = loginMapper.selectOne(lqw);

        return user.getId().toString();
    }
}

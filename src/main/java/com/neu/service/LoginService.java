package com.neu.service;

import com.neu.dto.LoginDTO;

/**
 * 用户登录
 * @param
 * @return
 */
public interface LoginService {
    String login(LoginDTO loginDTO);
}

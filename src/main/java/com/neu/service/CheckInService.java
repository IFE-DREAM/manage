package com.neu.service;

import com.neu.pojo.Result;

public interface CheckInService {

    /**
     * 查询签到状态
     * @param id
     * @return
     */
    Integer getCheck(Integer id);

    /**
     * 进行签到
     * @param id
     * @return
     */
    Result check(Integer id);
}

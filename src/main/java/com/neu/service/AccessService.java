package com.neu.service;

import com.neu.dto.AccessDTO;
import com.neu.pojo.Attendrecord;

import java.util.List;

public interface AccessService {

    /**
     * 审批列表展示
     * @return
     */
    List<Attendrecord> list(String type);

    /**
     * 设置金额
     * @param accessDTO
     * @return
     */
    void set(AccessDTO accessDTO);
}

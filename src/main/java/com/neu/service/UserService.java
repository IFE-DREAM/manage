package com.neu.service;


import com.neu.dto.InfoDTO;
import com.neu.vo.InfoVO;


public interface UserService {
    /**
     * 查询个人信息
     * @param id
     * @return
     */
    InfoVO getInfo(Integer id);

    /**
     * 修改个人信息
     * @param infoDTO
     * @return
     */
    void update(InfoDTO infoDTO);
}

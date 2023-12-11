package com.neu.service;

import com.neu.dto.BonusDTO;
import com.neu.vo.UserVO;

import java.util.List;

public interface BonusService {
    /**
     * 员工信息展示
     * @return
     */
    List<UserVO> list();

    /**
     * 加奖金
     * @param bonusDTO
     * @return
     */
    void plus(BonusDTO bonusDTO);

    /**
     * 扣钱
     * @param bonusDTO
     * @return
     */
    void sub(BonusDTO bonusDTO);

    /**
     * 修改底薪
     * @param bonusDTO
     * @return
     */
    void update(BonusDTO bonusDTO);
}

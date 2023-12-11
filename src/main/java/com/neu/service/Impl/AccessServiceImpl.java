package com.neu.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.neu.dto.AccessDTO;
import com.neu.mapper.AccessMapper;
import com.neu.pojo.Attendrecord;
import com.neu.service.AccessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AccessServiceImpl implements AccessService {

    @Autowired
    private AccessMapper accessMapper;

    /**
     * 审批列表展示
     * @return
     */
    public List<Attendrecord> list(String type) {
        LambdaQueryWrapper<Attendrecord> lqw = new LambdaQueryWrapper<Attendrecord>();
        lqw.eq(Attendrecord::getReasontype,type);
        List<Attendrecord> list = accessMapper.selectList(lqw);
        return list;
    }

    /**
     * 设置金额
     * @param accessDTO
     * @return
     */
    public void set(AccessDTO accessDTO) {
        LambdaQueryWrapper<Attendrecord> lqw = new LambdaQueryWrapper<Attendrecord>();
        lqw.eq(Attendrecord::getIdid,accessDTO.getIdid());
        Attendrecord ar = new Attendrecord();
        BeanUtils.copyProperties(accessDTO,ar);
        accessMapper.update(ar,lqw);
    }
}

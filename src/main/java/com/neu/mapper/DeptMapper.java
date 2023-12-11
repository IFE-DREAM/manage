package com.neu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neu.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper extends BaseMapper<Dept> {
    //@Select("select * from dept")
    List<Dept> list();

    int add(Dept dept);
}

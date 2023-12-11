package com.neu.service;

import com.neu.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> list();
    int add(Dept dept);

}

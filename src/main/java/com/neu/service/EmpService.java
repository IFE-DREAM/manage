package com.neu.service;

import com.neu.pojo.Result;

public interface EmpService {
    Result list(int eid);
    Result getsalary(int id);

    Result qingjia(Integer id,String reason);

    Result jiaban(Integer id,String reason);

    Result getchidaoList(Integer id);

    Result postchidaoReason(Integer idid,String reason);

    Result personinfo(Integer id);
}

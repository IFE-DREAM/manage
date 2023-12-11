package com.neu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String password;
    private String usertype;
    private String sex;
    private Integer deptid;
    private String job;
    private Double salary;
    private String phone;
    private String email;
    private LocalDateTime birthday;
    private Integer workstatus;
}

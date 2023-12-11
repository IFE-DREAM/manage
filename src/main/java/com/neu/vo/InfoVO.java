package com.neu.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfoVO {
    private Integer id;
    private String name;
    private String password;
    private String sex;
    private String dept;
    private String job;
    private String phone;
    private String email;
    private LocalDateTime birthday;
}

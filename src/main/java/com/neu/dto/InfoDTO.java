package com.neu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfoDTO {
    private Integer id;
    private String name;
    private String password;
    private String sex;
    private String phone;
    private String email;
    private LocalDateTime birthday;
}

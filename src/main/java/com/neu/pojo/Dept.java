package com.neu.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
    private Integer id;
    private String name;
    @TableField(value = "createTime")
    private LocalDateTime createTime;
    @TableField(value = "updateTime")
    private LocalDateTime updateTime;
}

package com.neu.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attendrecord {
    private int idid;
    private Integer eid;
    private String reasontype;
    private String reason;
    private float money;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @TableField(value = "createTime")
    private LocalDateTime createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @TableField(value = "changeTime")
    private LocalDateTime changeTime;
}

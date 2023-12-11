package com.neu.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Staffsalary {
    private Integer id;
    private String typetype;
    private String reason;
    private float money;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate update_time;
}

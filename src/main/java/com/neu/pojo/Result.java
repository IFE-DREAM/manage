package com.neu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private int code;
    private String msg;
    private Object data;


    public static Result success(){
        return new Result(200,"success",null);
    }

    public static Result success(Object data){
        return new Result(200,"success",data);
    }
    public static Result error(String msg){
        return new Result(0,msg,null);
    }
}
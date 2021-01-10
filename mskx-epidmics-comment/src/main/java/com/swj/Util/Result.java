package com.swj.Util;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 通用返回类
 * 使用方式：R.success().data("","").data("","");
 * @param <T>
 */
@Data
public class Result<T> implements Serializable  {

    private Boolean success;

    private Integer code;

    private String message;

    private Map<String, Object> data=new HashMap<>();

    private Result() {
    }

    public static Result success(){
        Result r=new Result();
        r.setSuccess(true);
        r.setCode(StatusCode.SUCCESS);
        r.setMessage("成功返回了信息");
        return r;
    }

    public static Result error(){
        Result r=new Result();
        r.setSuccess(false);
        r.setCode(StatusCode.ERROR);
        r.setMessage("失败了");
        return r;
    }


    public Result success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public Result message(String message){
        this.setMessage(message);
        return this;
    }

    public Result code(Integer code){
        this.setCode(code);
        return this;
    }

    public Result data(String key, Object value){
        this.data.put(key,value);
        return this;
    }


    public Result data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}

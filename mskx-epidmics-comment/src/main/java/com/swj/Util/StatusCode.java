package com.swj.Util;

/**
 * 返回状态码
 */
public interface StatusCode {
    public static Integer SUCCESS=200;
    public static Integer ERROR=400;
    //401未登录
    public static Integer NO_LOGIN=401;
    //50008:非法令牌；50012:其他客户端登录；50014:令牌过期；
    //50008: Illegal token; 50012: Other clients logged in; 50014: Token expired;
    public static Integer Illegal_TOKEN=50008;
    public static Integer Other_clients_logged_in=50008;
    public static Integer Token_expired=50008;
}

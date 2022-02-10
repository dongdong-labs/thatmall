package org.onedayday.framework.result;

import java.io.Serializable;

/**
 * @program: framework
 * @class: Result
 * @description:
 * @author: wdd
 * @create: 2022-02-10 09:40
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -1L;

    private boolean success = true;
    private String code;
    private String msg = "SUCCESS";
    private T data;

    private Result() {

    }

    private Result(boolean success, String code, String msg, T data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result success() {
        Result result = new Result(true, "200", "", (Object) null);
        return result;
    }

    public static <T> Result success(String msg) {
        Result result = new Result(true, "200", msg, (Object) null);
        return result;
    }

    public static <T> Result success(String msg, T data) {
        Result result = new Result(true, "200", msg, data);
        return result;
    }

    public static <T> Result success(String code, String msg) {
        Result result = new Result(true, code, msg, (Object) null);
        return result;
    }

    public static <T> Result data(T data) {
        Result result = new Result(true, "200", "", data);
        return result;
    }

    public static <T> Result success(String code, String msg, T data) {
        Result result = new Result(true, code, msg, data);
        return result;
    }

    public static Result fail(String code, String errorMsg) {
        Result result = new Result(false, code, errorMsg, null);
        return result;
    }

    public static Result fail(String errorMsg) {
        Result result = new Result(false, "-1", errorMsg, null);
        return result;
    }
}

package com.example.demo.entity;

public class Result<T> {
    /*错误码*/
    private Integer code;

    /*提示信息 */
    private String message;

    /*具体内容*/
    private T data;
    private String successful;
    private Integer id;



    public String getSuccessful() {
        return successful;
    }

    public void setSuccessful(String successful) {
        this.successful = successful;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Result(String successful, Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = (T) data;
        this.successful = successful;
    }

    public Result(String successful, Integer code, String message, Integer id) {
        this.code = code;
        this.message = message;
        this.id = id;
        this.successful = successful;
    }

    public Result(String successful, Integer code, String message) {
        this.code = code;
        this.message = message;
        this.successful = successful;
    }

}

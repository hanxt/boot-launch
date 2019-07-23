package com.zimug.bootlaunch.config.exception;

public class ModelViewException extends RuntimeException{

    //异常错误编码
    private int code ;
    //异常信息
    private String message;

    public static ModelViewException transfer(CustomException e) {
        return new ModelViewException(e.getCode(),e.getMessage());
    }

    private ModelViewException(int code, String message){
        this.code = code;
        this.message = message;
    }

    int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}

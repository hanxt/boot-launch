package com.zimug.bootlaunch.service;

import com.zimug.bootlaunch.config.exception.CustomException;
import com.zimug.bootlaunch.config.exception.CustomExceptionType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExceptionService {

    //服务层，模拟系统异常
    public void systemBizError() throws CustomException {
        try {
            Class.forName("com.mysql.jdbc.xxxx.Driver");
        } catch (ClassNotFoundException e) {
            throw new CustomException(CustomExceptionType.SYSTEM_ERROR,"在XXX业务，myBiz()方法内，出现ClassNotFoundException");
        }
    }

     //服务层，模拟用户输入数据导致的校验异常
    public List<String> userBizError(int input) throws CustomException {
        if(input < 0){ //模拟业务校验失败逻辑
            throw new CustomException(CustomExceptionType.USER_INPUT_ERROR,"您输入的数据不符合业务逻辑，请确认后重新输入！");
        }else{ //
            List<String> list = new ArrayList<>();
            list.add("科比");
            list.add("詹姆斯");
            list.add("库里");
            return list;
        }
    }

}
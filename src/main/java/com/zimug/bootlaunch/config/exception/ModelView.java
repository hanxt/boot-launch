package com.zimug.bootlaunch.config.exception;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})//只能在方法上使用此注解
public @interface ModelView {

}
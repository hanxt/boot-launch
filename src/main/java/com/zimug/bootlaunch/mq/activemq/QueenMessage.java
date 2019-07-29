package com.zimug.bootlaunch.mq.activemq;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class QueenMessage implements Serializable {

    private String title;

    private String content;

}
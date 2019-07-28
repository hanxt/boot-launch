package com.zimug.bootlaunch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@RequestMapping("sse")
public class SSEControler {

    public static final ConcurrentHashMap<Long,SseEmitter> sseEmitters = new ConcurrentHashMap<>();


    @GetMapping("/test")
    public String ssetest(){
        return "ssetest";
    }

    @GetMapping("/orderpay")
    public SseEmitter orderpay(){
        Long payRecordId = 1L;
        //设置默认的超时时间60秒
        final SseEmitter emitter = new SseEmitter(60 * 1000L);
        try {
            System.out.println("连接建立成功");
            //TODO 这里可以做一些订单保存的操作
            sseEmitters.put(payRecordId,emitter);
        }catch (Exception e){
            emitter.completeWithError(e);
        }

        return emitter;
    }


    @GetMapping("/payback")
    public @ResponseBody
    String payback (){

        SseEmitter emitter = sseEmitters.get(1L);
        try {
            emitter.send("支付成功");

            System.out.println("发送finish事件");
            emitter.send(SseEmitter.event().name("finish").id("6666").data("哈哈"));
            System.out.println("调用complete");
            emitter.complete();
        } catch (IOException e) {
            emitter.completeWithError(e);
        }
        return "ok";
    }
}
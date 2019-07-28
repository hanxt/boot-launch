package com.zimug.bootlaunch.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * WebSocket服务端示例
 */
@Component
@Slf4j
@ServerEndpoint(value = "/ws/asset")
public class WebSocketServer {  
  
    private static final AtomicInteger OnlineCount = new AtomicInteger(0);
    // concurrent包的线程安全Set，用来存放每个客户端对应的Session对象。  
    private static CopyOnWriteArraySet<Session> SessionSet = new CopyOnWriteArraySet<>();
  
  
    /** 
     * 连接建立成功调用的方法 
     */  
    @OnOpen
    public void onOpen(Session session) throws IOException {
        SessionSet.add(session);   
        int cnt = OnlineCount.incrementAndGet(); // 在线数加1  
        log.info("有连接加入，当前连接数为：{}", cnt);  
        SendMessage(session, "连接成功");  
    }  
  
    /** 
     * 连接关闭调用的方法 
     */  
    @OnClose
    public void onClose(Session session) {  
        SessionSet.remove(session);  
        int cnt = OnlineCount.decrementAndGet();  
        log.info("有连接关闭，当前连接数为：{}", cnt);  
    }  
  
    /** 
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     */  
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        log.info("来自客户端的消息：{}",message);  
        SendMessage(session, "收到消息，消息内容："+message);
    }  
  
    /** 
     * 出现错误
     */  
    @OnError
    public void onError(Session session, Throwable error) {  
        log.error("发生错误：{}，Session ID： {}",error.getMessage(),session.getId());
    }  
  
    /** 
     * 发送消息，实践表明，每次浏览器刷新，session会发生变化。 
     * @param session  session
     * @param message  消息
     */  
    private static void SendMessage(Session session, String message) throws IOException {

        session.getBasicRemote().sendText(String.format("%s (From Server，Session ID=%s)",message,session.getId()));

    }  
  
    /** 
     * 群发消息 
     * @param message  消息
     */  
    public static void BroadCastInfo(String message) throws IOException {
        for (Session session : SessionSet) {  
            if(session.isOpen()){  
                SendMessage(session, message);  
            }  
        }  
    }  
  
    /** 
     * 指定Session发送消息
     * @param sessionId sessionId
     * @param message  消息
     */  
    public static void SendMessage(String sessionId,String message) throws IOException {  
        Session session = null;  
        for (Session s : SessionSet) {  
            if(s.getId().equals(sessionId)){  
                session = s;  
                break;  
            }  
        }  
        if(session!=null){  
            SendMessage(session, message);  
        } else{
            log.warn("没有找到你指定ID的会话：{}",sessionId);  
        }  
    }  
      
} 
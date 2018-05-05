package com.djl.controller;

import java.io.IOException;
import java.util.Vector;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@ServerEndpoint("/testWebSocket")
@Component
public class WebSocketTest { 
	private Session session;
	private static Vector<WebSocketTest> list = new Vector<WebSocketTest>();
	private static final Logger logger =LoggerFactory.getLogger(WebSocketTest.class);
	@OnOpen
	public void open(Session session) {
		this.session = session;
		list.add(this);
		logger.info("连接成功"+session.getId());
	}
	@OnClose
	public void close(Session session) {
		list.remove(this);
		logger.info("连接断开"+session.getId());
	}
	@OnMessage
	public void onMessage(String message,Session session) {
		/**
		 * 将某一个客户端发送的信息返回给所有人
		 */
		logger.info("接收的信息"+message);
		for(WebSocketTest test : list) {
			try {
				test.session.getBasicRemote().sendText(message);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	@OnError  
    public void onError(Session session, Throwable error){  
        logger.info("发生错误"+session.getId());  
        error.printStackTrace();  
    }  
}

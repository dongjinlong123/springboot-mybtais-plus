package com.djl.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

/**
 * 聊天室
 * @author 90411
 *
 */
@ServerEndpoint("/chatroom")
@Component
public class ChatRoom {
		//当一个客户端访问onlineServer连接的时候，创建一个OnlineServer的实例
		private Session session;//当前的会话对象 通过session 服务器可以向客户端主动发送消息
		//建立一个静态的集合来存储所有客户端的实例
		public static Vector<ChatRoom> clients = new Vector<ChatRoom>();
		
		public static Set<String> showcount=new HashSet<String>();
		public static Set<String> livecount=new HashSet<String>();

		
		
		/**
		 * 
		* @Title: onOpen 
		* @Description: 当客户端与服务器建立连接的时候触发方法
		* @param session    设定文件 
		* @return void    返回类型 
		* @throws
		 */
		@OnOpen
		public void onOpen(Session session){
			this.session = session;
			clients.add(this);//将当前客户端加入客户端列表
			System.out.println("新连接连接！！");
			sendNum();
		}

		@OnClose
		public void onClose(Session session){
			clients.remove(this);
			System.out.println("有一个连接关闭！！");
			removeCount(session);
			sendNum();
		}
		//当客户端向服务器发送消息的时候触发的事件
		@OnMessage
		public void onMessage(String message,Session session){
			if(addCount(message, session)) {
				sendNum();
				return;
			}
			//群发消息 广播消息
			for(ChatRoom client : clients){
				try {
					//这是往客户端发送消息
					String json = "{\"name\":\"msg\",\"info\":\""+message +"\"}";
					client.session.getBasicRemote().sendText(json);
				} catch (IOException e) {
				
				}
			}
		}

		private synchronized boolean addCount(String message ,Session session) {
			if("show1".equals(message)) {
				showcount.add(session.getId());
				return true;
			}
			if("live1".equals(message)) {
				livecount.add(session.getId());
				return true;
			}
			if("live2".equals(message)) {
				livecount.remove(session.getId());
				return true;
			}
			if("show2".equals(message)) {
				showcount.remove(session.getId());
				return true;
			}
			return false;
		}
		private synchronized void removeCount(Session session) {
			if(showcount.contains(session.getId())) {
				showcount.remove(session.getId());
			}
			if(livecount.contains(session.getId())) {
				livecount.remove(session.getId());
			}
		}
		
		private synchronized void sendNum() {
			for(ChatRoom client : clients){
				try {
					//这是往客户端发送消息
					String json1 = "{\"name\":\"num1\",\"info\":"+showcount.size() +"}";
					client.session.getBasicRemote().sendText(json1);
					String json2 = "{\"name\":\"num2\",\"info\":"+livecount.size() +"}";
					client.session.getBasicRemote().sendText(json2);
				} catch (IOException e) {
				
				}
			}
		}
}

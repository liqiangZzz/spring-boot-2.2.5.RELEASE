package com.lq.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @ClassName MessageListener
 * @Description 监听者
 * @Author liqiang
 * @Date 2025/11/20 10:57
 */
public class MessageListener implements Observer {

	private String listenerName;

	public MessageListener(String name) {
		this.listenerName = name;
	}

	@Override
	public void update(Observable observable, Object arg) {
		if (observable instanceof MessagePublisher) {
			MessagePublisher publisher = (MessagePublisher) observable;

			if (arg != null) {
				// 推模式：直接使用传递过来的数据
				System.out.println("[" + listenerName + "] 收到消息(推模式): " + arg);
			} else {
				// 拉模式：主动从被观察者获取数据
				String message = publisher.getLatestMessage();
				System.out.println("[" + listenerName + "] 收到消息(拉模式): " + message);
			}
		}
	}

	public String getListenerName() {
		return listenerName;
	}
}

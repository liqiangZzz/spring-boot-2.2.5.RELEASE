package com.lq.observer;

import java.util.Observable;

/**
 * @ClassName MessagePublisher
 * @Description 观察者模式发布者
 * @Author liqiang
 * @Date 2025/11/20 10:55
 */
public class MessagePublisher extends Observable {

	private String message;

	/**
	 * 发布新消息
	 */
	public void publishMessage(String newMessage) {
		this.message = newMessage;
		System.out.println("发布器: 发布消息 -> " + newMessage);
		// 必须调用 setChanged() 来标记状态改变
		setChanged();
		// 通知所有观察者，传递消息内容
		notifyObservers(newMessage);
	}


	/**
	 * 发布消息但不传递数据（观察者需要主动拉取）
	 */
	public void publishWithoutData() {
		setChanged();
		notifyObservers(); // 不传递参数
	}


	public String getLatestMessage() {
		return message;
	}
}

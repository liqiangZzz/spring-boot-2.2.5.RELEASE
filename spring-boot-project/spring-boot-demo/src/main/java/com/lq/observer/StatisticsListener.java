package com.lq.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @ClassName StatisticsListener
 * @Description 统计监听器
 * @Author liqiang
 * @Date 2025/11/20 10:59
 */
public class StatisticsListener implements Observer {
	private int messageCount = 0;

	public StatisticsListener() {
	}

	@Override
	public void update(Observable observable, Object arg) {
		messageCount++;

		if (arg instanceof String) {
			String message = (String) arg;
			System.out.println("[统计器] 第 " + messageCount + " 条消息: \"" +
					message + "\" (长度: " + message.length() + ")");
		}
	}

	public int getMessageCount() {
		return messageCount;
	}
}

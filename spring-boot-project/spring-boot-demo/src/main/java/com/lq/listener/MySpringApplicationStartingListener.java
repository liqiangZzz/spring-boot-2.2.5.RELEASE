package com.lq.listener;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/**
 * @ClassName MySpringApplicationStartingListener
 * @Description 启动时监听器
 * @Author liqiang
 * @Date 2025/11/20 11:15
 */
public class MySpringApplicationStartingListener implements ApplicationListener<ApplicationStartingEvent> {

	@Override
	public void onApplicationEvent(ApplicationStartingEvent event) {
		System.out.println("自定义启动时监听器"+  event);
	}
}

package com.lq.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @ClassName MySpringApplicationListener
 * @Description 自定义SpringApplication启动监听器
 * @Author liqiang
 * @Date 2025/11/20 11:12
 */
public class MySpringApplicationListener  implements ApplicationListener<ApplicationEvent> {
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("自定义全局监听器"+  event);
	}
}

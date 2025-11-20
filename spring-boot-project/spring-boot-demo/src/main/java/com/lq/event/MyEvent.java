package com.lq.event;

import org.springframework.context.ApplicationEvent;

/**
 * @ClassName MyEvent
 * @Description 自定义事件
 * @Author liqiang
 * @Date 2025/11/20 11:17
 */
public class MyEvent extends ApplicationEvent {


	public MyEvent(Object source) {
		super(source);
	}
}

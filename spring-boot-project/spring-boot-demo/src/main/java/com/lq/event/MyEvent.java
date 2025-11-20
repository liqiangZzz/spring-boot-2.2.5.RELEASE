package com.lq.event;

import org.springframework.context.ApplicationEvent;

/**
 * @ClassName MyEvent
 * @Description 自定义事件
 * @Author liqiang
 * @Date 2025/11/20 11:17
 */
public class MyEvent extends ApplicationEvent {

	/**
	 * Create a new {@code ApplicationEvent}.
	 *
	 * @param source the object on which the event initially occurred or with
	 *               which the event is associated (never {@code null})
	 */
	public MyEvent(Object source) {
		super(source);
	}
}

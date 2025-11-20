package com.lq.controller;

import com.lq.event.MyEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName BusinessEventController
 * @Description 测试自定义事件
 * @Author liqiang
 * @Date 2025/11/20 11:19
 */
@RestController
public class BusinessEventController {

	@Resource
	private ApplicationEventPublisher applicationEventPublisher;


	@GetMapping("/event")
	public String testEvent() {
		// 发送事件
		MyEvent event = new MyEvent("liqiang");
		// 发送事件
		applicationEventPublisher.publishEvent(event);
		return "success";
	}
}

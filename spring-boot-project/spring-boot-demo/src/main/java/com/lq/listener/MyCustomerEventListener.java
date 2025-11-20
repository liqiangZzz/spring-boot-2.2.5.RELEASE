package com.lq.listener;

import com.lq.event.MyEvent;
import org.springframework.context.ApplicationListener;

/**
 * @ClassName MyCustomerEventListener
 * @Description  自定义业务事件
 * @Author liqiang
 * @Date 2025/11/20 11:16
 */
public class MyCustomerEventListener implements ApplicationListener<MyEvent> {
	@Override
	public void onApplicationEvent(MyEvent event) {
		System.out.println("自定义业务事件: " + event);
	}
}

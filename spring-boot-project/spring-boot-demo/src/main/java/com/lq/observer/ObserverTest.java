package com.lq.observer;

/**
 * @ClassName ObserverTest
 * @Description
 * @Author liqiang
 * @Date 2025/11/20 11:00
 */
public class ObserverTest {

	public static void main(String[] args) {
		System.out.println("=== 开始观察者模式演示 ===\n");

		// 1. 创建被观察者
		MessagePublisher publisher = new MessagePublisher();

		// 2. 创建观察者
		MessageListener listener1 = new MessageListener("监听器A");
		MessageListener listener2 = new MessageListener("监听器B");
		StatisticsListener statsListener = new StatisticsListener();

		// 3. 注册观察者
		System.out.println("注册观察者...");
		publisher.addObserver(listener1);
		publisher.addObserver(listener2);
		publisher.addObserver(statsListener);

		System.out.println("当前观察者数量: " + publisher.countObservers() + "\n");

		// 4. 发布消息 - 推模式
		System.out.println("--- 推模式测试 ---");
		publisher.publishMessage("Hello World!");
		System.out.println();

		publisher.publishMessage("这是一条测试消息");
		System.out.println();

		// 5. 发布消息 - 拉模式
		System.out.println("--- 拉模式测试 ---");
		publisher.publishWithoutData();
		System.out.println();

		// 6. 移除一个观察者
		System.out.println("移除监听器A...");
		publisher.deleteObserver(listener1);
		System.out.println("当前观察者数量: " + publisher.countObservers() + "\n");

		// 7. 再次发布消息
		System.out.println("--- 移除后的测试 ---");
		publisher.publishMessage("最后一条消息");

		System.out.println("\n=== 演示结束 ===");
	}
}

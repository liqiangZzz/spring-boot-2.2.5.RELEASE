/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.context.config;

import java.util.Set;
import java.util.function.Consumer;

import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

/**
 * Internal {@link PropertySource} implementation used by
 * {@link ConfigFileApplicationListener} to filter out properties for specific operations.
 *
 * @author Phillip Webb
 */
class FilteredPropertySource extends PropertySource<PropertySource<?>> {

	private final Set<String> filteredProperties;

	FilteredPropertySource(PropertySource<?> original, Set<String> filteredProperties) {
		super(original.getName(), original);
		this.filteredProperties = filteredProperties;
	}

	@Override
	public Object getProperty(String name) {
		if (this.filteredProperties.contains(name)) {
			return null;
		}
		return getSource().getProperty(name);
	}

	/**
	 * 应用指定操作到配置环境中的特定属性源，支持过滤特定属性
	 *
	 * @param environment 配置环境对象，用于获取和操作属性源
	 * @param propertySourceName 要操作的属性源名称
	 * @param filteredProperties 需要过滤的属性集合
	 * @param operation 要应用的操作，接受一个PropertySource对象作为参数
	 */
	static void apply(ConfigurableEnvironment environment, String propertySourceName, Set<String> filteredProperties,
			Consumer<PropertySource<?>> operation) {
		// 获取当前环境下的所有的资源加载器
		MutablePropertySources propertySources = environment.getPropertySources();
		// 根据propertySourceName从众多的加载器中获取对应的加载器 默认的没有
		PropertySource<?> original = propertySources.get(propertySourceName);
		if (original == null) {
			operation.accept(null);
			return;
		}
		// 创建过滤后的属性源并替换原属性源
		propertySources.replace(propertySourceName, new FilteredPropertySource(original, filteredProperties));
		try {
			operation.accept(original);
		}
		finally {
			// 操作完成后恢复原始属性源
			propertySources.replace(propertySourceName, original);
		}
	}

}

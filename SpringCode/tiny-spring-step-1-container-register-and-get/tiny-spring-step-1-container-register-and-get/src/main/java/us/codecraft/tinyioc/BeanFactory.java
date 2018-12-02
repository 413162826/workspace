package us.codecraft.tinyioc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Bean工厂，IOC容器储存Bean，注入Bean
 */
public class BeanFactory {

	private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

	public Object getBean(String name) {
		return beanDefinitionMap.get(name).getBean();
	}

	public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
		beanDefinitionMap.put(name, beanDefinition);
	}

}

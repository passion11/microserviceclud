package com.myrule;

import java.util.List;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

/**
 * 用户每访问一次consumer系统,就加载一次该类(自定义ribbon策略)
 * 
 * @author apple
 *
 */
public class RandomRule_ZY extends AbstractLoadBalancerRule {

	private int total = 0;
	private int currentIndex = 0;

	public Server choose(ILoadBalancer ilb, Object object) {
		// ILoadBalancer:负载均衡算法.
		// 一般不会为null,因为他至少要加载一个默认算法(轮循算法)
		if (ilb == null) {
			return null;
		}
		Server server = null;
		while (server == null) {
			// 如果访问过程中,线程被中断了,返回Null
			if (Thread.interrupted()) {
				return null;
			}
			// 获取可用的服务
			List<Server> upList = ilb.getReachableServers();
			// 以下表示该eureka服务器上没有指定要访问的服务
			if (ilb.getAllServers().size() == 0) {
				return null;
			}
			// eureka集群中每个服务响应5次,然后换下一个同一
			// 服务名下不同端口号的服务,以此循环3次
			if (total < 5) {
				total++;
			} else {
				currentIndex++;
				total = 0;
				if (currentIndex >= upList.size()) {
					currentIndex = 0;
				}
			}
			server = upList.get(currentIndex);
		}
		return server;
	}

	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig arg0) {
	}

}

package com.plan.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.alibaba.dubbo.rpc.Exporter;

@Configuration
@ConditionalOnClass(Exporter.class)
@PropertySource(value = "classpath:/dubbo.properties")
public class DubboConfiguration {

	@Value("${dubbo.application.name}")
	private String applicationName;

	@Value("${dubbo.application.logger}")
	private String logger;

	@Value("${dubbo.registr.protocol}")
	private String protocol;

	@Value("${dubbo.registry.address}")
	private String registryAddress;

	@Value("${dubbo.protocol.name}")
	private String protocolName;

	@Value("${dubbo.protocol.port}")
	private int protocolPort;

	@Value("${dubbo.provider.timeout}")
	private int timeout;

	@Value("${dubbo.provider.retries}")
	private int retries;

	@Value("${dubbo.provider.delay}")
	private int delay;

	@Bean
	public static AnnotationBean annotationBean(@Value("${dubbo.annotation.package}") String packageName) {
		AnnotationBean annotationBean = new AnnotationBean();
		annotationBean.setPackage(packageName);
		return annotationBean;
	}

	/**
	 * 注入dubbo上下文
	 * 
	 * @return
	 */
	@Bean
	public ApplicationConfig applicationConfig() {
		// 当前应用配置
		ApplicationConfig applicationConfig = new ApplicationConfig();
		applicationConfig.setName(this.applicationName);
		return applicationConfig;
	}

	/**
	 * 注入dubbo注册中心配置,基于zookeeper
	 * 
	 * @return
	 */
	@Bean
	public RegistryConfig registryConfig() {
		// 连接注册中心配置
		RegistryConfig registry = new RegistryConfig();
		registry.setProtocol(protocol);
		registry.setAddress(registryAddress);
		return registry;
	}

	/**
	 * 默认基于dubbo协议提供服务
	 * 
	 * @return
	 */
	@Bean
	public ProtocolConfig protocolConfig() {
		// 服务提供者协议配置
		ProtocolConfig protocolConfig = new ProtocolConfig();
		protocolConfig.setName(protocolName);
		protocolConfig.setPort(protocolPort);
		protocolConfig.setThreads(200);
		return protocolConfig;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getLogger() {
		return logger;
	}

	public void setLogger(String logger) {
		this.logger = logger;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getRegistryAddress() {
		return registryAddress;
	}

	public void setRegistryAddress(String registryAddress) {
		this.registryAddress = registryAddress;
	}

	public String getProtocolName() {
		return protocolName;
	}

	public void setProtocolName(String protocolName) {
		this.protocolName = protocolName;
	}

	public int getProtocolPort() {
		return protocolPort;
	}

	public void setProtocolPort(int protocolPort) {
		this.protocolPort = protocolPort;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public int getRetries() {
		return retries;
	}

	public void setRetries(int retries) {
		this.retries = retries;
	} 

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}
	
}

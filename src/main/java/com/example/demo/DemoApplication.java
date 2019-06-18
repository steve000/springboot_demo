package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void customize(ConfigurableWebServerFactory factory) {
		/**
		 * 这把端口存入数据库中，即使项目打包了，修改数据库端口重启项目就行
		 * 可以从数据库中动态读取
		 */
		int port = 1024;
		factory.setPort(port);
	}

}

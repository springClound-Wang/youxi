package com.husheng.youxi.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Component
public class FreemarkerViewResolverConfiguration  implements  CommandLineRunner {
	

	@Autowired
	private FreeMarkerViewResolver resolver;

	//@PostConstruct
	public void init() {
		// 注册路由视图
		resolver.setViewClass(FreemarkerView.class);
	}


	@Override
	public void run(String... args) throws Exception {
		init();
	}
}
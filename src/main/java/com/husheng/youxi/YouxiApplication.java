package com.husheng.youxi;

import com.husheng.youxi.core.CommonInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@MapperScan("com.husheng.youxi.mapper")
public class YouxiApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(YouxiApplication.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(YouxiApplication.class);
    }

    
    
    @Bean
    public CommonInterceptor getCommonInterceptor(){
    	return  new CommonInterceptor();
    }
    
    @Bean
    public WebMvcConfigurer corConfiguration() {
    	return new WebMvcConfigurer() {

			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				 //registry.addInterceptor(getCommonInterceptor()).addPathPatterns("/**");
				 //registry.addInterceptor(authenticationInterceptor())
	             //.addPathPatterns("/api/**").excludePathPatterns("/api/login/**");    // 拦截所有请求，通过判断是否有 @LoginRequired 注解 决定是否需要登录
			}

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				//registry.addMapping("/api/**").allowedOrigins("https://api.husheng.youxi.net","https://www.husheng.youxi.net");
				registry.addMapping("/api/**").allowedOrigins("*");
			}
    		
		};
    }
}

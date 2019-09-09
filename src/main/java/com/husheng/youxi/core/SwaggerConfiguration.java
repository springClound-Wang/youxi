
 /**
 * husheng.youxi系统平台<br/>
 * com.husheng.youxi.config<br/>
 * SweggerConfiguration.java<br/>
 * 创建人:mofeng <br/>
 * 时间：2018年9月24日-下午5:35:07 <br/>
 * 2018husheng.youxi-版权所有<br/>
 */
package com.husheng.youxi.core;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * SweggerConfiguration<br/>
 * 创建人:mofeng<br/>
 * 时间：2018年9月24日-下午5:35:07 <br/>
 * @version 1.0.0<br/>
 * 
 */
@SpringBootConfiguration
@EnableSwagger2
public class SwaggerConfiguration {
	
	/**
	 * 在完成上述配置之后，其实就已经可以产生帮助文档了，但是这样的文档主要针对请求本身，而描述主要来源于函数等命名产生。
	 * 对用户体验不好，我们通常需要自己增加一些说明来丰富文档内容。如果：
	 * 加入
	 *  @ApiIgnore
		忽略暴露的 api
		
		@ApiOperation(value = "查找", notes = "根据用户 ID 查找用户")
		添加说明
		
		
		其他注解：
		@Api ：用在类上，说明该类的作用
		@ApiImplicitParams ：用在方法上包含一组参数说明
		@ApiResponses ：用于表示一组响应
		完成上述之后，启动springboot程序，访问：http://localhost:8080/swagger-ui.html
		
		
		@ApiOperation() 用于方法；表示一个http请求的操作 
		value用于方法描述 
		notes用于提示内容 
		tags可以重新分组（视情况而用） 
		@ApiParam() 用于方法，参数，字段说明；表示对参数的添加元数据（说明或是否必填等） 
		name–参数名 
		value–参数说明 
		required–是否必填
		
		@ApiModel()用于类 ；表示对类进行说明，用于参数用实体类接收 
		value–表示对象名 
		description–描述 
		都可省略 
		@ApiModelProperty()用于方法，字段； 表示对model属性的说明或者数据操作更改 
		value–字段说明 
		name–重写属性名字 
		dataType–重写属性类型 
		required–是否必填 
		example–举例说明 
		hidden–隐藏
		
		@ApiIgnore()用于类或者方法上，可以不被swagger显示在页面上 
		比较简单, 这里不做举例
		
		@ApiImplicitParam() 用于方法 
		表示单独的请求参数 
		@ApiImplicitParams() 用于方法，包含多个 @ApiImplicitParam 
		name–参数ming 
		value–参数说明 
		dataType–数据类型 
		paramType–参数类型 
		example–举例说明
	 */

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getApiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.husheng.youxi.controller"))
				.paths(PathSelectors.any())
				.build();
	}
	
	
	private ApiInfo getApiInfo() {

		return new ApiInfoBuilder()
         .title("APP项目数据接口")
         .description("欢迎大家，App制作使用Java语言的SpringBoot构建网站开发")
         .termsOfServiceUrl("http://www.husheng.youxi.net")
         .contact("汪正章")
         .version("1.0")
         .build();
	}

}

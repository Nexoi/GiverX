//package com;
//
//import org.springframework.boot.bind.RelaxedPropertyResolver;
//import org.springframework.context.EnvironmentAware;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.web.context.request.async.DeferredResult;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
///**
// * Created by neo on 28/02/2017.
// */
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig extends WebMvcConfigurerAdapter {
//
//    @Bean
//    public Docket demoApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
////                .groupName("giverbasic")
////                .genericModelSubstitutes(DeferredResult.class)
////                .useDefaultResponseMessages(false)
////                .forCodeGeneration(false)
////                .pathMapping("/") //根路径
////                .select()
//////                .paths(PathSelectors.regex("/user/.*"))//筛选展示的接口，使用PathSelectors.any()，展示所有接口
////                .paths(PathSelectors.any())//筛选展示的接口，使用PathSelectors.any()，展示所有接口
////                .build()
//                .apiInfo(demoApiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.seeu"))
//                .paths(PathSelectors.any())
//                .build()
//
//                ;
//    }
//
//    //api信息
//    private ApiInfo demoApiInfo() {
////        ApiInfo apiInfo = new ApiInfo("Giver",//大标题
////                "provide for UserOAuth, UserInfo, TaskInfo, FileSys",//小标题
////                "1.0",//版本
////                "1st of services",
////                "seeuxiaoyi@163.com",//作者
////                "SeeUTech",//链接显示文字
////                "http://www.seeucoco.com"//网站链接
////        );
//
//        return new ApiInfoBuilder()
//                .title("Giver")
//                .description("provide for UserOAuth, UserInfo, TaskInfo, FileSys")
//                .termsOfServiceUrl("seeuxiaoyi@163.com")
//                .contact("SeeUTech")
//                .version("1.0")
//                .build();
//    }
//
//}
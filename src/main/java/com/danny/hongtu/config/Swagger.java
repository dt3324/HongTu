package com.danny.hongtu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;


/**
 * @author danny
 */
@Configuration
@EnableSwagger2
public class Swagger{
   @Bean
   public Docket docket(){
       //添加head参数start
       ParameterBuilder tokenPar = new ParameterBuilder();
       List<Parameter> pars = new ArrayList<>();
       tokenPar.name("real_source_ip").description("本机局域网IP").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
       pars.add(tokenPar.build());

       return new Docket(DocumentationType.SWAGGER_2)
               .apiInfo(apiInfo())
             .select()
             .apis(RequestHandlerSelectors.basePackage("com.danny.hongtu.web.controller"))
             .paths(PathSelectors.any())
             .build()
             .globalOperationParameters(pars);
   }
   public ApiInfo apiInfo(){
       return new ApiInfoBuilder()
         .title("hongtu")
         .description("接口测试")
         .termsOfServiceUrl("")
         .version("1.0")
         .build();
   }
}
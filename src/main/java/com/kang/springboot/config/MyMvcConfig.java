package com.kang.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author klr
 * @create 2020-03-27-10:47
 */
@Configuration
//拓展SpringMVC
//@EnableWebMvc 这个不要随便加，// 加了这个就会全面接管springmvc，自动配置失效

public class MyMvcConfig  implements WebMvcConfigurer {

    //添加视图控制
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //这个地方配置了，就不用在controller中配@requestMapping了，甚至整个方法都可以删除！！！
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");

    }


    //自定义得国际化组件就生效了
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    //配置拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有请求    排除登录页面 静态资源也要放行
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/user/login","/asserts/**");
    }

}

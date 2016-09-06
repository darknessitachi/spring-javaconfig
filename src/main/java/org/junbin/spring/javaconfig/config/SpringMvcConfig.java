package org.junbin.spring.javaconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @author : Chung Junbin
 * @email : <a href="mailto:rekadowney@163.com">发送邮件</a>
 * @createDate : 2016-09-01 10:09
 * @description :
 * <pre>
 * 　　不使用 {@link EnableWebMvc} 注解而是直接继承于 {@link WebMvcConfigurationSupport} 或者
 * {@link DelegatingWebMvcConfiguration}，之后通过覆盖方法可以实现更多可选功能
 * </pre>
 */
@Configuration
@ComponentScan(basePackages = {"org.junbin.spring.javaconfig.controller"}, useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {
                Controller.class, ControllerAdvice.class
        })})
public class SpringMvcConfig extends WebMvcConfigurationSupport {

    private static final String resourceHandler = "/resources/**";
    private static final String resourceLocation = "/resources/";

    @Bean(name = "viewResolver")
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setContentType("text/html; charset=UTF-8");
        return viewResolver;
    }

    // 添加静态资源映射
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(resourceHandler).addResourceLocations(resourceLocation);
    }

    // 添加 default servlet 支持
    @Override
    protected void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}

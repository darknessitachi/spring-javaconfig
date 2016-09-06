package org.junbin.spring.javaconfig.config;

import ch.qos.logback.ext.spring.web.LogbackConfigListener;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EnumSet;

/**
 * @author : Chung Junbin
 * @email : <a href="mailto:rekadowney@163.com">发送邮件</a>
 * @createDate : 2016-09-01 10:20
 * @description :
 */
public class WebXmlConfig implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        // logback 监听器
        servletContext.setInitParameter("logbackConfigLocation", "classpath:logback/logback.xml");
        servletContext.addListener(LogbackConfigListener.class);

        // CharacterEncodingFilter 过滤器
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true);
        FilterRegistration.Dynamic characterEncodingConfig = servletContext.addFilter(
                "characterEncodingFilter", characterEncodingFilter
        );
        characterEncodingConfig.addMappingForUrlPatterns(
                EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE),// 这里限定所有客户端请求、服务器 forward、服务器 include 的请求全都需要经过 filter 处理
                false, // 在所有当前已经被声明的 Filter 的前面先匹配 URL
                "/*"
        );

        // OpenEntityManagerInViewFilter 过滤器，避免在页面上出现懒加载异常，如果我们全部使用 json 作为传输的话则可以不配置
        OpenEntityManagerInViewFilter openEntityManagerInViewFilter = new OpenEntityManagerInViewFilter();
        FilterRegistration.Dynamic openEntityManagerInViewConfig = servletContext.addFilter(
                "openEntityManagerInViewFilter", openEntityManagerInViewFilter);
        openEntityManagerInViewConfig.addMappingForUrlPatterns(
                EnumSet.of(DispatcherType.FORWARD, DispatcherType.INCLUDE, DispatcherType.REQUEST),
                true, // 在所有当前已经被声明的 Filter 的后面匹配 URL
                "/*"
        );

    }

}

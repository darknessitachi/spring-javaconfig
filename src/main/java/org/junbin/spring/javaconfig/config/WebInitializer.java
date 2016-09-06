package org.junbin.spring.javaconfig.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author : Chung Junbin
 * @email : <a href="mailto:rekadowney@163.com">发送邮件</a>
 * @createDate : 2016-09-01 15:18
 * @description :
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * <pre>
     * 　　配置 Spring 的 {@link org.springframework.web.servlet.DispatcherServlet}
     * 的 {@code url-pattern}
     * </pre>
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * <pre>
     * 　　配置应用上下文，即所有不包括 SpringMVC 等 Web 配置之外的所有配置，
     * 比如：Spring、Hibernate、AOP 等的配置类
     * </pre>
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{SpringConfig.class};
    }

    /**
     * <pre>
     * 　　配置 SpringMVC 等 Web 上下文
     * </pre>
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{SpringMvcConfig.class};
    }

}

package com.hnsic.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName MvcConfig
 * Description too
 * Aouthor   Administrator
 * Date      2020/2/4 0004  19:50
 * Version   1.0
 **/
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer=new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/login").setViewName("login");
                registry.addViewController("/").setViewName("/login");
                registry.addViewController("/login.html").setViewName("login");

            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new HandlerInterceptor() {
                }).addPathPatterns("/**")
                        .excludePathPatterns("/index.html", "/", "/user/login", "/**/*.css",
                                "/**/*.js", "/**/*.png", "/**/*.jpg",
                                "/**/*.jpeg", "/**/*.gif", "/**/fonts/*", "/**/*.svg");
            }

         };
        return webMvcConfigurer;
    }
}

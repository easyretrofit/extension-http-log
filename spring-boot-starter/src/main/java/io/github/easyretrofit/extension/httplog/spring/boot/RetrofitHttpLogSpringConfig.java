package io.github.easyretrofit.extension.httplog.spring.boot;

import io.github.easyretrofit.core.RetrofitResourceContext;
import io.github.easyretrofit.extension.httplog.core.interceptor.HttpLogInterceptor;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RetrofitHttpLogSpringConfig implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Bean
    @ConditionalOnMissingBean
    public HttpLogInterceptor httpLogInterceptor() {
        RetrofitResourceContext context = applicationContext.getBean(RetrofitResourceContext.class);
        return new HttpLogInterceptor(context);
    }
}

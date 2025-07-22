package io.github.easyretrofit.extension.httplog.core.annotation;

import io.github.easyretrofit.core.annotation.RetrofitInterceptor;
import io.github.easyretrofit.core.annotation.RetrofitInterceptorParam;
import io.github.easyretrofit.extension.httplog.core.interceptor.HttpLogInterceptor;
import okhttp3.logging.HttpLoggingInterceptor;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@RetrofitInterceptor(handler = HttpLogInterceptor.class)
public @interface HttpLog {

    HttpLoggingInterceptor.Level level() default HttpLoggingInterceptor.Level.BASIC;

    RetrofitInterceptorParam extensions() default @RetrofitInterceptorParam();
}

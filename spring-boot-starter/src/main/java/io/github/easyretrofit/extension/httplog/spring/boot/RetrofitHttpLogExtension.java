package io.github.easyretrofit.extension.httplog.spring.boot;

import io.github.easyretrofit.core.RetrofitInterceptorExtension;
import io.github.easyretrofit.core.extension.BaseInterceptor;
import io.github.easyretrofit.extension.httplog.core.annotation.HttpLog;
import io.github.easyretrofit.extension.httplog.core.interceptor.HttpLogInterceptor;

import java.lang.annotation.Annotation;

public class RetrofitHttpLogExtension implements RetrofitInterceptorExtension {
    @Override
    public Class<? extends Annotation> createAnnotation() {
        return HttpLog.class;
    }

    @Override
    public Class<? extends BaseInterceptor> createInterceptor() {
        return HttpLogInterceptor.class;
    }
}

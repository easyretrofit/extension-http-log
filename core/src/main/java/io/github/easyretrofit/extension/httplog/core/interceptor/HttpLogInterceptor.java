package io.github.easyretrofit.extension.httplog.core.interceptor;

import io.github.easyretrofit.core.RetrofitResourceContext;
import io.github.easyretrofit.core.extension.BaseInterceptor;
import io.github.easyretrofit.extension.httplog.core.annotation.HttpLog;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

import java.io.IOException;
import java.lang.annotation.Annotation;

public class HttpLogInterceptor extends BaseInterceptor {

    private final RetrofitResourceContext context;
    private final HttpLoggingInterceptor httpLoggingInterceptor;

    public HttpLogInterceptor(RetrofitResourceContext context) {
        this.context = context;
        httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
    }

    @Override
    protected Response executeIntercept(Chain chain) throws IOException {
        Annotation extensionAnnotation = this.getExtensionAnnotation(HttpLog.class);
        if (extensionAnnotation != null) {
            HttpLog httpLog = (HttpLog) extensionAnnotation;
            httpLoggingInterceptor.setLevel(httpLog.level());
        }
        return httpLoggingInterceptor.intercept(chain);
    }

    @Override
    protected RetrofitResourceContext getInjectedRetrofitResourceContext() {
        return context;
    }
}

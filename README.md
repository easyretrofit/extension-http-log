[![Version](https://img.shields.io/maven-central/v/io.github.easyretrofit/extension-http-log-spring-boot-starter?logo=apache-maven&style=flat-square)](https://central.sonatype.com/artifact/io.github.easyretrofit/extension-retry-spring-boot-starter)
[![Build](https://github.com/easyretrofit/extension-http-log/actions/workflows/build.yml/badge.svg)](https://github.com/easyretrofit/extension-retry/actions/workflows/build.yml/badge.svg)
[![License](https://img.shields.io/github/license/easyretrofit/extension-http-log.svg)](http://www.apache.org/licenses/LICENSE-2.0)
[![License](https://img.shields.io/badge/JDK-8+-4EB1BA.svg)](https://docs.oracle.com/javase/8/)
[![License](https://img.shields.io/badge/spring--boot-2.0.0+-green.svg)]()

# extension-http-log

## How to use in Spring Boot

add dependency in pom.xml
```xml

<dependency>
    <groupId>io.github.easyretrofit</groupId>
    <artifactId>extension-http-log-spring-boot-starter</artifactId>
    <version>${latest.version}</version>
</dependency>
```

please look at spring boot web starter [example](https://github.com/liuziyuan/easy-retrofit-demo/tree/main/retrofit-spring-boot-web-starter-sample)

```java
@RetrofitBuilder(baseUrl = "http://localhost:9100")
@HttpLog(level = HttpLoggingInterceptor.Level.BODY, extensions = @RetrofitInterceptorParam(type = InterceptorType.NETWORK))
public interface BackendApi {
}
```

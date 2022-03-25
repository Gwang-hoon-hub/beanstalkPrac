package com.pang.beanstalkprac;

import com.pang.beanstalkprac.trace.logtrace.FieldLogTrace;
import com.pang.beanstalkprac.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace(){
        return new FieldLogTrace();
    }
}

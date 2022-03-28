package com.pang.beanstalkprac.app.v4;

import com.pang.beanstalkprac.trace.TraceStatus;
import com.pang.beanstalkprac.trace.logtrace.LogTrace;
import com.pang.beanstalkprac.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderControllerV4 {

    private final OrderServiceV4 service;
    private final LogTrace trace;

    @GetMapping("/v4/request")
    public String request(String itemId){
        AbstractTemplate<String> template = new AbstractTemplate<String>(trace) {
            @Override
            protected String call() {
                service.orderItem(itemId);
                return "ok";
            }
        };
        return template.excute("OrderCotroller.request()");
    }
}

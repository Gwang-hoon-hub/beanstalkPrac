package com.pang.beanstalkprac.app.v3;

import com.pang.beanstalkprac.trace.TraceStatus;
import com.pang.beanstalkprac.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderControllerV3 {

    private final OrderServiceV3 service;
    private final LogTrace trace;

    @GetMapping("/v3/request")
    public String request(String itemId){
        TraceStatus status = null;

        try{
            status = trace.begin("OrderController.request()");
            service.orderItem(itemId);
            trace.end(status);
            return "ok";
        } catch (Exception e){
            trace.exception(status, e);
            throw e; // 반드시 예외를 다시 던져 주어야한다.
        }


    }
}

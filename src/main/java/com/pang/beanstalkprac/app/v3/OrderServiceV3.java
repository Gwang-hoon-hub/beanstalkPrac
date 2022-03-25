package com.pang.beanstalkprac.app.v3;

import com.pang.beanstalkprac.trace.TraceStatus;
import com.pang.beanstalkprac.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {
    private final OrderRepositoryV3 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId){
        TraceStatus status = null;

        try{
            status = trace.begin("OrderService.orderItem()");
            orderRepository.save(itemId);
            trace.end(status);
        } catch (Exception e){
            trace.exception(status, e);
            throw e; // 반드시 예외를 다시 던져 주어야한다.
        }

    }

}

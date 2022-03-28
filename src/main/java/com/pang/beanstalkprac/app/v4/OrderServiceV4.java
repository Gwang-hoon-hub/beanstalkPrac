package com.pang.beanstalkprac.app.v4;

import com.pang.beanstalkprac.trace.TraceStatus;
import com.pang.beanstalkprac.trace.logtrace.LogTrace;
import com.pang.beanstalkprac.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {
    private final OrderRepositoryV4 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId){
        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
            @Override
            protected Void call() {
                orderRepository.save(itemId);
                return null;
            }
        };
        template.excute("OrderService.orderItem()");
    }

}

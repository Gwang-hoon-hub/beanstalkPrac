package com.pang.beanstalkprac.v2;

import com.pang.beanstalkprac.trace.TraceId;
import com.pang.beanstalkprac.trace.TraceStatus;
import com.pang.beanstalkprac.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {

    private final HelloTraceV2 trace;

    public void save(TraceId traceId, String itemId){

        TraceStatus status = null;

        try{
            status = trace.beginSync(traceId,"OrderRepository.save()");

            // 저장로직
            if(itemId.equals("ex")){
                throw new IllegalStateException("예외 발생!");
            }
            sleep(1000);

            trace.end(status);
        } catch (Exception e){
            trace.exception(status, e);
            throw e; // 반드시 예외를 다시 던져 주어야한다.
        }


    }

    private void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

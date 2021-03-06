package com.pang.beanstalkprac.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderControllerV0 {

    private final OrderServiceV0 service;

    @GetMapping("/v0/request")
    public String request(String itemId){
        service.orderItem(itemId);
        return "ok";
    }
}

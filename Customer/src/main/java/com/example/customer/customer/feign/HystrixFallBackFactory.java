package com.example.customer.customer.feign;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class HystrixFallBackFactory implements FallbackFactory<Feign> {
    @Override
    public Feign create(Throwable cause) {
        return null;
    }
}

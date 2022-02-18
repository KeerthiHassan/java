package com.example.customer.customer.feign;

import com.example.customer.customer.model.Account;
import io.micrometer.core.instrument.binder.hystrix.HystrixMetricsBinder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="accounts", fallback= HystrixFallBackFactory.class)
public interface Feign
{
    @GetMapping("/acc/findid/{id}")
    public Account findById(@PathVariable("id") Integer id);
}

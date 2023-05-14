package com.group3.orderservice.client;


import com.group3.orderservice.dto.InventoryResponse;
import feign.Capability;
import feign.micrometer.MicrometerCapability;
import io.github.resilience4j.retry.annotation.Retry;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "inventory-service", configuration = FeignConfiguration.class)
@Retry(name = "inventory")
public interface InventoryClient {
    @GetMapping("/api/inventory")
    List<InventoryResponse> checkStock(@RequestParam List<String> skuCode);
}
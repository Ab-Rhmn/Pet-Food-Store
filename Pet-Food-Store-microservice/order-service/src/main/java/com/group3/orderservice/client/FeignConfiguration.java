package com.group3.orderservice.client;

import feign.Capability;
import feign.micrometer.MicrometerCapability;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;

public class FeignConfiguration {
    @Bean
    public Capability capability(final MeterRegistry registry) {
        return new MicrometerCapability();
    }
//
//    @Bean
//    public default Capability capability() {
//        return new MicrometerCapability(registry);
//    }
}
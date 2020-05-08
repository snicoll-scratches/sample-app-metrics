package com.example;

import io.micrometer.core.instrument.logging.LoggingMeterRegistry;
import io.micrometer.core.instrument.logging.LoggingRegistryConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SampleAppMetricsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleAppMetricsApplication.class, args);
	}

	@Bean
	public LoggingMeterRegistry loggingMeterRegistry() {
		return LoggingMeterRegistry.builder(LoggingRegistryConfig.DEFAULT).build();
	}

}

package com.aptmap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 활성화 (createdAt 자동 삽입)
@EnableFeignClients // OpenFeign 활성화
@ConfigurationPropertiesScan // @ConfigurationProperties 클래스 자동 스캔
@SpringBootApplication
public class AptmapBeApplication {
    public static void main(String[] args) {
        SpringApplication.run(AptmapBeApplication.class, args);
    }
}
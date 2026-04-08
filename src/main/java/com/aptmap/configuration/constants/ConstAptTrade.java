package com.aptmap.configuration.constants;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

// application.yaml의 constants.open-feign.apt-trade 값을 자동으로 주입
@Getter
@Setter
@ConfigurationProperties(prefix = "constants.open-feign.apt-trade")
public class ConstAptTrade {
    public String url;
    public String serviceKey;
}
package com.aptmap.aparttrade;

import com.aptmap.aparttrade.model.AptTradeRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URI;

// URI를 통째로 받아서 호출하는 방식
// 서비스 키에 특수문자(/, +, =)가 있어서 @RequestParam으로 넘기면 이중 인코딩 발생
// URI 객체로 넘기면 인코딩 없이 그대로 전달됨
@FeignClient(name = "apt-trade-api", url = "https://apis.data.go.kr")
public interface AptTradeClient {

    @GetMapping(produces = "application/xml")
    AptTradeRes getAptTrade(URI uri);
}
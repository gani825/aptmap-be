package com.aptmap.aparttrade;

import com.aptmap.aparttrade.model.AptTradeRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// OpenFeign 인터페이스 - 공공데이터 API를 호출하는 HTTP 클라이언트
// url은 application.yaml의 constants.open-feign.apt-trade.url 값
@FeignClient(name = "apt-trade-api", url = "${constants.open-feign.apt-trade.url}")
public interface AptTradeClient {

    // 아파트 매매 실거래가 조회 API 엔드포인트
    @GetMapping(value = "/getRTMSDataSvcAptTrade", produces = "application/xml")
    AptTradeRes getAptTrade(
            @RequestParam("serviceKey") String serviceKey, // 공공데이터 인증키
            @RequestParam("LAWD_CD") String lawdCd,  // 지역코드
            @RequestParam("DEAL_YMD") String dealYmd, // 조회 년월
            @RequestParam(value = "pageNo", required = false) Integer pageNo, // 페이지 번호
            @RequestParam(value = "numOfRows", required = false) Integer numOfRows // 결과 수
    );
}
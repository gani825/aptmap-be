package com.aptmap.kakao;

import com.aptmap.kakao.model.KakaoAddressRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

// 카카오 주소 검색 API 클라이언트
@FeignClient(name = "kakao-api", url = "https://dapi.kakao.com")
public interface KakaoClient {

    // 주소 → 좌표 변환 API
    @GetMapping("/v2/local/search/address.json")
    KakaoAddressRes getCoordinate(
            @RequestHeader("Authorization") String authorization, // "KakaoAK {REST_API_KEY}"
            @RequestParam("query") String query // 검색할 주소
    );
}
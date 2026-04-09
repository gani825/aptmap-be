package com.aptmap.kakao.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

// 카카오 주소 검색 API 응답 전체를 담는 클래스
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class KakaoAddressRes {

    // JSON 응답의 documents 배열
    @JsonProperty("documents")
    private List<KakaoDocument> documents;

    // 주소 하나의 좌표 정보를 담는 내부 클래스
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class KakaoDocument {
        private String x; // 경도 (longitude)
        private String y; // 위도 (latitude)
    }
}
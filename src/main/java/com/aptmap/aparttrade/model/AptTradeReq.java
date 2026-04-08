package com.aptmap.aparttrade.model;

import lombok.Data;

// 프론트에서 받는 아파트 실거래가 조회 요청 파라미터
@Data
public class AptTradeReq {
    private String lawdCd; // 지역 코드
    private String dealYearMon; // 조회 년월
    private Integer pageNo; // 페이지 번호
    private Integer numOfRows; // 한 페이지 결과 수
}
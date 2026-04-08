package com.aptmap.aparttrade.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import tools.jackson.dataformat.xml.annotation.JacksonXmlProperty;

// API에서 XML로 받는 아파트 거래 항목 하나
// ignoreUnknown = true : 모르는 필드가 와도 에러 없이 무시
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AptItem {

    @JacksonXmlProperty(localName = "aptDong")
    private String aptDong; // 아파트 동

    @JacksonXmlProperty(localName = "aptNm")
    private String aptNm; // 아파트 이름

    @JacksonXmlProperty(localName = "buildYear")
    private String buildYear; // 건축년도

    @JacksonXmlProperty(localName = "buyerGbn")
    private String buyerGbn; // 매수자 구분

    @JacksonXmlProperty(localName = "cdealDay")
    private String cdealDay; // 해제 사유 발생일

    @JacksonXmlProperty(localName = "cdealType")
    private String cdealType; // 해제 여부

    @JacksonXmlProperty(localName = "dealAmount")
    private String dealAmount; // 거래금

    @JacksonXmlProperty(localName = "dealDay")
    private String dealDay; // 거래 일

    @JacksonXmlProperty(localName = "dealMonth")
    private String dealMonth; // 거래 월

    @JacksonXmlProperty(localName = "dealYear")
    private String dealYear; // 거래 년도

    @JacksonXmlProperty(localName = "dealingGbn")
    private String dealingGbn; // 거래 유형

    @JacksonXmlProperty(localName = "estateAgentSggNm")
    private String estateAgentSggNm; // 중개사 소재지

    @JacksonXmlProperty(localName = "excluUseAr")
    private String excluUseAr; // 전용면적

    @JacksonXmlProperty(localName = "floor")
    private String floor; // 층수

    @JacksonXmlProperty(localName = "jibun")
    private String jibun; // 지번

    @JacksonXmlProperty(localName = "landLeaseholdGbn")
    private String landLeaseholdGbn; // 토지 임차권 구분

    @JacksonXmlProperty(localName = "rgstDate")
    private String rgstDate; // 등기 날짜

    @JacksonXmlProperty(localName = "roadNm")
    private String roadNm; // 도로명

    @JacksonXmlProperty(localName = "sggCd")
    private String sggCd; // 시군구 코드

    @JacksonXmlProperty(localName = "slerGbn")
    private String slerGbn; // 매도자 구분

    @JacksonXmlProperty(localName = "umdNm")
    private String umdNm; // 읍면동 이름
}
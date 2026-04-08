package com.aptmap.aparttrade.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import tools.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import tools.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

// 공공데이터 API XML 응답 전체를 담는 클래스
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "response") // XML 최상위 태그명
public class AptTradeRes {

    @JacksonXmlProperty(localName = "body")
    private AptBody body; // 실제 데이터가 들어있는 body
}
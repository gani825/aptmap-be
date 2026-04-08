package com.aptmap.aparttrade.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import tools.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import tools.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

// API 응답의 body 부분
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AptBody {

    // <items> 태그 없이 <item>이 바로 나열되는 구조라 useWrapping = false
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "item")
    private List<AptItem> items; // 아파트 거래 목록
}
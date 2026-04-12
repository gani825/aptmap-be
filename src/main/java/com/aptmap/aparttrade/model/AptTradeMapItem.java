package com.aptmap.aparttrade.model;

import com.aptmap.entity.AptTrade;
import lombok.Getter;

// 프론트엔드 지도 화면에 내려주는 응답 DTO
// AptTrade 엔티티에서 지도에 필요한 필드만 추려서 반환
@Getter
public class AptTradeMapItem {

    private final Long id;

    private final String aptNm; // 아파트 이름

    private final String umdNm; // 읍면동

    private final Long dealAmount; // 거래금액

    private final Integer floor;  // 층수

    private final String excluUseAr; // 전용면적

    private final String dealDate; // 거래 날짜 (yyyy-MM-dd)

    private final Double latitude; // 위도 (카카오 주소 검색으로 변환한 값)

    private final Double longitude; // 경도

    // AptTrade 엔티티 → DTO 변환 생성자
    public AptTradeMapItem(AptTrade entity) {
        this.id         = entity.getId();
        this.aptNm      = entity.getAptNm();
        this.umdNm      = entity.getUmdNm();
        this.dealAmount = entity.getDealAmount();
        this.floor      = entity.getFloor();
        this.excluUseAr = entity.getExcluUseAr() != null
                ? entity.getExcluUseAr().toPlainString() : null;
        this.dealDate   = entity.getDealDate() != null
                ? entity.getDealDate().toString() : null;
        this.latitude   = entity.getLatitude();
        this.longitude  = entity.getLongitude();
    }
}
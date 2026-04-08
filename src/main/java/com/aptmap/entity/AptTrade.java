package com.aptmap.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "apt_trade", uniqueConstraints = {
        // 같은 거래가 중복 저장되지 않도록 유니크 제약 조건 설정
        @UniqueConstraint(
                name = "uq_apt_trade_identity",
                columnNames = {"jibun", "sgg_cd", "deal_amount", "deal_date", "floor", "apt_dong"}
        )
})
@Getter
@Setter
@NoArgsConstructor  // 기본 생성자
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class) // createdAt 자동 삽입
public class AptTrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Long id;

    @Column(name = "apt_dong", length = 50, nullable = false)
    private String aptDong; // 아파트 동

    @Column(name = "apt_nm", length = 100, nullable = false)
    private String aptNm; // 아파트 이름

    @Column(name = "build_year", length = 4)
    private String buildYear; // 건축년도

    @Column(name = "buyer_gbn", length = 20)
    private String buyerGbn; // 매수자 구분

    @Column(name = "cdeal_day", length = 20)
    private String cdealDay; // 해제 사유 발생일

    @Column(name = "cdeal_type", length = 20)
    private String cdealType; // 해제 여부

    @Column(name = "deal_amount", nullable = false)
    private Long dealAmount; // 거래금액

    @Column(name = "deal_date", nullable = false)
    private LocalDate dealDate; // 거래 날짜

    @Column(name = "dealing_gbn", length = 50)
    private String dealingGbn; // 거래 유형

    @Column(name = "estate_agent_sgg_nm", length = 255)
    private String estateAgentSggNm; // 중개사 소재지

    @Column(name = "exclu_use_ar", precision = 10, scale = 4, nullable = false)
    private BigDecimal excluUseAr; // 전용면적

    @Column(name = "floor")
    private Integer floor; // 층수

    @Column(name = "jibun", length = 20, nullable = false)
    private String jibun; // 지번

    @Column(name = "land_leasehold_gbn", length = 1)
    private String landLeaseholdGbn; // 토지 임차권 구분

    @Column(name = "rgst_date", length = 20)
    private String rgstDate; // 등기 날짜

    @Column(name = "road_nm", length = 100)
    private String roadNm; // 도로명

    @Column(name = "sgg_cd", length = 10, nullable = false)
    private String sggCd; // 시군구 코드 (법정동 앞 5자리)

    @Column(name = "sler_gbn", length = 20)
    private String slerGbn; // 매도자 구분

    @Column(name = "umd_nm", length = 50)
    private String umdNm; // 읍면동 이름

    // 카카오 주소 검색 API로 변환한 좌표값 (지도 마커 표시용)
    @Column(name = "latitude")
    private Double latitude; // 위도

    @Column(name = "longitude")
    private Double longitude; // 경도

    @CreatedDate
    @Column(name = "created_at", updatable = false) // 최초 저장 시간, 수정 불가
    private LocalDateTime createdAt;
}
package com.aptmap.aparttrade;

import com.aptmap.entity.AptTrade;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ApartTradeRepository extends JpaRepository<AptTrade, Long> {

    // 시군구 코드 + 거래 날짜 범위로 조회 (from ~ to 월 범위)
    // latitude IS NOT NULL 조건 → 좌표 없는 데이터는 제외 (카카오 주소 변환 실패 항목)
    @Query("SELECT a FROM AptTrade a WHERE a.sggCd = :sggCd " +
            "AND a.dealDate BETWEEN :from AND :to " +
            "AND a.latitude IS NOT NULL AND a.longitude IS NOT NULL")
    List<AptTrade> findMapData(@Param("sggCd") String sggCd,
                               @Param("from") LocalDate from,
                               @Param("to") LocalDate to);

    // 아파트 이름 + 거래 날짜 범위로 DB 전체 검색
    // LIKE %:aptNm% → 부분 일치
    // latitude IS NOT NULL 조건 → 좌표 없는 데이터는 제외
    @Query("SELECT a FROM AptTrade a WHERE a.aptNm LIKE %:aptNm% " +
            "AND a.dealDate BETWEEN :from AND :to " +
            "AND a.latitude IS NOT NULL AND a.longitude IS NOT NULL")
    List<AptTrade> searchByAptNm(@Param("aptNm") String aptNm,
                                 @Param("from") LocalDate from,
                                 @Param("to") LocalDate to);
}
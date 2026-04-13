package com.aptmap.aparttrade;

import com.aptmap.aparttrade.model.AptItem;
import com.aptmap.aparttrade.model.AptTradeMapItem;
import com.aptmap.aparttrade.model.AptTradeReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/apart")
@RequiredArgsConstructor
public class ApartTradeController {

    private final ApartTradeService apartTradeService;
    private final ApartTradeRepository apartTradeRepository;

    // 공공데이터 API 호출 → DB 저장 → AptItem 목록 반환
    // 프론트에서 데이터 수집용으로 먼저 이 엔드포인트를 호출해야
    // /map 엔드포인트에서 좌표가 포함된 데이터를 조회할 수 있음
    @GetMapping
    public List<AptItem> getAptTradeList(@ModelAttribute AptTradeReq req) {
        log.info("실거래가 수집 요청: {}", req);
        return apartTradeService.getAptTradeList(req);
    }

    // DB에 저장된 데이터를 지도용 DTO로 변환해서 반환
    // 좌표(위도/경도)가 있는 데이터만 포함됨
    // lawdCd  : 법정동 코드 5자리 (예: 11680 = 강남구)
    // dealYearMon : 거래년월 6자리 (예: 202503)
    @GetMapping("/map")
    public List<AptTradeMapItem> getMapMarkers(
            @RequestParam String lawdCd,
            @RequestParam String dealYearMon
    ) {
        log.info("지도 마커 요청 - 지역: {}, 거래월: {}", lawdCd, dealYearMon);

        // "202503" → 2025년 3월 1일 ~ 3월 31일로 범위 계산
        int year  = Integer.parseInt(dealYearMon.substring(0, 4));
        int month = Integer.parseInt(dealYearMon.substring(4, 6));
        LocalDate from = LocalDate.of(year, month, 1);
        LocalDate to   = from.withDayOfMonth(from.lengthOfMonth());

        return apartTradeRepository
                .findMapData(
                        lawdCd, from, to
                )
                .stream()
                .map(AptTradeMapItem::new)
                .collect(Collectors.toList());
    }

    // 아파트 이름 + 거래년월로 DB 전체 검색
    @GetMapping("/search")
    public List<AptTradeMapItem> searchByAptNm(
            @RequestParam String aptNm,
            @RequestParam String dealYearMon
    ) {
        // "202503" → 2025년 3월 1일 ~ 3월 31일
        int year  = Integer.parseInt(dealYearMon.substring(0, 4));
        int month = Integer.parseInt(dealYearMon.substring(4, 6));
        LocalDate from = LocalDate.of(year, month, 1);
        LocalDate to   = from.withDayOfMonth(from.lengthOfMonth());

        return apartTradeRepository
                .searchByAptNm(aptNm, from, to)
                .stream()
                .map(AptTradeMapItem::new)
                .collect(Collectors.toList());
    }
}
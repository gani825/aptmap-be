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
    // lawdCd : 법정동 코드 5자리 (예: 11680 = 강남구)
    // from : 시작 거래년월 6자리
    // to : 종료 거래년월 6자리
    @GetMapping("/map")
    public List<AptTradeMapItem> getMapMarkers(
            @RequestParam String lawdCd,
            @RequestParam String from,
            @RequestParam String to
    ) {
        log.info("지도 마커 요청 - 지역: {}, 기간: {} ~ {}", lawdCd, from, to);

        // "202501" → 2025년 1월 1일, "202503" → 2025년 3월 31일
        LocalDate fromDate = parseYearMonToFirstDay(from);
        LocalDate toDate   = parseYearMonToLastDay(to);

        return apartTradeRepository
                .findMapData(lawdCd, fromDate, toDate)
                .stream()
                .map(AptTradeMapItem::new)
                .collect(Collectors.toList());
    }

    // 아파트 이름 + 거래 기간 범위로 DB 전체 검색
    // aptNm : 아파트 이름 (부분 일치)
    // from : 시작 거래년월 6자리
    // to : 종료 거래년월 6자리
    @GetMapping("/search")
    public List<AptTradeMapItem> searchByAptNm(
            @RequestParam String aptNm,
            @RequestParam String from,
            @RequestParam String to
    ) {
        // "202501" → 2025년 1월 1일, "202503" → 2025년 3월 31일
        LocalDate fromDate = parseYearMonToFirstDay(from);
        LocalDate toDate   = parseYearMonToLastDay(to);

        return apartTradeRepository
                .searchByAptNm(aptNm, fromDate, toDate)
                .stream()
                .map(AptTradeMapItem::new)
                .collect(Collectors.toList());
    }

    // 해당 월 1일
    private LocalDate parseYearMonToFirstDay(String yearMon) {
        int year  = Integer.parseInt(yearMon.substring(0, 4));
        int month = Integer.parseInt(yearMon.substring(4, 6));
        return LocalDate.of(year, month, 1);
    }

    // 해당 월 마지막 날
    private LocalDate parseYearMonToLastDay(String yearMon) {
        LocalDate first = parseYearMonToFirstDay(yearMon);
        return first.withDayOfMonth(first.lengthOfMonth());
    }
}
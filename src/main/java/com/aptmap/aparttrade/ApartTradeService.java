package com.aptmap.aparttrade;

import com.aptmap.aparttrade.model.AptItem;
import com.aptmap.aparttrade.model.AptTradeReq;
import com.aptmap.aparttrade.model.AptTradeRes;
import com.aptmap.configuration.constants.ConstAptTrade;
import com.aptmap.entity.AptTrade;
import com.aptmap.kakao.KakaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.net.URI;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApartTradeService {
    private final AptTradeClient aptTradeClient;
    private final ConstAptTrade constAptTrade;
    private final ApartTradeRepository apartTradeRepository;
    private final KakaoService kakaoService; // 주소 → 좌표 변환

    public List<AptItem> getAptTradeList(AptTradeReq req) {

        // URI 직접 조합 - 서비스 키를 인코딩 없이 그대로 넣음
        String url = "https://apis.data.go.kr/1613000/RTMSDataSvcAptTrade/getRTMSDataSvcAptTrade"
                + "?serviceKey=" + constAptTrade.getServiceKey()
                + "&LAWD_CD=" + req.getLawdCd()
                + "&DEAL_YMD=" + req.getDealYearMon();

        if (req.getPageNo() != null) url += "&pageNo=" + req.getPageNo();
        if (req.getNumOfRows() != null) url += "&numOfRows=" + req.getNumOfRows();

        AptTradeRes response = aptTradeClient.getAptTrade(URI.create(url));

        if (response.getBody().getItems().size() > 0) {
            for (AptItem item : response.getBody().getItems()) {
                AptTrade aptTrade = new AptTrade(item);
                try {
                    apartTradeRepository.save(aptTrade);
                } catch (Exception e) {
                }
            }
        }

        return response.getBody().getItems();
    }
}
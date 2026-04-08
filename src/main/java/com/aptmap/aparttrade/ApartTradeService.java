package com.aptmap.aparttrade;

import com.aptmap.aparttrade.model.AptItem;
import com.aptmap.aparttrade.model.AptTradeReq;
import com.aptmap.aparttrade.model.AptTradeRes;
import com.aptmap.configuration.constants.ConstAptTrade;
import com.aptmap.entity.AptTrade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApartTradeService {
    private final AptTradeClient aptTradeClient;
    private final ConstAptTrade constAptTrade;
    private final ApartTradeRepository apartTradeRepository;

    public List<AptItem> getAptTradeList(AptTradeReq req) {
        AptTradeRes response = aptTradeClient.getAptTrade(
                constAptTrade.getServiceKey()
                , req.getLawdCd()
                , req.getDealYearMon()
                , req.getPageNo()
                , req.getNumOfRows()
        );

        if(!response.getBody().getItems().isEmpty()) {
            for(AptItem item : response.getBody().getItems()) {
                // AptItem → AptTrade 변환 후 DB 저장
                AptTrade aptTrade = new AptTrade(item);
                try { apartTradeRepository.save(aptTrade); }
                catch (Exception ignored) {} // 중복 데이터는 무시
            }
        }

        return response.getBody().getItems();
    }
}
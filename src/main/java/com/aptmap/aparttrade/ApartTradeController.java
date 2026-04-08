package com.aptmap.aparttrade;

import com.aptmap.aparttrade.model.AptItem;
import com.aptmap.aparttrade.model.AptTradeReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/apart")
@RequiredArgsConstructor
public class ApartTradeController {
    private final ApartTradeService apartTradeService;

    @GetMapping
    public List<AptItem> getAptTradeList(@ModelAttribute AptTradeReq req) {
        log.info("요청: {}", req);
        return apartTradeService.getAptTradeList(req);
    }
}
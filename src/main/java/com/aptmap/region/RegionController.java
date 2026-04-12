package com.aptmap.region;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/regions")
public class RegionController {

    @GetMapping
    public List<RegionDto> getRegions() {
        return RegionData.ALL;
    }
}
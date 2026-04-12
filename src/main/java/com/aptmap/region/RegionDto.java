package com.aptmap.region;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@Getter
@AllArgsConstructor
public class RegionDto {
    private String name;  // 광역시/도 이름
    private List<DistrictDto> children; // 시군구 목록

    @Getter
    @AllArgsConstructor
    public static class DistrictDto {
        private String cd;  // 법정동 코드
        private String name; // 시군구 이름
    }
}
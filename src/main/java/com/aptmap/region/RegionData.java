package com.aptmap.region;

import java.util.List;
import static com.aptmap.region.RegionDto.DistrictDto;

public class RegionData {
    public static final List<RegionDto> ALL = List.of(
            new RegionDto("서울특별시", List.of(
                    new DistrictDto("11110", "종로구"), new DistrictDto("11140", "중구"),
                    new DistrictDto("11170", "용산구"), new DistrictDto("11200", "성동구"),
                    new DistrictDto("11215", "광진구"), new DistrictDto("11230", "동대문구"),
                    new DistrictDto("11260", "중랑구"), new DistrictDto("11290", "성북구"),
                    new DistrictDto("11305", "강북구"), new DistrictDto("11320", "도봉구"),
                    new DistrictDto("11350", "노원구"), new DistrictDto("11380", "은평구"),
                    new DistrictDto("11410", "서대문구"), new DistrictDto("11440", "마포구"),
                    new DistrictDto("11470", "양천구"), new DistrictDto("11500", "강서구"),
                    new DistrictDto("11530", "구로구"), new DistrictDto("11545", "금천구"),
                    new DistrictDto("11560", "영등포구"), new DistrictDto("11590", "동작구"),
                    new DistrictDto("11620", "관악구"), new DistrictDto("11650", "서초구"),
                    new DistrictDto("11680", "강남구"), new DistrictDto("11710", "송파구"),
                    new DistrictDto("11740", "강동구")
            )),
            new RegionDto("부산광역시", List.of(
                    new DistrictDto("26110", "중구"), new DistrictDto("26140", "서구"),
                    new DistrictDto("26170", "동구"), new DistrictDto("26200", "영도구"),
                    new DistrictDto("26230", "부산진구"), new DistrictDto("26260", "동래구"),
                    new DistrictDto("26290", "남구"), new DistrictDto("26320", "북구"),
                    new DistrictDto("26350", "해운대구"), new DistrictDto("26380", "사하구"),
                    new DistrictDto("26410", "금정구"), new DistrictDto("26470", "연제구"),
                    new DistrictDto("26500", "수영구"), new DistrictDto("26530", "사상구")
            )),
            new RegionDto("대구광역시", List.of(
                    new DistrictDto("27110", "중구"), new DistrictDto("27140", "동구"),
                    new DistrictDto("27170", "서구"), new DistrictDto("27200", "남구"),
                    new DistrictDto("27230", "북구"), new DistrictDto("27260", "수성구"),
                    new DistrictDto("27290", "달서구"), new DistrictDto("27710", "달성군")
            )),
            new RegionDto("인천광역시", List.of(
                    new DistrictDto("28110", "중구"), new DistrictDto("28140", "동구"),
                    new DistrictDto("28177", "미추홀구"), new DistrictDto("28185", "연수구"),
                    new DistrictDto("28200", "남동구"), new DistrictDto("28237", "부평구"),
                    new DistrictDto("28245", "계양구"), new DistrictDto("28260", "서구")
            )),
            new RegionDto("광주광역시", List.of(
                    new DistrictDto("29110", "동구"), new DistrictDto("29140", "서구"),
                    new DistrictDto("29155", "남구"), new DistrictDto("29170", "북구"),
                    new DistrictDto("29200", "광산구")
            )),
            new RegionDto("대전광역시", List.of(
                    new DistrictDto("30110", "동구"), new DistrictDto("30140", "중구"),
                    new DistrictDto("30170", "서구"), new DistrictDto("30200", "유성구"),
                    new DistrictDto("30230", "대덕구")
            )),
            new RegionDto("울산광역시", List.of(
                    new DistrictDto("31110", "중구"), new DistrictDto("31140", "남구"),
                    new DistrictDto("31170", "동구"), new DistrictDto("31200", "북구"),
                    new DistrictDto("31710", "울주군")
            )),
            new RegionDto("세종특별자치시", List.of(
                    new DistrictDto("36110", "세종시")
            )),
            new RegionDto("경기도", List.of(
                    new DistrictDto("41110", "수원시 장안구"), new DistrictDto("41130", "수원시 권선구"),
                    new DistrictDto("41150", "수원시 팔달구"), new DistrictDto("41170", "수원시 영통구"),
                    new DistrictDto("41210", "성남시 수정구"), new DistrictDto("41220", "성남시 중원구"),
                    new DistrictDto("41250", "성남시 분당구"), new DistrictDto("41280", "의정부시"),
                    new DistrictDto("41310", "안양시 만안구"), new DistrictDto("41360", "안양시 동안구"),
                    new DistrictDto("41390", "부천시"), new DistrictDto("41410", "광명시"),
                    new DistrictDto("41430", "평택시"), new DistrictDto("41500", "고양시 덕양구"),
                    new DistrictDto("41550", "고양시 일산동구"), new DistrictDto("41560", "고양시 일산서구"),
                    new DistrictDto("41590", "구리시"), new DistrictDto("41610", "남양주시"),
                    new DistrictDto("41650", "군포시"), new DistrictDto("41710", "용인시 처인구"),
                    new DistrictDto("41720", "용인시 기흥구"), new DistrictDto("41730", "용인시 수지구"),
                    new DistrictDto("41820", "파주시"), new DistrictDto("41850", "김포시"),
                    new DistrictDto("41860", "화성시")
            )),
            new RegionDto("강원특별자치도", List.of(
                    new DistrictDto("51110", "춘천시"), new DistrictDto("51130", "원주시"),
                    new DistrictDto("51150", "강릉시"), new DistrictDto("51170", "동해시"),
                    new DistrictDto("51210", "속초시"), new DistrictDto("51230", "삼척시")
            )),
            new RegionDto("충청북도", List.of(
                    new DistrictDto("43110", "청주시 상당구"), new DistrictDto("43112", "청주시 서원구"),
                    new DistrictDto("43113", "청주시 흥덕구"), new DistrictDto("43114", "청주시 청원구"),
                    new DistrictDto("43130", "충주시"), new DistrictDto("43150", "제천시")
            )),
            new RegionDto("충청남도", List.of(
                    new DistrictDto("44130", "천안시 동남구"), new DistrictDto("44131", "천안시 서북구"),
                    new DistrictDto("44150", "공주시"), new DistrictDto("44200", "아산시"),
                    new DistrictDto("44210", "서산시"), new DistrictDto("44230", "논산시"),
                    new DistrictDto("44270", "당진시")
            )),
            new RegionDto("전북특별자치도", List.of(
                    new DistrictDto("52110", "전주시 완산구"), new DistrictDto("52111", "전주시 덕진구"),
                    new DistrictDto("52130", "군산시"), new DistrictDto("52140", "익산시"),
                    new DistrictDto("52180", "정읍시"), new DistrictDto("52210", "김제시")
            )),
            new RegionDto("전라남도", List.of(
                    new DistrictDto("46110", "목포시"), new DistrictDto("46130", "여수시"),
                    new DistrictDto("46150", "순천시"), new DistrictDto("46170", "나주시"),
                    new DistrictDto("46230", "광양시")
            )),
            new RegionDto("경상북도", List.of(
                    new DistrictDto("47110", "포항시 남구"), new DistrictDto("47111", "포항시 북구"),
                    new DistrictDto("47130", "경주시"), new DistrictDto("47150", "김천시"),
                    new DistrictDto("47170", "안동시"), new DistrictDto("47190", "구미시"),
                    new DistrictDto("47210", "영주시"), new DistrictDto("47280", "경산시")
            )),
            new RegionDto("경상남도", List.of(
                    new DistrictDto("48120", "창원시 의창구"), new DistrictDto("48121", "창원시 성산구"),
                    new DistrictDto("48123", "창원시 마산합포구"), new DistrictDto("48124", "창원시 마산회원구"),
                    new DistrictDto("48125", "창원시 진해구"), new DistrictDto("48170", "진주시"),
                    new DistrictDto("48250", "김해시"), new DistrictDto("48310", "거제시"),
                    new DistrictDto("48330", "양산시")
            )),
            new RegionDto("제주특별자치도", List.of(
                    new DistrictDto("50110", "제주시"), new DistrictDto("50130", "서귀포시")
            ))
    );
}
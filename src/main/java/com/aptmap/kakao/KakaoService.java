package com.aptmap.kakao;

import com.aptmap.kakao.model.KakaoAddressRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KakaoService {

    private final KakaoClient kakaoClient;

    // application.yaml의 constants.kakao.rest-api-key 값 주입
    @Value("${constants.kakao.rest-api-key}")
    private String kakaoApiKey;

    // 주소를 받아서 위도/경도 배열로 반환 [위도, 경도]
    // 좌표를 못 찾으면 null 반환
    public double[] getCoordinate(String address) {
        try {
            KakaoAddressRes res = kakaoClient.getCoordinate(
                    "KakaoAK " + kakaoApiKey, // 카카오 API 인증 형식
                    address
            );

            if (res.getDocuments() == null || res.getDocuments().isEmpty()) {
                return null; // 주소로 좌표를 찾지 못한 경우
            }

            KakaoAddressRes.KakaoDocument doc = res.getDocuments().get(0);
            double latitude = Double.parseDouble(doc.getY()); // 위도
            double longitude = Double.parseDouble(doc.getX()); // 경도

            return new double[]{latitude, longitude};
        } catch (Exception e) {
            log.warn("좌표 변환 실패 - 주소: {}, 에러: {}", address, e.getMessage());
            return null;
        }
    }
}
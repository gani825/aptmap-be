# APTMAP Backend

> 국토교통부 공공데이터 API로 아파트 실거래가를 수집하고 카카오 주소 검색 API로 좌표를 변환하여 지도 기반 시각화 서비스를 제공하는 백엔드입니다.
> 지역 조회와 아파트 이름 검색 두 가지 방식으로 실거래가 데이터를 조회할 수 있습니다.

<div align="center">
  <table>
    <tr>
      <td align="center">
        <img width="100%" alt="APTMAP Demo Screen 2" src="https://github.com/user-attachments/assets/3e08e3b0-5893-4212-96a5-7a781d33b69b" />
      </td>
      <td align="center">
        <img width="100%" alt="APTMAP Demo Screen 1" src="https://github.com/user-attachments/assets/5391f0d0-08db-4296-9ae9-18f512164040" />
      </td>
    </tr>
  </table>
</div>

---

## 기술 스택

| 구분 | 기술 |
|---|---|
| Language | Java 21 |
| Framework | Spring Boot 4.0.5 |
| ORM | JPA |
| Database | MySQL |
| HTTP Client | OpenFeign |
| 외부 API | 국토교통부 아파트 실거래가, 카카오 주소 검색 |

---

## 주요 기능

- 공공데이터 API 호출 → XML 파싱 → DB 저장
- 카카오 주소 검색 API로 주소 → 위도/경도 변환 후 저장
- 지도 마커용 데이터 조회 API (`/api/apart/map`) — 거래 기간 범위(from~to) 지원
- 아파트 이름 + 거래 기간 범위 복합 검색 API (`/api/apart/search`)
- 전국 시도/시군구 지역 목록 API (`/api/regions`)

---

## API 명세

| Method | URL | 설명 |
|---|---|---|
| GET | `/api/apart` | 공공데이터 수집 → DB 저장 |
| GET | `/api/apart/map` | 지도 마커용 데이터 조회 (from~to 기간 범위) |
| GET | `/api/apart/search` | 아파트 이름 + 기간 범위 복합 검색 |
| GET | `/api/regions` | 전국 시도/시군구 목록 조회 |

---

## 실행 방법

```bash
# 1. application.yaml 설정
# MySQL DB 생성 후 datasource 정보 입력
# 공공데이터 API 키 (Encoding 키 사용), 카카오 REST API 키 입력

# 2. 실행
./gradlew bootRun
```

---

## 프로젝트 구조

```
src/main/java/com/aptmap
├── aparttrade/         # 공공데이터 API 연동, 실거래가 저장/조회/검색
├── kakao/              # 카카오 주소 검색 API 연동
├── region/             # 지역 목록 API
├── entity/             # JPA 엔티티
└── configuration/      # 설정 (CORS, 상수)
```
package com.aptmap.aparttrade;

import com.aptmap.entity.AptTrade;
import org.springframework.data.jpa.repository.JpaRepository;

// AptTrade = 엔티티 타입, Long = PK 타입
public interface ApartTradeRepository extends JpaRepository<AptTrade, Long> {
}
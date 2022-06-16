package com.aafcj.checkin.repository;

import com.aafcj.checkin.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<PriceEntity, Integer> {
}

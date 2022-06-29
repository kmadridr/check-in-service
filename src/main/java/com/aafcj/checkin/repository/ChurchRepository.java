package com.aafcj.checkin.repository;

import com.aafcj.checkin.entity.ChurchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChurchRepository extends JpaRepository<ChurchEntity, Integer> {
}

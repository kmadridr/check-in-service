package com.aafcj.checkin.repository;

import com.aafcj.checkin.entity.CabinEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CabinRepository extends JpaRepository<CabinEntity, Integer> {

    public Optional<CabinEntity> findByName(String name);
}

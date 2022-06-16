package com.aafcj.checkin.repository;

import com.aafcj.checkin.entity.Cabin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CabinRepository extends JpaRepository<Cabin, Integer> {

    public Optional<Cabin> findByName(String name);
}

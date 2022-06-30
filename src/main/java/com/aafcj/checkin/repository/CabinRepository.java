package com.aafcj.checkin.repository;

import com.aafcj.checkin.Gender;
import com.aafcj.checkin.entity.CabinEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CabinRepository extends JpaRepository<CabinEntity, Integer> {

    Optional<CabinEntity> findByName(String name);

    Optional<List<CabinEntity>> findByGender(Gender gender);



}

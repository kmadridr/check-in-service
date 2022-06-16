package com.aafcj.checkin.service;

import com.aafcj.checkin.entity.CabinEntity;
import com.aafcj.checkin.exception.CabinNotFoundException;
import com.aafcj.checkin.repository.CabinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CabinService {

    @Autowired
    CabinRepository cabinRepository;

    public void add(CabinEntity cabin) {
        cabinRepository.save(cabin);
    }

    public CabinEntity getByName(String name) {
        return cabinRepository.findByName(name)
                .orElseThrow(() -> new CabinNotFoundException(name));
    }

    public List<CabinEntity> getAll() {
        return cabinRepository.findAll();
    }


}

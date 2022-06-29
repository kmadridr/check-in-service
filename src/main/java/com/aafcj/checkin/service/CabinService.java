package com.aafcj.checkin.service;

import com.aafcj.checkin.dto.CabinDTO;
import com.aafcj.checkin.entity.CabinEntity;
import com.aafcj.checkin.exception.CabinNotFoundException;
import com.aafcj.checkin.mapper.MapStructMapper;
import com.aafcj.checkin.repository.CabinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CabinService {

    @Autowired
    CabinRepository cabinRepository;

    @Autowired
    MapStructMapper mapStructMapper;

    public void add(CabinDTO cabin) {
        CabinEntity cabinEntity = mapStructMapper.cabinDTOToCabinEntity(cabin);
        cabinRepository.save(cabinEntity);
    }

    public CabinDTO getByName(String name) {
        CabinEntity cabin = cabinRepository.findByName(name)
                .orElseThrow(() -> new CabinNotFoundException(name));
        return mapStructMapper.cabinEntityToCabinDTO(cabin);
    }

    public List<CabinDTO> getAll() {
        return mapStructMapper.cabinEntitiesToCabinDTOs(cabinRepository.findAll());
    }


}

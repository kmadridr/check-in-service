package com.aafcj.checkin.service;

import com.aafcj.checkin.Gender;
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

    public CabinDTO getById(int id) {
        return mapStructMapper.cabinEntityToCabinDTO(cabinRepository.findById(id)
                .orElseThrow(() -> new CabinNotFoundException(String.format("with id {}", id))));
    }

    public CabinDTO getByName(String name) {
        CabinEntity cabin = cabinRepository.findByName(name)
                .orElseThrow(() -> new CabinNotFoundException(name));
        return mapStructMapper.cabinEntityToCabinDTO(cabin);
    }

    public List<CabinDTO> getAllByGender(Gender gender) {
        return mapStructMapper.cabinEntitiesToCabinDTOs(cabinRepository.findByGender(gender)
                .orElseThrow(() -> new CabinNotFoundException("by gender")));
    }

    public List<CabinDTO> getAll() {
            return mapStructMapper.cabinEntitiesToCabinDTOs(cabinRepository.findAll());
    }

    public void save(CabinDTO cabinDTO) {
        cabinRepository.save(mapStructMapper.cabinDTOToCabinEntity(cabinDTO));
    }
    public void saveAll(List<CabinDTO> cabinDTOs) {
        cabinRepository.saveAll(mapStructMapper.cabinDTOsToCabinEntities(cabinDTOs));
    }
}

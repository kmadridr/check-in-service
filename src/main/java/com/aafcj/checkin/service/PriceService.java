package com.aafcj.checkin.service;

import com.aafcj.checkin.dto.PriceDTO;
import com.aafcj.checkin.entity.PriceEntity;
import com.aafcj.checkin.mapper.MapStructMapper;
import com.aafcj.checkin.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private MapStructMapper mapStructMapper;

    public List<PriceDTO> findAll() {
        return mapStructMapper.priceEntitiesToPriceDTOs(priceRepository.findAll());
    }

}

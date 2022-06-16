package com.aafcj.checkin.mapper;

import com.aafcj.checkin.dto.MemberDTO;
import com.aafcj.checkin.dto.PriceDTO;
import com.aafcj.checkin.entity.MemberEntity;
import com.aafcj.checkin.entity.PriceEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {

    MemberDTO memberEntityToMemberDTO(MemberEntity memberEntity);

    PriceDTO priceEntityToPriceDTO(PriceEntity priceEntity);
    List<PriceDTO> priceEntitiesToPriceDTOs(List<PriceEntity> priceEntityList);

    List<MemberDTO> memberEntitiesToMemberDTOs(List<MemberEntity> memberEntities);
}

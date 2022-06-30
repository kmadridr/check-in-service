package com.aafcj.checkin.mapper;

import com.aafcj.checkin.dto.CabinDTO;
import com.aafcj.checkin.dto.MemberDTO;
import com.aafcj.checkin.dto.PriceDTO;
import com.aafcj.checkin.entity.CabinEntity;
import com.aafcj.checkin.entity.MemberEntity;
import com.aafcj.checkin.entity.PriceEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {

    CabinDTO cabinEntityToCabinDTO(CabinEntity cabinEntity);

    CabinEntity cabinDTOToCabinEntity(CabinDTO cabinDTO);

    List<CabinDTO> cabinEntitiesToCabinDTOs(List<CabinEntity> cabinEntities);

    List<CabinEntity> cabinDTOsToCabinEntities(List<CabinDTO> cabinDTOs);
    MemberDTO memberEntityToMemberDTO(MemberEntity memberEntity);

    MemberEntity memberDTOToMemberEntity(MemberDTO memberDTO);

    PriceDTO priceEntityToPriceDTO(PriceEntity priceEntity);
    List<PriceDTO> priceEntitiesToPriceDTOs(List<PriceEntity> priceEntities);

    List<MemberDTO> memberEntitiesToMemberDTOs(List<MemberEntity> memberEntities);

    List<MemberEntity> memberDTOsToMemberEntities(List<MemberDTO> memberDTOs);
}

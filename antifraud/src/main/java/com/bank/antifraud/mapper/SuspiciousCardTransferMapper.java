package com.bank.antifraud.mapper;


import com.bank.antifraud.dto.SuspiciousCardTransferDTO;
import com.bank.antifraud.entity.SuspiciousCardTransfer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface SuspiciousCardTransferMapper {
    SuspiciousCardTransferMapper INSTANCE = Mappers.getMapper(SuspiciousCardTransferMapper.class);

    SuspiciousCardTransferDTO toDTO(SuspiciousCardTransfer suspiciousCardTransfer);

    SuspiciousCardTransfer toEntity(SuspiciousCardTransferDTO suspiciousCardTransferDTO);

    List<SuspiciousCardTransferDTO> toDTOList(List<SuspiciousCardTransfer> suspiciousCardTransferList);

}


package com.bank.antifraud.mapper;

import com.bank.antifraud.dto.SuspiciousPhoneTransferDTO;

import com.bank.antifraud.entity.SuspiciousPhoneTransfer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface SuspiciousPhoneTransferMapper {
    SuspiciousPhoneTransferMapper INSTANCE = Mappers.getMapper(SuspiciousPhoneTransferMapper.class);

    SuspiciousPhoneTransferDTO toDTO(SuspiciousPhoneTransfer suspiciousPhoneTransfer);

    SuspiciousPhoneTransfer toEntity(SuspiciousPhoneTransferDTO suspiciousPhoneTransferDTO);

    List<SuspiciousPhoneTransferDTO> toDTOList(List<SuspiciousPhoneTransfer> suspiciousPhoneTransferList);

}


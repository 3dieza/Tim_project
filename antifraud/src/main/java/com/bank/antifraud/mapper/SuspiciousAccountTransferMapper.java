package com.bank.antifraud.mapper;

import com.bank.antifraud.dto.SuspiciousAccountTransferDTO;

import com.bank.antifraud.entity.SuspiciousAccountTransfer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface SuspiciousAccountTransferMapper {
    SuspiciousAccountTransferMapper INSTANCE = Mappers.getMapper(SuspiciousAccountTransferMapper.class);

    SuspiciousAccountTransferDTO toDTO(SuspiciousAccountTransfer suspiciousAccountTransfer);

    SuspiciousAccountTransfer toEntity(SuspiciousAccountTransferDTO suspiciousAccountTransferDTO);

    List<SuspiciousAccountTransferDTO> toDTOList(List<SuspiciousAccountTransfer> suspiciousAccountTransferList);

}


//Каждый из этих мапперов реализует два метода - toDto и toEntity, которые преобразуют сущность
// в DTO и наоборот. Аннотация @Mapper(componentModel = "spring") указывает, что мы
// используем Mapstruct и хотим, чтобы Spring создавал реализации наших мапперов в качестве Spring бинов.


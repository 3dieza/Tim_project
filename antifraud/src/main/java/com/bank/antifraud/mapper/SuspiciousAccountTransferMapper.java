package com.bank.antifraud.mapper;

import com.bank.antifraud.dto.SuspiciousAccountTransferDTO;

import com.bank.antifraud.entity.SuspiciousAccountTransfer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Маппер для преобразования сущностей SuspiciousAccountTransfer в DTO и наоборот.
 */
@Component
@Mapper(componentModel = "spring")
public interface SuspiciousAccountTransferMapper {
    /*

    Инстанс маппера.
    */
    SuspiciousAccountTransferMapper INSTANCE = Mappers.getMapper(SuspiciousAccountTransferMapper.class);

    /**
     * Преобразует сущность SuspiciousAccountTransfer в DTO.
     *
     * @param suspiciousAccountTransfer сущность SuspiciousAccountTransfer
     * @return DTO SuspiciousAccountTransferDTO
     */
    SuspiciousAccountTransferDTO toDTO(SuspiciousAccountTransfer suspiciousAccountTransfer);

    /**
     * Преобразует DTO SuspiciousAccountTransferDTO в сущность SuspiciousAccountTransfer.
     *
     * @param suspiciousAccountTransferDTO DTO SuspiciousAccountTransferDTO
     * @return сущность SuspiciousAccountTransfer
     */
    SuspiciousAccountTransfer toEntity(SuspiciousAccountTransferDTO suspiciousAccountTransferDTO);

    /**
     * Преобразует список сущностей SuspiciousAccountTransfer в список DTO.
     *
     * @param suspiciousAccountTransferList список сущностей SuspiciousAccountTransfer
     * @return список DTO SuspiciousAccountTransferDTO
     */
    List<SuspiciousAccountTransferDTO> toDTOList(List<SuspiciousAccountTransfer> suspiciousAccountTransferList);
}

//Каждый из этих мапперов реализует два метода - toDto и toEntity, которые преобразуют сущность
// в DTO и наоборот. Аннотация @Mapper(componentModel = "spring") указывает, что мы
// используем Mapstruct и хотим, чтобы Spring создавал реализации наших мапперов в качестве Spring бинов.


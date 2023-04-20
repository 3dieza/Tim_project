package com.bank.antifraud.mapper;


import com.bank.antifraud.dto.SuspiciousCardTransferDTO;
import com.bank.antifraud.entity.SuspiciousCardTransfer;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Отображение между сущностью SuspiciousCardTransfer и ее DTO.
 */
@Component
@Mapper(componentModel = "spring")
public interface SuspiciousCardTransferMapper {

    /**
     * Маппинг сущности SuspiciousCardTransfer на DTO SuspiciousCardTransferDTO.
     *
     * @param suspiciousCardTransfer - сущность подозрительного перевода по номеру карты
     * @return DTO SuspiciousCardTransferDTO
     */
    SuspiciousCardTransferDTO toDTO(SuspiciousCardTransfer suspiciousCardTransfer);

    /**
     * Маппинг DTO SuspiciousCardTransferDTO на сущность SuspiciousCardTransfer.
     *
     * @param suspiciousCardTransferDTO - DTO подозрительного перевода по номеру карты
     * @return сущность SuspiciousCardTransfer
     */
    SuspiciousCardTransfer toEntity(SuspiciousCardTransferDTO suspiciousCardTransferDTO);

    /**
     * Маппинг списка сущностей SuspiciousCardTransfer на список DTO SuspiciousCardTransferDTO.
     *
     * @param suspiciousCardTransferList - список сущностей подозрительных переводов по номеру карты
     * @return список DTO SuspiciousCardTransferDTO
     */
    List<SuspiciousCardTransferDTO> toDTOList(List<SuspiciousCardTransfer> suspiciousCardTransferList);
}


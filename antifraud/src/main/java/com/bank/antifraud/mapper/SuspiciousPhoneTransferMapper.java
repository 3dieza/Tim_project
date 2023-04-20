package com.bank.antifraud.mapper;

import com.bank.antifraud.dto.SuspiciousPhoneTransferDTO;

import com.bank.antifraud.entity.SuspiciousPhoneTransfer;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Отображение сущности подозрительных переводов по номеру телефона в DTO и наоборот.
 */
@Component
@Mapper(componentModel = "spring")
public interface SuspiciousPhoneTransferMapper {

    /**
     * Преобразует сущность подозрительных переводов по номеру телефона в DTO.
     *
     * @param suspiciousPhoneTransfer сущность подозрительных переводов по номеру телефона.
     * @return DTO подозрительных переводов по номеру телефона.
     */
    SuspiciousPhoneTransferDTO toDTO(SuspiciousPhoneTransfer suspiciousPhoneTransfer);

    /**
     * Преобразует DTO подозрительных переводов по номеру телефона в сущность.
     *
     * @param suspiciousPhoneTransferDTO DTO подозрительных переводов по номеру телефона.
     * @return сущность подозрительных переводов по номеру телефона.
     */
    SuspiciousPhoneTransfer toEntity(SuspiciousPhoneTransferDTO suspiciousPhoneTransferDTO);

    /**
     * Преобразует список сущностей подозрительных переводов по номеру телефона в список DTO.
     *
     * @param suspiciousPhoneTransferList список сущностей подозрительных переводов по номеру телефона.
     * @return список DTO подозрительных переводов по номеру телефона.
     */
    List<SuspiciousPhoneTransferDTO> toDTOList(List<SuspiciousPhoneTransfer> suspiciousPhoneTransferList);
}

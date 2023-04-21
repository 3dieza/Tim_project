package com.bank.antifraud.mapper;

import com.bank.antifraud.dto.AuditDTO;
import com.bank.antifraud.entity.Audit;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Маппер для сущности Audit. Конвертирует Audit в AuditDTO и наоборот.
 */
@Component
@Mapper(componentModel = "spring")
public interface AuditMapper {

    /**
     * Конвертирует сущность Audit в DTO.
     *
     * @param audit - сущность Audit.
     * @return DTO сущности Audit.
     */
    AuditDTO toDTO(Audit audit);

    /**
     * Конвертирует DTO сущности Audit в сущность Audit.
     *
     * @param auditDTO - DTO сущности Audit.
     * @return сущность Audit.
     */
    Audit toEntity(AuditDTO auditDTO);

    /**
     * Конвертирует список сущностей Audit в список DTO.
     *
     * @param auditList - список сущностей Audit.
     * @return список DTO сущностей Audit.
     */
    List<AuditDTO> toDTOList(List<Audit> auditList);
}




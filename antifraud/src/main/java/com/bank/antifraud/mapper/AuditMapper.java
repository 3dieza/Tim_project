package com.bank.antifraud.mapper;

import com.bank.antifraud.dto.AuditDto;
import com.bank.antifraud.enitiy.Audit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AuditMapper {

    @Mapping(target = "id", ignore = true)
    Audit toAudit(AuditDto auditDto);
}


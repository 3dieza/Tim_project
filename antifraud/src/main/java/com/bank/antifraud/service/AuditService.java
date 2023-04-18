package com.bank.antifraud.service;

import com.bank.antifraud.dto.AuditDTO;

import java.util.List;

public interface AuditService {
    //интерфейс сервиса для работы с сущностью аудита
    AuditDTO getById(Long id);

    List<AuditDTO> getAll();

    AuditDTO save(AuditDTO dto);

    AuditDTO update(AuditDTO dto);

    void deleteById(Long id);

}

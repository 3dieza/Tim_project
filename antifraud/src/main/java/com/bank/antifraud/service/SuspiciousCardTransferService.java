package com.bank.antifraud.service;

import com.bank.antifraud.dto.SuspiciousCardTransferDTO;

import java.util.List;

public interface SuspiciousCardTransferService {
    SuspiciousCardTransferDTO getById(Long id);

    List<SuspiciousCardTransferDTO> getAll();

    SuspiciousCardTransferDTO save(SuspiciousCardTransferDTO dto);

    SuspiciousCardTransferDTO update(SuspiciousCardTransferDTO dto);

    void deleteById(Long id);
}


package com.bank.antifraud.service;

import com.bank.antifraud.dto.SuspiciousAccountTransferDTO;


import java.util.List;

public interface SuspiciousAccountTransferService {
    SuspiciousAccountTransferDTO getById(Long id);

    List<SuspiciousAccountTransferDTO> getAll();

    SuspiciousAccountTransferDTO save(SuspiciousAccountTransferDTO dto);

    SuspiciousAccountTransferDTO update(SuspiciousAccountTransferDTO dto);

    void deleteById(Long id);
}


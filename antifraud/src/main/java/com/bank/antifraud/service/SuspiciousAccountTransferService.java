package com.bank.antifraud.service;


import com.bank.antifraud.dto.SuspiciousAccountTransferDto;
import com.bank.antifraud.enitiy.SuspiciousAccountTransfers;

import java.util.List;

public interface SuspiciousAccountTransferService {
    SuspiciousAccountTransfers create(SuspiciousAccountTransferDto suspiciousAccountTransferDto);

    SuspiciousAccountTransfers getById(Long id);

    List<SuspiciousAccountTransfers> getAll();

    SuspiciousAccountTransfers update(Long id, SuspiciousAccountTransferDto suspiciousAccountTransferDto);

    void delete(Long id);
}

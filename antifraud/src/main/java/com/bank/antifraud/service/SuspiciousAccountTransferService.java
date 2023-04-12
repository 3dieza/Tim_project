package com.bank.antifraud.service;


import com.bank.antifraud.dto.SuspiciousAccountTransferDto;
import com.bank.antifraud.enitiy.SuspiciousAccountTransfer;

import java.util.List;

public interface SuspiciousAccountTransferService {
    SuspiciousAccountTransfer create(SuspiciousAccountTransferDto suspiciousAccountTransferDto);
    SuspiciousAccountTransfer getById(Long id);
    List<SuspiciousAccountTransfer> getAll();
    SuspiciousAccountTransfer update(Long id, SuspiciousAccountTransferDto suspiciousAccountTransferDto);
    void delete(Long id);
}

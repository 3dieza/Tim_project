package com.bank.antifraud.service;

import com.bank.antifraud.dto.SuspiciousPhoneTransferDto;
import com.bank.antifraud.enitiy.SuspiciousPhoneTransfers;


public interface SuspiciousPhoneTransferService {

    SuspiciousPhoneTransfers save(SuspiciousPhoneTransferDto suspiciousPhoneTransferDto);

    SuspiciousPhoneTransfers getById(Long id);

    void deleteById(Long id);
}

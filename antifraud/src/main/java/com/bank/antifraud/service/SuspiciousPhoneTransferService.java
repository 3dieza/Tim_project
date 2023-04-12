package com.bank.antifraud.service;

import com.bank.antifraud.dto.SuspiciousPhoneTransferDto;
import com.bank.antifraud.enitiy.SuspiciousPhoneTransfer;


public interface SuspiciousPhoneTransferService {

    SuspiciousPhoneTransfer save(SuspiciousPhoneTransferDto suspiciousPhoneTransferDto);

    SuspiciousPhoneTransfer getById(Long id);

    void deleteById(Long id);
}

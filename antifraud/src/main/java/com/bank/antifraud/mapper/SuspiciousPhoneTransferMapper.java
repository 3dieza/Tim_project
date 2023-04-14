package com.bank.antifraud.mapper;

import com.bank.antifraud.dto.SuspiciousPhoneTransferDto;

import com.bank.antifraud.enitiy.SuspiciousPhoneTransfers;
import org.mapstruct.Mapper;

@Mapper
public interface SuspiciousPhoneTransferMapper {

    SuspiciousPhoneTransfers toSuspiciousPhoneTransfer(SuspiciousPhoneTransferDto suspiciousPhoneTransferDto);
}


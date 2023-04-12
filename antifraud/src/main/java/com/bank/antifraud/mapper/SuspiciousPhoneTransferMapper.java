package com.bank.antifraud.mapper;

import com.bank.antifraud.dto.SuspiciousPhoneTransferDto;

import com.bank.antifraud.enitiy.SuspiciousPhoneTransfer;
import org.mapstruct.Mapper;

@Mapper
public interface SuspiciousPhoneTransferMapper {

    SuspiciousPhoneTransfer toSuspiciousPhoneTransfer(SuspiciousPhoneTransferDto suspiciousPhoneTransferDto);
}
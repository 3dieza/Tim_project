package com.bank.antifraud.mapper;


import com.bank.antifraud.dto.SuspiciousCardTransferDto;

import com.bank.antifraud.enitiy.SuspiciousCardTransfer;
import org.mapstruct.Mapper;

@Mapper
public interface SuspiciousCardTransferMapper {

    SuspiciousCardTransfer toSuspiciousCardTransfer(SuspiciousCardTransferDto suspiciousCardTransferDto);
}


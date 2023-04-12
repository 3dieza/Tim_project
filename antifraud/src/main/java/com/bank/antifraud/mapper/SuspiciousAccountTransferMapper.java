package com.bank.antifraud.mapper;
import com.bank.antifraud.dto.SuspiciousAccountTransferDto;

import com.bank.antifraud.enitiy.SuspiciousAccountTransfer;
import org.mapstruct.Mapper;


    @Mapper
    public interface SuspiciousAccountTransferMapper {

        SuspiciousAccountTransfer toSuspiciousAccountTransfer(SuspiciousAccountTransferDto suspiciousAccountTransferDto);
    }


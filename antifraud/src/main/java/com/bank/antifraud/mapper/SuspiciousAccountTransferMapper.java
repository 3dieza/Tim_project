package com.bank.antifraud.mapper;

import com.bank.antifraud.dto.SuspiciousAccountTransferDto;

import com.bank.antifraud.enitiy.SuspiciousAccountTransfers;
import org.mapstruct.Mapper;


@Mapper
public interface SuspiciousAccountTransferMapper {

    SuspiciousAccountTransfers toSuspiciousAccountTransfer(SuspiciousAccountTransferDto suspiciousAccountTransferDto);
}


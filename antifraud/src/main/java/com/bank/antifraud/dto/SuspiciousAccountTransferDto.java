package com.bank.antifraud.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SuspiciousAccountTransferDto {
    private String blockedReason;

//    private Long id;
//
//    private Long accountTransferId;
//
//    private Boolean isBlocked;
//
//    private Boolean isSuspicious;
//
//
//    private String suspiciousReason;
}
package com.bank.antifraud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SuspiciousCardTransferDto {
    private String blockedReason;

//    private Long id;
//
//    private Long cardTransferId;
//
//    private Boolean isBlocked;
//
//    private Boolean isSuspicious;
//

//    private String suspiciousReason;
}
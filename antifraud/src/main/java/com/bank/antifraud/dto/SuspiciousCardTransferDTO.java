package com.bank.antifraud.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuspiciousCardTransferDTO {
    private String blockedReason;
    private Long id;

    private Long cardTransferId;

    private Boolean isBlocked;

    private Boolean isSuspicious;


    private String suspiciousReason;

}


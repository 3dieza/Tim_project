package com.bank.antifraud.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuspiciousAccountTransferDTO {
    //    DTO для сущностей подозрительных переводов
    private String blockedReason;
    private Long id;

    private Long accountTransferId;

    private Boolean isBlocked;

    private Boolean isSuspicious;


    private String suspiciousReason;

}


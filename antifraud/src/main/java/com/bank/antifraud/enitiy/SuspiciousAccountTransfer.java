package com.bank.antifraud.enitiy;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "suspicious_account_transfers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SuspiciousAccountTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_transfer_id")
    private Long accountTransferId;

    @Column(name = "is_blocked")
    private Boolean isBlocked;

    @Column(name = "is_suspicious")
    private Boolean isSuspicious;

    @Column(name = "blocked_reason")
    private String blockedReason;

    @Column(name = "suspicious_reason")
    private String suspiciousReason;


}


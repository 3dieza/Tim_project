package com.bank.antifraud.enitiy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
/*Этот код создает сущность SuspiciousCardTransfer, которая соответствует таблице anti_fraud.suspicious_card_transfer
с шестью столбцами (id, card_transfer_id, is_blocked, is_suspicious, blocked_reason, suspicious_reason).
Также в коде используется Lombok для создания геттеров, сеттеров, конструкторов и методов equals, hashCode и toString.
 */
@Entity
@Table(name = "suspicious_card_transfer", schema = "anti_fraud")
@NoArgsConstructor
@AllArgsConstructor

public class SuspiciousCardTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "card_transfer_id")
    private Long cardTransferId;

    @Column(name = "is_blocked")
    private Boolean isBlocked;

    @Column(name = "is_suspicious")
    private Boolean isSuspicious;

    @Column(name = "blocked_reason")
    private String blockedReason;

    @Column(name = "suspicious_reason")
    private String suspiciousReason;

}

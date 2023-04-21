package com.bank.antifraud.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Сущность подозрительных переводов средств на счета.
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "suspicious_account_transfers", schema = "anti_fraud")
public class SuspiciousAccountTransfer {

    /**
     * Уникальный идентификатор сущности.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Идентификатор перевода на счет.
     */
    @Column(name = "account_transfer_id", unique = true)
    private Long accountTransferId;
    /**
     * Признак блокировки перевода.
     */
    @Column(name = "is_blocked")
    private Boolean isBlocked;
    /**
     * Признак подозрительности перевода.
     */
    @Column(name = "is_suspicious")
    private Boolean isSuspicious;
    /**
     * Причина блокировки перевода.
     */

    @Column(name = "blocked_reason")
    private String blockedReason;
    /**
     * Причина подозрительности перевода.
     */

    @Column(name = "suspicious_reason")
    private String suspiciousReason;
}



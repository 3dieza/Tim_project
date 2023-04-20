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


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "suspicious_phone_transfers", schema = "anti_fraud")
public class SuspiciousPhoneTransfer {
    /*

    Идентификатор сущности.
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Идентификатор перевода по номеру телефона.
     */
    @Column(name = "phone_transfer_id", unique = true)
    private Long phoneTransferId;
    /**
     * Флаг, указывающий, заблокирован ли перевод.
     */
    @Column(name = "is_blocked")
    private Boolean isBlocked;
    /**
     * Флаг, указывающий, является ли перевод подозрительным.
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


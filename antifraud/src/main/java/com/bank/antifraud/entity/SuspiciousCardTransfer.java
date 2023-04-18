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
import javax.validation.constraints.NotNull;


@Getter
@Setter
@ToString

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "suspicious_card_transfer", schema = "anti_fraud")


public class SuspiciousCardTransfer {
    //    сущность подозрительных переводов средств на карты
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "card_transfer_id", unique = true)
    private Long cardTransferId;

    @Column(name = "is_blocked")
    private Boolean isBlocked;

    @Column(name = "is_suspicious")
    private Boolean isSuspicious;
    @NotNull
    @Column(name = "blocked_reason")
    private String blockedReason;

    @Column(name = "suspicious_reason")
    private String suspiciousReason;


}

//Этот код создает сущность SuspiciousCardTransfer, которая соответствует таблице anti_fraud.suspicious_card_transfer
//с шестью столбцами (id, card_transfer_id, is_blocked, is_suspicious, blocked_reason, suspicious_reason).
//Также в коде используется Lombok для создания геттеров, сеттеров, конструкторов и методов equals, hashCode и toString.




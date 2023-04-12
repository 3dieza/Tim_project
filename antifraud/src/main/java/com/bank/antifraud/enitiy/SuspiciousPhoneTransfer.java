package com.bank.antifraud.enitiy;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "suspicious_phone_transfers")
@Getter
@Setter
@NoArgsConstructor
public class SuspiciousPhoneTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phone_transfer_id")
    private Long phoneTransferId;

    @Column(name = "is_blocked")
    private Boolean isBlocked;

    @Column(name = "is_suspicious")
    private Boolean isSuspicious;

    @Column(name = "blocked_reason")
    private String blockedReason;

    @Column(name = "suspicious_reason")
    private String suspiciousReason;

    public SuspiciousPhoneTransfer(Long phoneTransferId, Boolean isBlocked, Boolean isSuspicious, String blockedReason, String suspiciousReason) {
        this.phoneTransferId = phoneTransferId;
        this.isBlocked = isBlocked;
        this.isSuspicious = isSuspicious;
        this.blockedReason = blockedReason;
        this.suspiciousReason = suspiciousReason;
    }
}
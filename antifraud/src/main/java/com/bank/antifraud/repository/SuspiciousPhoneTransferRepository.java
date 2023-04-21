package com.bank.antifraud.repository;

import com.bank.antifraud.entity.SuspiciousPhoneTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерфейс репозитория для сущности подозрительных переводов по номеру телефона, расширяющий JpaRepository.
 */
@Repository
public interface SuspiciousPhoneTransferRepository extends JpaRepository<SuspiciousPhoneTransfer, Long> {
}

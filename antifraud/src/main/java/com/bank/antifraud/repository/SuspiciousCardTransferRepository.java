package com.bank.antifraud.repository;


import com.bank.antifraud.entity.SuspiciousCardTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерфейс репозитория для сущности подозрительных переводов на карты, расширяющий JpaRepository.
 */
@Repository
public interface SuspiciousCardTransferRepository extends JpaRepository<SuspiciousCardTransfer, Long> {
}

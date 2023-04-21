package com.bank.antifraud.repository;

import com.bank.antifraud.entity.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерфейс репозитория для сущности аудита.
 * Расширяет JpaRepository для работы с базой данных.
 */
@Repository
public interface AuditRepository extends JpaRepository<Audit, Long> {
}

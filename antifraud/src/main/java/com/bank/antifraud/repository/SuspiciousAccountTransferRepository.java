package com.bank.antifraud.repository;

import com.bank.antifraud.enitiy.SuspiciousAccountTransfers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuspiciousAccountTransferRepository extends JpaRepository<SuspiciousAccountTransfers, Long> {
}

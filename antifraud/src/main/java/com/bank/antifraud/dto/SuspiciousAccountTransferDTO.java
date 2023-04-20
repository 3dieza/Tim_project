package com.bank.antifraud.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Объект передачи данных для подозрительных переводов.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuspiciousAccountTransferDTO {
    /**
     * Причина блокировки перевода.
     */
    @Nullable
    @Size(max = 255, message = "Причина блокировки перевода не может превышать {max} символов.")
    private String blockedReason;
    /**
     * Идентификатор подозрительного перевода.
     */
    private Long id;
    /**
     * Идентификатор перевода, связанного с подозрительным переводом.
     */
    @NotNull(message = "Идентификатор перевода не может быть пустым.")
    private Long accountTransferId;
    /**
     * Флаг, указывающий, заблокирован ли подозрительный перевод.
     */
    @NotNull(message = "Флаг блокировки перевода не может быть пустым.")
    private Boolean isBlocked;
    /**
     * Флаг, указывающий, является ли перевод подозрительным.
     */
    @NotNull(message = "Флаг подозрительности перевода не может быть пустым.")
    private Boolean isSuspicious;
    /**
     * Причина, почему перевод считается подозрительным.
     */
    @NotNull(message = "Причина подозрительности перевода не может быть пустой.")
    @Size(max = 255, message = "Причина подозрительности перевода не может превышать {max} символов.")
    @Column(name = "suspicious_reason")
    private String suspiciousReason;
}


package com.bank.antifraud.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Класс DTO для перевода денежных средств между телефонами.
 * <p>
 * Содержит информацию о переводе, его статусе и причине блокировки (если применимо).
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuspiciousPhoneTransferDTO {
    /*

    Причина блокировки перевода.
    */
    @Nullable
    private String blockedReason;
    /**
     * Идентификатор перевода.
     */
    private Long id;
    /**
     * Идентификатор перевода между телефонами.
     */
    @NotNull(message = "Идентификатор перевода не может быть пустым.")
    private Long phoneTransferId;
    /**
     * Флаг, указывающий на то, заблокирован ли перевод.
     */
    private Boolean isBlocked;
    /**
     * Флаг, указывающий на то, является ли перевод подозрительным.
     */
    private Boolean isSuspicious;
    /**
     * Причина, по которой перевод был помечен как подозрительный.
     */
    @Size(max = 255, message = "причина не может превышать {max} символов.")
    private String suspiciousReason;
}


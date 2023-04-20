package com.bank.antifraud.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * Класс SuspiciousCardTransferDTO описывает трансфер между картами,
 * <p>
 * который может быть отмечен как подозрительный и заблокирован в целях предотвращения мошенничества.
 * <p>
 * Содержит информацию о причинах блокировки, идентификаторе трансфера, флагах блокировки и подозрительности,
 * <p>
 * а также причину, по которой трансфер был помечен как подозрительный.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuspiciousCardTransferDTO {

    /**
     * Причина блокировки трансфера.
     */
    @Nullable
    private String blockedReason;
    /**
     * Идентификатор трансфера.
     */
    private Long id;
    /**
     * Идентификатор трансфера между картами.
     */
    @NotNull(message = "Идентификатор перевода не может быть пустым.")
    private Long cardTransferId;
    /**
     * Флаг блокировки трансфера.
     */
    private Boolean isBlocked;
    /**
     * Флаг подозрительности трансфера.
     */
    private Boolean isSuspicious;
    /**
     * Причина, по которой трансфер был помечен как подозрительный.
     */
    @Size(max = 255, message = "причина не может превышать {max} символов.")
    private String suspiciousReason;
}



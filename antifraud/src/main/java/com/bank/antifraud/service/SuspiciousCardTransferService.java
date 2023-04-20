package com.bank.antifraud.service;

import com.bank.antifraud.dto.SuspiciousCardTransferDTO;

import java.util.List;

/**
 * Интерфейс сервиса для работы с подозрительными переводами средств по карте.
 */
public interface SuspiciousCardTransferService {

    /**
     * Получает данные о подозрительном переводе средств по идентификатору.
     *
     * @param id Идентификатор перевода.
     * @return DTO с данными о подозрительном переводе средств по карте.
     */
    SuspiciousCardTransferDTO getById(Long id);

    /**
     * Получает список всех подозрительных переводов средств по картам.
     *
     * @return Список DTO с данными о подозрительных переводах средств по картам.
     */
    List<SuspiciousCardTransferDTO> getAll();

    /**
     * Сохраняет данные о новом подозрительном переводе средств по карте.
     *
     * @param dto DTO с данными о новом подозрительном переводе средств по карте.
     * @return DTO с сохраненными данными о подозрительном переводе средств по карте.
     */
    SuspiciousCardTransferDTO save(SuspiciousCardTransferDTO dto);

    /**
     * Обновляет данные о подозрительном переводе средств по карте.
     *
     * @param dto DTO с обновленными данными о подозрительном переводе средств по карте.
     * @return DTO с обновленными данными о подозрительном переводе средств по карте.
     */
    SuspiciousCardTransferDTO update(SuspiciousCardTransferDTO dto);

    /**
     * Удаляет данные о подозрительном переводе средств по карте по идентификатору.
     *
     * @param id Идентификатор перевода.
     */
    void deleteById(Long id);
}


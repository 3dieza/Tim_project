package com.bank.antifraud.service;

import com.bank.antifraud.dto.SuspiciousAccountTransferDTO;


import java.util.List;

/**
 * Интерфейс сервиса подозрительных переводов между счетами.
 */
public interface SuspiciousAccountTransferService {

    /**
     * Получает DTO подозрительного перевода по идентификатору.
     *
     * @param id идентификатор подозрительного перевода
     * @return DTO подозрительного перевода
     */
    SuspiciousAccountTransferDTO getById(Long id);

    /**
     * Получает список DTO всех подозрительных переводов.
     *
     * @return список DTO подозрительных переводов
     */
    List<SuspiciousAccountTransferDTO> getAll();

    /**
     * Сохраняет DTO подозрительного перевода.
     *
     * @param dto DTO подозрительного перевода для сохранения
     * @return сохраненный DTO подозрительного перевода
     */
    SuspiciousAccountTransferDTO save(SuspiciousAccountTransferDTO dto);

    /**
     * Обновляет DTO подозрительного перевода.
     *
     * @param dto DTO подозрительного перевода для обновления
     * @return обновленный DTO подозрительного перевода
     */
    SuspiciousAccountTransferDTO update(SuspiciousAccountTransferDTO dto);

    /**
     * Удаляет подозрительный перевод по идентификатору.
     *
     * @param id идентификатор подозрительного перевода
     */
    void deleteById(Long id);
}


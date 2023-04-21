package com.bank.antifraud.service;


import com.bank.antifraud.dto.SuspiciousPhoneTransferDTO;

import java.util.List;


/**
 * Интерфейс сервиса для работы с сущностями подозрительных переводов по номеру телефона.
 */
public interface SuspiciousPhoneTransferService {

    /**
     * Получает подозрительный перевод по идентификатору.
     *
     * @param id идентификатор подозрительного перевода.
     * @return объект DTO, содержащий информацию о подозрительном переводе.
     */
    SuspiciousPhoneTransferDTO getById(Long id);

    /**
     * Получает список всех подозрительных переводов.
     *
     * @return список объектов DTO, содержащих информацию о подозрительных переводах.
     */
    List<SuspiciousPhoneTransferDTO> getAll();

    /**
     * Сохраняет новый подозрительный перевод.
     *
     * @param dto объект DTO, содержащий информацию о подозрительном переводе.
     * @return объект DTO, содержащий информацию о сохранённом подозрительном переводе.
     */
    SuspiciousPhoneTransferDTO save(SuspiciousPhoneTransferDTO dto);

    /**
     * Обновляет информацию о подозрительном переводе.
     *
     * @param dto объект DTO, содержащий обновлённую информацию о подозрительном переводе.
     * @return объект DTO, содержащий информацию об обновлённом подозрительном переводе.
     */
    SuspiciousPhoneTransferDTO update(SuspiciousPhoneTransferDTO dto);

    /**
     * Удаляет подозрительный перевод по идентификатору.
     *
     * @param id идентификатор подозрительного перевода.
     */
    void deleteById(Long id);
}

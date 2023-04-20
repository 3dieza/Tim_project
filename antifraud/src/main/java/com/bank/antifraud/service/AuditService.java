package com.bank.antifraud.service;

import com.bank.antifraud.dto.AuditDTO;

import java.util.List;

/**
 * Интерфейс сервиса для работы с сущностью аудита
 */
public interface AuditService {

    /**
     * Получение DTO аудита по id.
     *
     * @param id идентификатор аудита
     * @return DTO аудита
     */
    AuditDTO getById(Long id);

    /**
     * Получение всех DTO аудитов.
     *
     * @return список DTO аудитов
     */
    List<AuditDTO> getAll();

    /**
     * Сохранение нового DTO аудита.
     *
     * @param dto DTO аудита для сохранения
     * @return сохраненный DTO аудита
     */
    AuditDTO save(AuditDTO dto);

    /**
     * Обновление DTO аудита.
     *
     * @param dto DTO аудита для обновления
     * @return обновленный DTO аудита
     */
    AuditDTO update(AuditDTO dto);

    /**
     * Удаление DTO аудита по id.
     *
     * @param id идентификатор аудита для удаления
     */
    void deleteById(Long id);
}

package com.bank.antifraud.service;


import com.bank.antifraud.dto.AuditDTO;
import com.bank.antifraud.entity.Audit;
import com.bank.antifraud.mapper.AuditMapper;
import com.bank.antifraud.repository.AuditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Класс-реализация сервиса для работы с сущностью аудита.
 * <p>
 * Осуществляет CRUD операции над аудитом.
 */
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AuditServiceImpl implements AuditService {

    private final AuditRepository auditRepository;
    private final AuditMapper accountMapper;

    /**
     * Получение аудита по ID.
     *
     * @param id Идентификатор аудита.
     * @return DTO аудита.
     * @throws EntityNotFoundException если аудит с указанным ID не найден.
     */
    @Override
    public AuditDTO getById(final Long id) {
        final Audit audit = auditRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Audit not found with id " + id));
        return accountMapper.toDTO(audit);
    }

    /**
     * Получение списка всех аудитов.
     *
     * @return Список DTO аудитов.
     */
    @Override
    public List<AuditDTO> getAll() {
        final List<Audit> audits = auditRepository.findAll();
        return accountMapper.toDTOList(audits);
    }

    /**
     * Сохранение аудита.
     *
     * @param dto DTO аудита для сохранения.
     * @return Сохраненный DTO аудита.
     */
    @Override
    public AuditDTO save(AuditDTO dto) {
        final Audit entity = accountMapper.toEntity(dto);
        final Audit savedEntity = auditRepository.save(entity);
        return accountMapper.toDTO(savedEntity);
    }

    /**
     * Обновление аудита.
     *
     * @param dto DTO аудита для обновления.
     * @return Обновленный DTO аудита.
     * @throws EntityNotFoundException если аудит с указанным ID не найден.
     */
    @Override
    public AuditDTO update(AuditDTO dto) {
        getById(dto.getId());
        Audit audit = accountMapper.toEntity(dto);
        audit = auditRepository.save(audit);
        return accountMapper.toDTO(audit);
    }

    /**
     * Удаление аудита по ID.
     *
     * @param id Идентификатор аудита для удаления.
     * @throws EntityNotFoundException если аудит с указанным ID не найден.
     */
    @Override
    public void deleteById(Long id) {
        getById(id);
        auditRepository.deleteById(id);
    }
}


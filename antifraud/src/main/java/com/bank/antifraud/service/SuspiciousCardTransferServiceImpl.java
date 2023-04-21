package com.bank.antifraud.service;

import com.bank.antifraud.dto.SuspiciousCardTransferDTO;
import com.bank.antifraud.entity.SuspiciousCardTransfer;
import com.bank.antifraud.mapper.SuspiciousCardTransferMapper;
import com.bank.antifraud.repository.SuspiciousCardTransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;


/**
 * Реализация сервиса для работы с сущностями подозрительных переводов на карты.
 * <p>
 * Содержит методы для получения, сохранения, изменения и удаления данных о подозрительных переводах.
 */
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class SuspiciousCardTransferServiceImpl implements SuspiciousCardTransferService {

    /**
     * Репозиторий для работы с сущностью подозрительных переводов на карты.
     */
    private final SuspiciousCardTransferRepository repository;
    /**
     * Маппер для преобразования сущности в DTO и наоборот.
     */
    private final SuspiciousCardTransferMapper mapper;

    /**
     * Получает сущность подозрительных переводов на карты по заданному идентификатору.
     *
     * @param id идентификатор сущности.
     * @return DTO сущности подозрительных переводов на карты.
     * @throws EntityNotFoundException если сущность не найдена.
     */
    @Override
    public SuspiciousCardTransferDTO getById(Long id) throws EntityNotFoundException {
        final SuspiciousCardTransfer entity = repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("SuspiciousCardTransfer not found with id: " + id));
        return mapper.toDTO(entity);
    }

    /**
     * Получает список всех сущностей подозрительных переводов на карты.
     *
     * @return список DTO сущностей подозрительных переводов на карты.
     */
    @Override
    public List<SuspiciousCardTransferDTO> getAll() {
        final List<SuspiciousCardTransfer> entities = repository.findAll();
        return mapper.toDTOList(entities);
    }

    /**
     * Сохраняет сущность подозрительных переводов на карты.
     *
     * @param dto DTO сущности подозрительных переводов на карты.
     * @return сохраненную DTO сущности подозрительных переводов на карты.
     */
    @Override
    public SuspiciousCardTransferDTO save(SuspiciousCardTransferDTO dto) {
        final SuspiciousCardTransfer entity = mapper.toEntity(dto);
        final SuspiciousCardTransfer savedEntity = repository.save(entity);
        return mapper.toDTO(savedEntity);
    }

    /**
     * Обновляет сущность подозрительных переводов на карты.
     *
     * @param dto DTO сущности подозрительных переводов на карты.
     * @return обновленную DTO сущности подозрительных переводов на карты.
     */
    @Override
    public SuspiciousCardTransferDTO update(SuspiciousCardTransferDTO dto) {
        final SuspiciousCardTransfer entity = mapper.toEntity(dto);
        final SuspiciousCardTransfer updatedEntity = repository.save(entity);
        return mapper.toDTO(updatedEntity);
    }

    /**
     * Удаляет сущность подозрительных переводов на карты по заданному идентификатору.
     *
     * @param id идентификатор сущности.
     */
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

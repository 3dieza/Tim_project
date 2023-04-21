package com.bank.antifraud.service;

import com.bank.antifraud.dto.SuspiciousAccountTransferDTO;
import com.bank.antifraud.entity.SuspiciousAccountTransfer;
import com.bank.antifraud.mapper.SuspiciousAccountTransferMapper;
import com.bank.antifraud.repository.SuspiciousAccountTransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Сервис для работы с сущностью SuspiciousAccountTransfer.
 * <p>
 * SuspiciousAccountTransfer представляет собой подозрительный перевод средств между счетами.
 * <p>
 * Содержит информацию о счете отправителя и получателя, сумме перевода, дате и причине подозрительности.
 */
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class SuspiciousAccountTransferServiceImpl implements SuspiciousAccountTransferService {

    /**
     * Репозиторий для работы с сущностью SuspiciousAccountTransfer.
     */
    private final SuspiciousAccountTransferRepository repository;
    /**
     * Маппер для преобразования сущности SuspiciousAccountTransfer в DTO и обратно.
     */
    private final SuspiciousAccountTransferMapper mapper;

    /**
     * Получение подозрительного перевода средств по идентификатору.
     *
     * @param id идентификатор подозрительного перевода средств.
     * @return DTO подозрительного перевода средств.
     * @throws EntityNotFoundException если подозрительный перевод с указанным идентификатором не найден.
     */
    @Override
    public SuspiciousAccountTransferDTO getById(Long id) {
        final SuspiciousAccountTransfer entity = repository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("SuspiciousAccountTransfer not found with id: " + id));
        return mapper.toDTO(entity);
    }

    /**
     * Получение списка всех подозрительных переводов средств.
     *
     * @return список DTO подозрительных переводов средств.
     */
    @Override
    public List<SuspiciousAccountTransferDTO> getAll() {
        final List<SuspiciousAccountTransfer> entities = repository.findAll();
        return mapper.toDTOList(entities);
    }

    /**
     * Сохранение подозрительного перевода средств.
     *
     * @param dto DTO подозрительного перевода средств для сохранения.
     * @return сохраненный DTO подозрительного перевода средств.
     */
    @Override
    public SuspiciousAccountTransferDTO save(SuspiciousAccountTransferDTO dto) {
        final SuspiciousAccountTransfer entity = mapper.toEntity(dto);
        final SuspiciousAccountTransfer savedEntity = repository.save(entity);
        return mapper.toDTO(savedEntity);
    }

    /**
     * Обновление подозрительного перевода средств.
     *
     * @param dto DTO подозрительного перевода средств для обновления.
     * @return обновленный DTO подозрительного перевода средств.
     */
    @Override
    public SuspiciousAccountTransferDTO update(SuspiciousAccountTransferDTO dto) {
        final SuspiciousAccountTransfer entity = mapper.toEntity(dto);
        final SuspiciousAccountTransfer updatedEntity = repository.save(entity);
        return mapper.toDTO(updatedEntity);
    }

    /**
     * Удаление подозрительного перевода средств по идентификатору.
     *
     * @param id идентификатор подозрительного перевода средств для удаления.
     */
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

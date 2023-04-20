package com.bank.antifraud.service;

import com.bank.antifraud.dto.SuspiciousPhoneTransferDTO;
import com.bank.antifraud.entity.SuspiciousPhoneTransfer;
import com.bank.antifraud.mapper.SuspiciousPhoneTransferMapper;
import com.bank.antifraud.repository.SuspiciousPhoneTransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Реализация сервиса для работы с сущностью "Подозрительный перевод по номеру телефона"
 */
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class SuspiciousPhoneTransferServiceImpl implements SuspiciousPhoneTransferService {

    private final SuspiciousPhoneTransferRepository repository; // репозиторий для работы с базой данных
    private final SuspiciousPhoneTransferMapper mapper; // маппер для преобразования DTO и сущностей

    /**
     * Получение подозрительного перевода по идентификатору
     *
     * @param id идентификатор подозрительного перевода
     * @return DTO подозрительного перевода
     * @throws EntityNotFoundException если подозрительный перевод не найден в базе данных
     */
    @Override
    public SuspiciousPhoneTransferDTO getById(Long id) throws EntityNotFoundException {
        final SuspiciousPhoneTransfer suspiciousPhoneTransfer = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Suspicious phone transfer not found with id " + id));
        return mapper.toDTO(suspiciousPhoneTransfer);
    }

    /**
     * Получение списка всех подозрительных переводов
     *
     * @return список DTO подозрительных переводов
     */
    @Override
    public List<SuspiciousPhoneTransferDTO> getAll() {
        final List<SuspiciousPhoneTransfer> suspiciousPhoneTransfers = repository.findAll();
        return mapper.toDTOList(suspiciousPhoneTransfers);
    }

    /**
     * Сохранение нового подозрительного перевода
     *
     * @param dto DTO подозрительного перевода для сохранения
     * @return DTO сохраненного подозрительного перевода
     */
    @Override
    public SuspiciousPhoneTransferDTO save(SuspiciousPhoneTransferDTO dto) {
        final SuspiciousPhoneTransfer entity = mapper.toEntity(dto);
        final SuspiciousPhoneTransfer savedEntity = repository.save(entity);
        return mapper.toDTO(savedEntity);
    }

    /**
     * Обновление существующего подозрительного перевода
     *
     * @param dto DTO подозрительного перевода для обновления
     * @return DTO обновленного подозрительного перевода
     * @throws EntityNotFoundException если подозрительный перевод не найден в базе данных
     */
    @Override
    public SuspiciousPhoneTransferDTO update(SuspiciousPhoneTransferDTO dto) throws EntityNotFoundException {
        getById(dto.getId());
        SuspiciousPhoneTransfer suspiciousPhoneTransfer = mapper.toEntity(dto);
        suspiciousPhoneTransfer = repository.save(suspiciousPhoneTransfer);
        return mapper.toDTO(suspiciousPhoneTransfer);
    }

    /**
     * Удаление подозрительного перевода по идентификатору
     *
     * @param id идентификатор подозрительного перевода для удаления
     * @throws EntityNotFoundException если подозрительный перевод не найден в базе данных
     */
    @Override
    public void deleteById(Long id) throws EntityNotFoundException {
        getById(id);
        repository.deleteById(id);
    }
}


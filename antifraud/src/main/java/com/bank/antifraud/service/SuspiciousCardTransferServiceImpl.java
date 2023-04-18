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


//класс-реализация сервиса для работы с сущностями подозрительных переводов на карты
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class SuspiciousCardTransferServiceImpl implements SuspiciousCardTransferService {

    private final SuspiciousCardTransferRepository repository;
    private final SuspiciousCardTransferMapper mapper;

    @Override
    public SuspiciousCardTransferDTO getById(Long id) {
        SuspiciousCardTransfer entity = repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("SuspiciousCardTransfer not found with id: " + id));
        return mapper.toDTO(entity);
    }

    @Override
    public List<SuspiciousCardTransferDTO> getAll() {
        List<SuspiciousCardTransfer> entities = repository.findAll();
        return mapper.toDTOList(entities);
    }

    @Override
    public SuspiciousCardTransferDTO save(SuspiciousCardTransferDTO dto) {
        SuspiciousCardTransfer entity = mapper.toEntity(dto);
        SuspiciousCardTransfer savedEntity = repository.save(entity);
        return mapper.toDTO(savedEntity);
    }

    @Override
    public SuspiciousCardTransferDTO update(SuspiciousCardTransferDTO dto) {
        SuspiciousCardTransfer entity = mapper.toEntity(dto);
        SuspiciousCardTransfer updatedEntity = repository.save(entity);
        return mapper.toDTO(updatedEntity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
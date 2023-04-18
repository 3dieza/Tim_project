package com.bank.antifraud.service;


import com.bank.antifraud.dto.SuspiciousPhoneTransferDTO;

import java.util.List;


public interface SuspiciousPhoneTransferService {

    //интерфейс сервиса для работы с сущностями подозрительных переводов по номеру телефона
    SuspiciousPhoneTransferDTO getById(Long id);

    List<SuspiciousPhoneTransferDTO> getAll();

    SuspiciousPhoneTransferDTO save(SuspiciousPhoneTransferDTO dto);

    SuspiciousPhoneTransferDTO update(SuspiciousPhoneTransferDTO dto);

    void deleteById(Long id);
}

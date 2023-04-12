//package com.bank.antifraud.service;
//
//import com.bank.antifraud.dto.AuditDto;
//import com.bank.antifraud.enitiy.SuspiciousCardTransfer;
//import com.bank.antifraud.repository.SuspiciousCardTransferRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class SuspiciousCardTransferServiceImpl implements SuspiciousCardTransferService {
//
//    private final SuspiciousCardTransferRepository suspiciousCardTransferRepository;
//    private final AuditService auditService;
//
//    public SuspiciousCardTransferServiceImpl(SuspiciousCardTransferRepository suspiciousCardTransferRepository,
//                                             AuditService auditService) {
//        this.suspiciousCardTransferRepository = suspiciousCardTransferRepository;
//        this.auditService = auditService;
//    }
//
//    @Override
//    public SuspiciousCardTransfer save(SuspiciousCardTransfer suspiciousCardTransfer) {
//        SuspiciousCardTransfer saved = suspiciousCardTransferRepository.save(suspiciousCardTransfer);
//        auditService.save(new AuditDto(EntityType.SUSPICIOUS_CARD_TRANSFER, OperationType.CREATE, saved.getId(), null,
//                saved));
//        return saved;
//    }
//
//    @Override
//    public SuspiciousCardTransfer findById(Long id) {
//        return suspiciousCardTransferRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("SuspiciousCardTransfer", "id", id));
//    }
//
//    @Override
//    public List<SuspiciousCardTransfer> findAll() {
//        return suspiciousCardTransferRepository.findAll();
//    }
//
//    @Override
//    public SuspiciousCardTransfer update(SuspiciousCardTransfer suspiciousCardTransfer) {
//        SuspiciousCardTransfer updated = suspiciousCardTransferRepository.save(suspiciousCardTransfer);
//        auditService.save(new AuditDto(EntityType.SUSPICIOUS_CARD_TRANSFER, OperationType.UPDATE, updated.getId(),
//                suspiciousCardTransfer, updated));
//        return updated;
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        suspiciousCardTransferRepository.deleteById(id);
//        auditService.save(new AuditDto(EntityType.SUSPICIOUS_CARD_TRANSFER, OperationType.DELETE, id, null, null));
//    }
//}

package com.bank.antifraud.controller;

import com.bank.antifraud.dto.SuspiciousAccountTransferDTO;
import com.bank.antifraud.service.SuspiciousAccountTransferService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Контроллер для работы с переводами, помеченными как подозрительные
 * <p>
 * Содержит методы для получения, создания, обновления и удаления переводов
 * <p>
 * Обращение к контроллеру происходит по адресу /api/suspicious-account-transfers
 */
@RestController
@RequestMapping("/api/suspicious-account-transfers")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Validated
public class SuspiciousAccountTransferController {

    /**
     * Сервис для работы с переводами, помеченными как подозрительные
     */
    private final SuspiciousAccountTransferService suspiciousAccountTransferService;

    /**
     * Получить детали перевода по идентификатору
     *
     * @param id Идентификатор перевода
     * @return Объект ResponseEntity с кодом ответа и объектом SuspiciousAccountTransferDTO
     */
    @GetMapping("/{id}")
    @Operation(summary = "Получить детали перевода по идентификатору")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = SuspiciousAccountTransferDTO.class)))
    @ApiResponse(responseCode = "404", description = "Перевод не найден")
    public ResponseEntity<SuspiciousAccountTransferDTO> getById(@Valid @PathVariable Long id) {
        final SuspiciousAccountTransferDTO suspiciousAccountTransferDTO = suspiciousAccountTransferService.getById(id);
        return ResponseEntity.ok(suspiciousAccountTransferDTO);
    }

    /**
     * Получить все переводы
     *
     * @return Объект ResponseEntity с кодом ответа и списком объектов SuspiciousAccountTransferDTO
     */
    @GetMapping("/")
    @Operation(summary = "Получить все переводы")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = SuspiciousAccountTransferDTO.class)))
    public ResponseEntity<List<SuspiciousAccountTransferDTO>> getAll() {
        final List<SuspiciousAccountTransferDTO> suspiciousAccountTransferDTOList =
                suspiciousAccountTransferService.getAll();
        return ResponseEntity.ok(suspiciousAccountTransferDTOList);
    }

    /**
     * Создать новый перевод
     *
     * @param suspiciousAccountTransferDTO Объект DTO с данными нового перевода
     * @return Объект ResponseEntity с кодом ответа и объектом SuspiciousAccountTransferDTO, созданным в базе данных
     */
    @PostMapping("/")
    @Operation(summary = "Создать новый перевод")
    @ApiResponse(responseCode = "201", description = "Создано",
            content = @Content(schema = @Schema(implementation = SuspiciousAccountTransferDTO.class)))
    public ResponseEntity<SuspiciousAccountTransferDTO> create
    (@Valid @RequestBody SuspiciousAccountTransferDTO suspiciousAccountTransferDTO) {
        final SuspiciousAccountTransferDTO createdSuspiciousAccountTransferDTO =
                suspiciousAccountTransferService.save(suspiciousAccountTransferDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSuspiciousAccountTransferDTO);
    }

    /**
     * Обновить данные перевода
     *
     * @param suspiciousAccountTransferDTO Объект DTO с данными перевода, который нужно обновить
     * @return Объект ResponseEntity с кодом ответа и объектом SuspiciousAccountTransferDTO, обновленным в базе данных
     */
    @PutMapping("/")
    @Operation(summary = "Обновить данные перевода")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = SuspiciousAccountTransferDTO.class)))
    @ApiResponse(responseCode = "404", description = "Перевод не найден")

    public ResponseEntity<SuspiciousAccountTransferDTO> update
    (@Valid @RequestBody SuspiciousAccountTransferDTO suspiciousAccountTransferDTO) {
        final SuspiciousAccountTransferDTO updatedSuspiciousAccountTransferDTO =
                suspiciousAccountTransferService.update(suspiciousAccountTransferDTO);
        return ResponseEntity.ok(updatedSuspiciousAccountTransferDTO);
    }

    /**
     * Удалить перевод по идентификатору.
     *
     * @param id идентификатор перевода.
     * @return {@link ResponseEntity} с кодом 204 (Перевод успешно удален) в случае успешного удаления
     * или с кодом 404 (Перевод не найден), если перевод не был найден.
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить перевод по идентификатору")
    @ApiResponse(responseCode = "204", description = "Перевод успешно удален")
    @ApiResponse(responseCode = "404", description = "Перевод не найден")
    public ResponseEntity<Void> deleteById(@Valid @PathVariable Long id) {
        suspiciousAccountTransferService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

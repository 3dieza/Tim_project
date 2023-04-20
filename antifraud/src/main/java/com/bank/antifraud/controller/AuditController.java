package com.bank.antifraud.controller;

import com.bank.antifraud.dto.AuditDTO;
import com.bank.antifraud.service.AuditService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;
import java.util.List;

/**
 * Контроллер для работы с аудитами.
 */
@RestController
@RequestMapping("/audits")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Validated
public class AuditController {

    /**
     * Сервис для работы с аудитами.
     */
    private final AuditService auditService;

    /**
     * Получить детали аудита по идентификатору.
     *
     * @param id идентификатор аудита
     * @return объект ответа с деталями аудита или ошибкой 404, если аудит не найден
     */
    @GetMapping("/{id}")
    @Operation(summary = "Получить детали аудита по идентификатору")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = AuditDTO.class)))
    @ApiResponse(responseCode = "404", description = "Аудит не найден")
    public ResponseEntity<AuditDTO> getById(@Valid @PathVariable Long id) {
        final AuditDTO auditDTO = auditService.getById(id);
        return ResponseEntity.ok(auditDTO);
    }

    /**
     * Получить все аудиты.
     *
     * @return список всех аудитов
     */
    @GetMapping
    @Operation(summary = "Получить все аудиты")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = AuditDTO.class))))
    public ResponseEntity<List<AuditDTO>> getAll() {
        final List<AuditDTO> auditDTOList = auditService.getAll();
        return ResponseEntity.ok(auditDTOList);
    }

    /**
     * Создать новый аудит.
     *
     * @param auditDTO данные для создания нового аудита
     * @return объект ответа со статусом 201 и созданным аудитом
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Создать новый аудит")
    @ApiResponse(responseCode = "201", description = "Создан",
            content = @Content(schema = @Schema(implementation = AuditDTO.class)))
    public ResponseEntity<AuditDTO> create(@Valid @RequestBody AuditDTO auditDTO) {
        final AuditDTO createdAuditDTO = auditService.save(auditDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAuditDTO);
    }

    /**
     * Обновить данные аудита.
     *
     * @param auditDTO данные для обновления аудита
     * @return объект ответа с обновленными данными аудита или ошибкой 404, если аудит не найден
     */
    @PutMapping
    @Operation(summary = "Обновить данные аудита")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = AuditDTO.class)))
    public ResponseEntity<AuditDTO> update(@Valid @RequestBody AuditDTO auditDTO) {
        final AuditDTO updatedAuditDTO = auditService.update(auditDTO);
        return ResponseEntity.ok(updatedAuditDTO);
    }

    /**
     * Удалить аудит по идентификатору.
     *
     * @param id идентификатор аудита для удаления
     * @return объект ответа со статусом 204, если удаление прошло успешно
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить аудит по идентификатору")
    @ApiResponse(responseCode = "204", description = "Удалено")
    public ResponseEntity<Void> deleteById(@Valid @PathVariable Long id) {
        auditService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


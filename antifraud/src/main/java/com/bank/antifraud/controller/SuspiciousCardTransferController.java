package com.bank.antifraud.controller;

import com.bank.antifraud.dto.SuspiciousCardTransferDTO;
import com.bank.antifraud.service.SuspiciousCardTransferService;

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
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Контроллер для работы с подозрительными переводами карт.
 */
@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping("/api/suspicious-card-transfers")
@Validated
public class SuspiciousCardTransferController {

    /**
     * Сервис для работы с подозрительными переводами карт.
     */
    private final SuspiciousCardTransferService service;

    /**
     * Получение деталей перевода по идентификатору.
     *
     * @param id идентификатор перевода
     * @return объект ResponseEntity, содержащий информацию о переводе
     */
    @GetMapping("/{id}")
    @Operation(summary = "Получить детали перевода по идентификатору")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = SuspiciousCardTransferDTO.class)))
    @ApiResponse(responseCode = "404", description = "Перевод не найден")
    public ResponseEntity<SuspiciousCardTransferDTO> getById(@Valid @PathVariable Long id) {
        final SuspiciousCardTransferDTO transferDTO = service.getById(id);
        return ResponseEntity.ok(transferDTO);
    }

    /**
     * Получение списка всех переводов карты.
     *
     * @return объект ResponseEntity, содержащий список переводов
     */
    @GetMapping
    @Operation(summary = "Получить список всех переводов карты")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(array = @ArraySchema(schema =
            @Schema(implementation = SuspiciousCardTransferDTO.class))))
    public ResponseEntity<List<SuspiciousCardTransferDTO>> getAll() {
        final List<SuspiciousCardTransferDTO> transferDTOList = service.getAll();
        return ResponseEntity.ok(transferDTOList);
    }

    /**
     * Создание нового подозрительного перевода карты.
     *
     * @param dto объект, содержащий информацию о новом переводе
     * @return объект ResponseEntity, содержащий информацию о созданном переводе
     */
    @PostMapping("/")
    @Operation(summary = "Создать новый подозрительный перевод карты")
    @ApiResponse(responseCode = "201", description = "Перевод создан",
            content = @Content(schema = @Schema(implementation = SuspiciousCardTransferDTO.class)))
    public ResponseEntity<SuspiciousCardTransferDTO> create(@Valid @RequestBody SuspiciousCardTransferDTO dto) {
        final SuspiciousCardTransferDTO createdDTO = service.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDTO);
    }

    /**
     * Обновление информации о подозрительном переводе по идентификатору.
     *
     * @param id  идентификатор перевода, который нужно обновить
     * @param dto объект, содержащий информацию, которую нужно обновить
     * @return объект ResponseEntity, содержащий информацию об обновленном переводе
     */
    @PutMapping("/{id}")
    @Operation(summary = "Обновить информацию о подозрительном переводе по идентификатору")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = SuspiciousCardTransferDTO.class)))
    @ApiResponse(responseCode = "404", description = "Перевод не найден")
    public ResponseEntity<SuspiciousCardTransferDTO> update(@Valid @PathVariable Long id,
                                                            @RequestBody SuspiciousCardTransferDTO dto) {
        dto.setId(id);
        final SuspiciousCardTransferDTO updatedDTO = service.update(dto);

        return ResponseEntity.ok(updatedDTO);
    }

    /**
     * Удаляет сущность по идентификатору.
     *
     * @param id Идентификатор сущности.
     * @return Ответ с кодом 204 в случае успешного удаления сущности, иначе ответ с кодом 404.
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить сущность по идентификатору")
    @ApiResponse(responseCode = "204", description = "Сущность успешно удалена")
    @ApiResponse(responseCode = "404", description = "Сущность не найдена")
    public ResponseEntity<Void> deleteById(@Valid @PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

package com.bank.antifraud.controller;


import com.bank.antifraud.dto.SuspiciousPhoneTransferDTO;
import com.bank.antifraud.service.SuspiciousPhoneTransferService;

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
 * Контроллер для работы с подозрительными телефонными переводами.
 */
@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping("/suspicious-phone-transfers")
@Validated
public class SuspiciousPhoneTransferController {

    /**
     * Сервис для работы с подозрительными телефонными переводами.
     */
    private final SuspiciousPhoneTransferService service;

    /**
     * Получить детали перевода по идентификатору.
     *
     * @param id Идентификатор перевода.
     * @return Объект ResponseEntity со статусом 200 OK и деталями перевода в теле ответа, или статусом 404 NOT FOUND.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Получить детали перевода по идентификатору")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = SuspiciousPhoneTransferDTO.class)))
    @ApiResponse(responseCode = "404", description = "Перевод не найден")
    public ResponseEntity<SuspiciousPhoneTransferDTO> getById(@Valid @PathVariable Long id) {
        final SuspiciousPhoneTransferDTO suspiciousPhoneTransferDTO = service.getById(id);
        return ResponseEntity.ok(suspiciousPhoneTransferDTO);
    }

    /**
     * Получает все подозрительные переводы.
     *
     * @return объект ResponseEntity со списком всех подозрительных переводов и статусом ответа.
     */
    @GetMapping
    @Operation(summary = "Получить все подозрительные переводы")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(array = @ArraySchema(schema =
            @Schema(implementation = SuspiciousPhoneTransferDTO.class))))
    public ResponseEntity<List<SuspiciousPhoneTransferDTO>> getAll() {
        final List<SuspiciousPhoneTransferDTO> suspiciousPhoneTransferDTOList = service.getAll();
        return ResponseEntity.ok(suspiciousPhoneTransferDTOList);
    }

    /**
     * Создает новый подозрительный перевод.
     *
     * @param dto объект с данными подозрительного перевода.
     * @return объект ResponseEntity с созданным подозрительным переводом и статусом ответа 201.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Создать новый подозрительный перевод")
    @ApiResponse(responseCode = "201", description = "Подозрительный перевод создан",
            content = @Content(schema = @Schema(implementation = SuspiciousPhoneTransferDTO.class)))
    public ResponseEntity<SuspiciousPhoneTransferDTO> create(@Valid @RequestBody SuspiciousPhoneTransferDTO dto) {
        final SuspiciousPhoneTransferDTO createdDto = service.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDto);
    }

    /**
     * Обновить детали подозрительного перевода по идентификатору.
     *
     * @param dto Объект DTO с новыми данными о переводе.
     * @return Объект ResponseEntity со статусом 200 OK и обновленными деталями
     * перевода в теле ответа, или статусом 404 NOT FOUND.
     */
    @PutMapping
    @Operation(summary = "Обновить детали подозрительного перевода по идентификатору")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = SuspiciousPhoneTransferDTO.class)))
    @ApiResponse(responseCode = "404", description = "Перевод не найден")
    public ResponseEntity<SuspiciousPhoneTransferDTO> update(@Valid @RequestBody SuspiciousPhoneTransferDTO dto) {
        final SuspiciousPhoneTransferDTO updatedDTO = service.update(dto);
        return ResponseEntity.ok(updatedDTO);
    }

    /**
     * Удалить подозрительный перевод по идентификатору.
     *
     * @param id Идентификатор перевода.
     * @return Объект ResponseEntity со статусом 204 NO CONTENT.
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить подозрительный перевод по идентификатору")
    @ApiResponse(responseCode = "204", description = "Перевод удален")
    public ResponseEntity<Void> deleteById(@Valid @PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

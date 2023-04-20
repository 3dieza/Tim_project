package com.bank.antifraud.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * Класс AuditDTO представляет собой объект передачи данных для сущности Audit.
 * <p>
 * Содержит поля для представления атрибутов сущности Audit.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditDTO {

    /**
     * Представляет JSON-строку новой сущности, над которой было проведено действие.
     */
    @Nullable
    @Size(max = 1000, message = "Длина новой сущности не должна превышать 1000 символов")
    private String newEntityJson;

    /**
     * Представляет дату и время изменения аудита.
     */
    @Nullable
    private LocalDateTime modifiedAt;

    /**
     * Представляет имя пользователя, который внес изменения в аудит.
     */
    @Size(max = 255, message = "Длина имени пользователя не должна превышать 255 символов")
    @Nullable
    private String modifiedBy;

    /**
     * Представляет идентификатор аудита.
     */
    private Long id;

    /**
     * Представляет тип сущности, над которой было проведено действие.
     */
    @Size(max = 255, message = "Длина типа сущности не должна превышать 255 символов")
    private String entityType;

    /**
     * Представляет тип операции, проведенной над сущностью.
     */
    @Size(max = 255, message = "Длина типа операции не должна превышать 255 символов")
    private String operationType;

    /**
     * Представляет имя пользователя, который создал аудит.
     */
    @NotNull(message = "Имя пользователя не может быть null")
    @NotBlank(message = "Имя пользователя не может быть пустым")
    @Size(max = 255, message = "Длина имени пользователя не должна превышать 255 символов")
    private String createdBy;

    /**
     * Представляет дату и время создания аудита.
     */
//    @NotNull(message = "Дата и время создания аудита не могут быть пустыми")
    private LocalDateTime createdAt;

    /**
     * Представляет JSON-строку сущности, над которой было проведено действие.
     */
    @Size(max = 1000, message = "Длина сущности не должна превышать 1000 символов")
    private String entityJson;

}



/*DTO классы используются для передачи данных между клиентом и сервером в RESTful API.
DTO (Data Transfer Object) - это объект, который используется только для передачи данных
и не имеет логики приложения.
DTO объекты обычно содержат только те поля, которые нужны клиенту,
и не имеют лишних данных, что позволяет ускорить передачу данных.
 */


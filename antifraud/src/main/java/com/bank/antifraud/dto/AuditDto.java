package com.bank.antifraud.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder

public class AuditDto {
    private String newEntityJson;
    private LocalDateTime modifiedAt;
    private String modifiedBy;
    private Long id;
//    private String entityType;
//    private String operationType;
//    private String createdBy;
//    private LocalDateTime createdAt;
//    private String entityJson;

    // constructors, getters, setters
}

/*DTO классы используются для передачи данных между клиентом и сервером в RESTful API.
DTO (Data Transfer Object) - это объект, который используется только для передачи данных
и не имеет логики приложения.
DTO объекты обычно содержат только те поля, которые нужны клиенту,
и не имеют лишних данных, что позволяет ускорить передачу данных.
 */
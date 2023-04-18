package com.bank.antifraud.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AuditDTO {

    private String newEntityJson;

    private LocalDateTime modifiedAt;

    private String modifiedBy;
    private Long id;
    private String entityType;
    private String operationType;
    private String createdBy;
    private LocalDateTime createdAt;
    private String entityJson;

}



/*DTO классы используются для передачи данных между клиентом и сервером в RESTful API.
DTO (Data Transfer Object) - это объект, который используется только для передачи данных
и не имеет логики приложения.
DTO объекты обычно содержат только те поля, которые нужны клиенту,
и не имеют лишних данных, что позволяет ускорить передачу данных.
 */


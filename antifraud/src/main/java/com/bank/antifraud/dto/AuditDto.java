package com.bank.antifraud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AuditDto {
    private String newEntityJson;
    private LocalDateTime modifiedAt;
    private String modifiedBy;
    private Long id;
}



/*DTO классы используются для передачи данных между клиентом и сервером в RESTful API.
DTO (Data Transfer Object) - это объект, который используется только для передачи данных
и не имеет логики приложения.
DTO объекты обычно содержат только те поля, которые нужны клиенту,
и не имеют лишних данных, что позволяет ускорить передачу данных.
 */


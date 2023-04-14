package com.bank.antifraud.enitiy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "audit")
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entity_type")
    private String entityType;

    @Column(name = "operation_type")
    private String operationType;

    @Column(name = "created_by")
    private String createdBy;

    @NotNull
    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @NotNull
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;
    @NotNull
    @Column(name = "new_entity_json")
    private String newEntityJson;

    @Column(name = "entity_json")
    private String entityJson;

}


//Entity классы являются классами, которые отображают таблицы в базе данных.
//Каждая таблица в базе данных имеет соответствующий класс-сущность в вашем приложении.
//Это позволяет работать с данными, хранимыми в базе данных, как с обычными объектами в Java.




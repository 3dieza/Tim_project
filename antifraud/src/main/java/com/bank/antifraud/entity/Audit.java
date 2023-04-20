package com.bank.antifraud.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;


/**
 * Сущность аудита
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "audit", schema = "anti_fraud")
public class Audit {
    /* Идентификатор аудита */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Тип сущности
     */
    @Column(name = "entity_type")
    private String entityType;

    /**
     * Тип операции
     */
    @Column(name = "operation_type")
    private String operationType;

    /**
     * Создатель
     */
    @Column(name = "created_by")
    private String createdBy;

    /**
     * Модификатор
     */
    @Column(name = "modified_by")
    private String modifiedBy;

    /**
     * Время создания
     */
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    /**
     * Время изменения
     */
    @UpdateTimestamp
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    /**
     * Json новой сущности
     */
    @Column(name = "new_entity_json")
    private String newEntityJson;

    /**
     * Json сущности
     */
    @Column(name = "entity_json")
    private String entityJson;
}


//Entity классы являются классами, которые отображают таблицы в базе данных.
//Каждая таблица в базе данных имеет соответствующий класс-сущность в вашем приложении.
//Это позволяет работать с данными, хранимыми в базе данных, как с обычными объектами в Java.


package com.bank.antifraud.validator;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;

/**

 Класс конфигурации валидатора. Создает и возвращает объект валидатора.
 */
@Configuration
public class ValidatorConfig {

    /**

     Метод, создающий объект валидатора.
     @return объект валидатора типа Validator.
     */
    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }
}

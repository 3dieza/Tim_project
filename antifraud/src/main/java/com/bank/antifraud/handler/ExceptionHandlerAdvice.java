package com.bank.antifraud.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    // Ключи, которые будут использоваться для создания тела ответа с ошибкой
    private static final String TIMESTAMP = "timestamp";
    private static final String STATUS = "status";
    private static final String ERROR = "error";
    private static final String MESSAGE = "message";

    /**
     * Обработчик исключения BadRequestException.
     *
     * @param ex Исключение BadRequestException
     * @return ResponseEntity с телом ответа, содержащим информацию об ошибке
     */
    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<Object> handleBadRequestException(final BadRequestException ex) {
        // Создаем тело ответа с ошибкой
        final Map<String, Object> body = new LinkedHashMap<>();
        // Добавляем метку времени в тело ответа
        body.put(TIMESTAMP, LocalDateTime.now());
        // Добавляем код статуса HTTP 400 Bad Request в тело ответа
        body.put(STATUS, HttpStatus.BAD_REQUEST.value());
        // Добавляем описание статуса HTTP 400 Bad Request в тело ответа
        body.put(ERROR, HttpStatus.BAD_REQUEST.getReasonPhrase());
        // Добавляем сообщение об ошибке в тело ответа
        body.put(MESSAGE, ex.getMessage());
        // Возвращаем ResponseEntity с телом ответа с ошибкой и кодом статуса HTTP 400 Bad Request
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    /**
     * Обработчик исключения NotFoundException.
     *
     * @param ex Исключение NotFoundException
     * @return ResponseEntity с телом ответа, содержащим информацию об ошибке
     */
    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(final NotFoundException ex) {
        // Создаем тело ответа с ошибкой
        final Map<String, Object> body = new LinkedHashMap<>();
        // Добавляем метку времени в тело ответа
        body.put(TIMESTAMP, LocalDateTime.now());
        // Добавляем код статуса HTTP 404 Not Found в тело ответа
        body.put(STATUS, HttpStatus.NOT_FOUND.value());
        // Добавляем описание статуса HTTP 404 Not Found в тело ответа
        body.put(ERROR, HttpStatus.NOT_FOUND.getReasonPhrase());
        // Добавляем сообщение об ошибке в тело ответа
        body.put(MESSAGE, ex.getMessage());
        // Возвращаем ResponseEntity с телом ответа с ошибкой и кодом статуса HTTP 404 Not Found
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

}

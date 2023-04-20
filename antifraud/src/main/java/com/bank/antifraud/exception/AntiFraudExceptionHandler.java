package com.bank.antifraud.exception;

/**
 * Класс AntiFraudExceptionHandler отвечает за обработку различных исключений,
 * <p>
 * возникающих в приложении, например, при некорректном запросе от пользователя
 * <p>
 * или при ошибке в базе данных
 */
public class AntiFraudExceptionHandler {

    /**
     * Класс AntifraudException является базовым классом для всех исключений,
     * <p>
     * связанных с анти-фрод защитой
     */
    public class AntifraudException extends RuntimeException {

        /**
         * Конструктор класса AntifraudException
         *
         * @param message сообщение об ошибке
         */
        public AntifraudException(String message) {
            super(message);
        }

        /**
         * Конструктор класса AntifraudException
         *
         * @param message сообщение об ошибке
         * @param cause   причина исключения
         */
        public AntifraudException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    /**
     * Класс CardTransferNotFoundException отвечает за обработку исключений,
     * <p>
     * возникающих при отсутствии перевода между картами
     */
    public class CardTransferNotFoundException extends AntifraudException {

        /**
         * Конструктор класса CardTransferNotFoundException
         *
         * @param id идентификатор перевода между картами
         */
        public CardTransferNotFoundException(Long id) {
            super(String.format("Перевод между картами с идентификатором %d не найден", id));
        }
    }

    /**
     * Класс AccountTransferNotFoundException отвечает за обработку исключений,
     * <p>
     * возникающих при отсутствии перевода между счетами
     */
    public class AccountTransferNotFoundException extends AntifraudException {

        /**
         * Конструктор класса AccountTransferNotFoundException
         *
         * @param id идентификатор перевода между счетами
         */
        public AccountTransferNotFoundException(Long id) {
            super(String.format("Перевод между счетами с идентификатором %d не найден", id));
        }
    }

    /**
     * Класс PhoneTransferNotFoundException отвечает за обработку исключений,
     * <p>
     * возникающих при отсутствии перевода по номеру телефона
     */
    public class PhoneTransferNotFoundException extends AntifraudException {

        /**
         * Конструктор класса PhoneTransferNotFoundException
         *
         * @param id идентификатор перевода по номеру телефона
         */
        public PhoneTransferNotFoundException(Long id) {
            super(String.format("Перевод по номеру телефона с идентификатором %d не найден", id));
        }
    }

    /**
     * Исключение "Аудит не найден".
     */
    public class AuditNotFoundException extends AntifraudException {

        /**
         * Конструктор исключения.
         *
         * @param id идентификатор аудита.
         */
        public AuditNotFoundException(Long id) {
            super(String.format("Аудит с идентификатором %d не найден", id));
        }
    }

    /**
     * Исключение "Перевод заблокирован".
     */
    public class TransferBlockedException extends AntifraudException {

        /**
         * Конструктор исключения.
         *
         * @param reason причина блокировки перевода.
         */
        public TransferBlockedException(String reason) {
            super(String.format("Перевод заблокирован. Причина: %s", reason));
        }
    }

    /**
     * Исключение "Перевод подозрительный".
     */
    public class TransferSuspiciousException extends AntifraudException {

        /**
         * Конструктор исключения.
         *
         * @param reason причина подозрительности перевода.
         */
        public TransferSuspiciousException(String reason) {
            super(String.format("Перевод подозрительный. Причина: %s", reason));
        }
    }
}


package ru.task.clickerapplication.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.ConnectException;

    @Slf4j
    @ControllerAdvice
    public class ExceptionHandlerController {
        private static final String MESSAGE_CANNOT_CREATE_TRANSACTION_EXCEPTION = "Ошибка создания транзакции";
        private static final String MESSAGE_CONNECT_EXCEPTION = "Ошибка доступа к целевой подсистеме";
        private static final String MESSAGE_EXCEPTION = "Неизвестная внутренняя ошибка";

        @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = MESSAGE_CANNOT_CREATE_TRANSACTION_EXCEPTION)
        @ExceptionHandler(value = CannotCreateTransactionException.class)
        public void handleCannotCreateTransactionException(CannotCreateTransactionException ex) {
            log.warn(MESSAGE_CANNOT_CREATE_TRANSACTION_EXCEPTION, ex);
        }

        @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = MESSAGE_CONNECT_EXCEPTION)
        @ExceptionHandler(value = ConnectException.class)
        public void handleConnectException(ConnectException ex) {
            log.warn(MESSAGE_CONNECT_EXCEPTION, ex);
        }

        @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = MESSAGE_EXCEPTION)
        @ExceptionHandler(value = Exception.class)
        public void handleAnyException(Exception ex) {
            log.error(MESSAGE_EXCEPTION, ex);
        }
}

package com.samuelm.desafioitau.exceptions.handler;

import com.samuelm.desafioitau.exceptions.DataHoraFuturoException;
import com.samuelm.desafioitau.exceptions.FormularioInvalidoException;
import com.samuelm.desafioitau.exceptions.ValorNegativoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FormularioInvalidoException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public void formularioInvalidoException(){}

    @ExceptionHandler(DataHoraFuturoException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public void dataHoraFuturoException(){}

    @ExceptionHandler(ValorNegativoException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public void valorNegativoException(){}

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void httpMessageNotReadableException(){}
}

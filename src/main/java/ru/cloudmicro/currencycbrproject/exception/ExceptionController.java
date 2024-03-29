package ru.cloudmicro.currencycbrproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler({CurrencyRateNotFoundException.class})
    public ResponseEntity<ErrorDto> handleNotFound(Exception ex) {
        return new ResponseEntity<>(new ErrorDto(ex.getLocalizedMessage()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({CurrencyRateParsingException.class})
    public ResponseEntity<ErrorDto> handleExceptionFromPriceService(Exception ex) {
        return new ResponseEntity<>(new ErrorDto(ex.getLocalizedMessage()),
                HttpStatus.BAD_REQUEST);
    }
}

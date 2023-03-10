package com.aurora.ekurban.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * kullanıcının bulunamaması durumunda hata fırlatmak için Advice sınıfı
 * @author mehmetercan
 */
@ControllerAdvice
public class NotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String userNotFoundException(UserNotFoundException ex) {
        return ex.getMessage();
    }
}

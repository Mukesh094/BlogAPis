package com.blog.blogger.exception;

import com.blog.blogger.dto_Or_Payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice  //Any Exception that occurs in controllerLayer it will advise to supress that
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> resourceNotFoundException(
    ResourceNotFoundException exception,
    WebRequest webrequest

    ){
      ErrorDetails errorDetails = new ErrorDetails(new Date(),exception.getMessage(),webrequest.getDescription(true));
      return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);

    }
// how to handle exception in springboot
    //;-> I will create one customException class that extends Runtime exception
    //;->I will create a controllerAdvise Class and in that i will develop ExceptionHnadler method which has annotation @ControllerAdvise
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(
            Exception exception,
            WebRequest webrequest

    ){
        ErrorDetails errorDetails = new ErrorDetails(new Date(),exception.getMessage(),webrequest.getDescription(true));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);

    }


}

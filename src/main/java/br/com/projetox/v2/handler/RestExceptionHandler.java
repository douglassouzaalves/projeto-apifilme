package br.com.projetox.v2.handler;

import br.com.projetox.v2.error.ResourceNotFoundDetails;
import br.com.projetox.v2.error.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler extends Throwable {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rfnException) {
        var rnfDetais = ResourceNotFoundDetails.ResourceNotFoundDetailsBuilder.newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Resource not found")
                .detail(rfnException.getMessage())
                .developerMessage(rfnException.getClass().getName())
                .build();
        return new ResponseEntity<>(rnfDetais, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<?> handleResourceBadRequest(NumberFormatException numberFormatException) {
        var rnfDetais = ResourceNotFoundDetails.ResourceNotFoundDetailsBuilder.newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("just enter numbers\n")
                .detail(numberFormatException.getMessage())
                .developerMessage(numberFormatException.getClass().getName())
                .build();
        return new ResponseEntity<>(rnfDetais, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<?> handleResourceNotFoundException(RuntimeException runtimeException) {
//        var rnfDetais = ResourceNotFoundDetails.ResourceNotFoundDetailsBuilder.newBuilder()
//                .timestamp(new Date().getTime())
//                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
//                .title("Resource not found")
//                .detail(runtimeException.getMessage())
//                .developerMessage(runtimeException.getClass().getName())
//                .build();
//        return new ResponseEntity<>(rnfDetais, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}


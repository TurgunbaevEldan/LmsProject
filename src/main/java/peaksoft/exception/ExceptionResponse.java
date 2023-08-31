package peaksoft.exception;

import org.springframework.http.HttpStatus;

public record ExceptionResponse (HttpStatus httpStatus,String exceptionClassName,String message){
}

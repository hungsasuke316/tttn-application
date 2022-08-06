package ptit.example.tttnapplication.exceptions.handlers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ptit.example.tttnapplication.dto.response.ErrorResponse;
import ptit.example.tttnapplication.exceptions.ResourceNotAcceptException;
import ptit.example.tttnapplication.exceptions.ResourceNotFoundException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionsHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ ResourceNotFoundException.class })
    protected ResponseEntity<ErrorResponse> handleCategoryNotFoundException(RuntimeException exception, WebRequest request) {
        ErrorResponse error = new ErrorResponse("404", exception.getMessage());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ ResourceNotAcceptException.class })
    protected ResponseEntity<ErrorResponse> handleCategoryNotAcceptException(RuntimeException exception, WebRequest request) {
        ErrorResponse error = new ErrorResponse("406", exception.getMessage());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler({ IllegalArgumentException.class })
    protected ResponseEntity<ErrorResponse> handleIllegalArgumentException(RuntimeException exception,
                                                                           WebRequest request) {
        ErrorResponse error = new ErrorResponse("400", exception.getMessage());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        ErrorResponse error = new ErrorResponse("400", "Validation Error", errors);
        return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
    }
}

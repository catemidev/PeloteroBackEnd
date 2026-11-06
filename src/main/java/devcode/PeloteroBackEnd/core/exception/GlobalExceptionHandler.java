package devcode.PeloteroBackEnd.core.exception;

import devcode.PeloteroBackEnd.dto.response.ErrorResponseDTO;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public ErrorResponseDTO handleNotFound(ResourceNotFoundException exception){
        return new ErrorResponseDTO(404, exception.getMessage());
    }
}

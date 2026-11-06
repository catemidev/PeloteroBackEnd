package devcode.PeloteroBackEnd.dto.response;

import java.time.LocalDateTime;

public record ErrorResponseDTO(
        int status,
        String message,
        String timestamp
) {
    public ErrorResponseDTO(int status, String message)
    { this(status, message, LocalDateTime.now().toString());}
}

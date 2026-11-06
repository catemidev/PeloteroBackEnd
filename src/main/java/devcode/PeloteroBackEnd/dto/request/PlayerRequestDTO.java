package devcode.PeloteroBackEnd.dto.request;

import jakarta.persistence.Column;

public record PlayerRequestDTO(
        String name,
        String nickName,
        Integer level,
        String urlPhoto
) {
}

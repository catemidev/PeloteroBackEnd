package devcode.PeloteroBackEnd.dto.response;

import jakarta.persistence.Column;

public record TeamResponseDTO (
        long id,
        String name,
        String distric,
        String department,
        String pais
){

}

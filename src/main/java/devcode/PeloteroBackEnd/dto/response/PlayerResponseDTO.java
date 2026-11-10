package devcode.PeloteroBackEnd.dto.response;

public record PlayerResponseDTO(
        Long id,
        String name,
        String nickName,
        Integer level,
        String urlPhoto,
        String teamName
) {
}

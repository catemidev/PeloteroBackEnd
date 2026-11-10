package devcode.PeloteroBackEnd.dto.request;

public record PlayerRequestDTO(
        String name,
        String nickName,
        Integer level,
        String urlPhoto,
        Long teamId
) {
}

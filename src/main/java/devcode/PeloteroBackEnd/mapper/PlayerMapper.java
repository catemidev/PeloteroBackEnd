package devcode.PeloteroBackEnd.mapper;

import devcode.PeloteroBackEnd.domain.entity.PlayerEntity;
import devcode.PeloteroBackEnd.dto.request.PlayerRequestDTO;
import devcode.PeloteroBackEnd.dto.response.PlayerResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {

    public PlayerMapper() {
        throw new UnsupportedOperationException("Esta clase no debe ser instanciada.");
    }

    public static PlayerEntity toEntity(PlayerEntity player, PlayerRequestDTO requestDTO){

        if (requestDTO == null) return null;

        player.setName(requestDTO.name());
        player.setNickName(requestDTO.nickName());
        player.setLevel(requestDTO.level());
        player.setUrlPhoto(requestDTO.urlPhoto());

        return player;

    }

    public static PlayerResponseDTO toResponse(PlayerEntity player){

        if (player == null) return null;

        return new PlayerResponseDTO(
                player.getId(),
                player.getName(),
                player.getNickName(),
                player.getLevel(),
                player.getUrlPhoto()
        );

    }
}

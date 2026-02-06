package devcode.PeloteroBackEnd.mapper;

import devcode.PeloteroBackEnd.domain.entity.PlayerEntity;
import devcode.PeloteroBackEnd.dto.response.PlayerResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {
//    Averiguar en un futuro como activar esta parte
//    public PlayerMapper() {
//        throw new UnsupportedOperationException("Esta clase no debe ser instanciada.");
//    }
    public static PlayerResponseDTO toResponseDTO(PlayerEntity playerEntity){
        if(playerEntity == null) return null;
        return new PlayerResponseDTO(
                playerEntity.getName(),
                playerEntity.getNickName(),
                playerEntity.getLevel()
                );
    }
}

package devcode.PeloteroBackEnd.mapper;

import devcode.PeloteroBackEnd.domain.entity.PlayerEntity;
import devcode.PeloteroBackEnd.dto.response.PlayerResponseDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlayerMapper {

    private final ModelMapper modelMapper;

    public PlayerResponseDTO toResponseDTO(PlayerEntity playerEntity){
        return modelMapper.map(playerEntity, PlayerResponseDTO.class);
    }

}

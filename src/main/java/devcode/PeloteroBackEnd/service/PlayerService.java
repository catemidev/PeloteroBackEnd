package devcode.PeloteroBackEnd.service;

import devcode.PeloteroBackEnd.domain.entity.PlayerEntity;
import devcode.PeloteroBackEnd.dto.response.PlayerResponseDTO;
import devcode.PeloteroBackEnd.mapper.PlayerMapper;
import devcode.PeloteroBackEnd.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    public PlayerResponseDTO findById(Long id){
        PlayerEntity playerEntity = playerRepository.findById(id).get();
        return playerMapper.toResponseDTO(playerEntity);
    }


}

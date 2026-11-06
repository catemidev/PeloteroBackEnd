package devcode.PeloteroBackEnd.service;

import devcode.PeloteroBackEnd.core.exception.ResourceNotFoundException;
import devcode.PeloteroBackEnd.domain.entity.PlayerEntity;
import devcode.PeloteroBackEnd.dto.request.PlayerRequestDTO;
import devcode.PeloteroBackEnd.dto.response.PlayerResponseDTO;
import devcode.PeloteroBackEnd.mapper.PlayerMapper;
import devcode.PeloteroBackEnd.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    // &&&&&&& ################ CREATE ################ &&&&&&&
    @Transactional
    public PlayerResponseDTO createPlayer(PlayerRequestDTO requestDTO, MultipartFile photo){
        final PlayerEntity createPlayer = PlayerMapper.toEntity(new PlayerEntity(), requestDTO);
        final PlayerEntity newPlayer = playerRepository.save(createPlayer);

        return PlayerMapper.toResponse(newPlayer);
    }

    // &&&&&&& ################ READ ################ &&&&&&&
    @Transactional(readOnly = true)
    public PlayerResponseDTO findById(Long id){
        PlayerEntity playerEntity = playerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el jugador con id: "+id));

        return PlayerMapper.toResponse(playerEntity);
    }

    // &&&&&&& ################ UPDATE ################ &&&&&&&
    @Transactional
    public PlayerResponseDTO updatePlayer(Long id, PlayerRequestDTO requestDTO, MultipartFile photo){
        PlayerEntity teamEntity = playerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el jugador con id: "+id));

        final PlayerEntity updatePlayer = PlayerMapper.toEntity(teamEntity, requestDTO);
        final PlayerEntity newPlayer = playerRepository.save(updatePlayer);

        return PlayerMapper.toResponse(newPlayer);
    }

    // &&&&&&& ################ DELETE ################ &&&&&&&
    public void deleteById(Long id){
        if (playerRepository.existsById(id)){
            playerRepository.deleteById(id);
        } else {
            throw new RuntimeException("No se encontro el jugador con id: "+id);
        }
    }

}

package devcode.PeloteroBackEnd.service;

import devcode.PeloteroBackEnd.core.exception.ResourceNotFoundException;
import devcode.PeloteroBackEnd.domain.entity.GameEntity;
import devcode.PeloteroBackEnd.dto.request.GameRequestDTO;
import devcode.PeloteroBackEnd.dto.response.GameResponseDTO;
import devcode.PeloteroBackEnd.mapper.GameMapper;
import devcode.PeloteroBackEnd.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    // &&&&&&& ################ CREATE ################ &&&&&&&
    @Transactional
    public GameResponseDTO createGame(GameRequestDTO requestDTO){
        final GameEntity createGame = GameMapper.toEntity(new GameEntity(), requestDTO);
        final GameEntity newGame = gameRepository.save(createGame);

        return GameMapper.toResponse(newGame);
    }

    // &&&&&&& ################ READ ################ &&&&&&&
    @Transactional(readOnly = true)
    public GameResponseDTO findById(Long id){
        GameEntity gameEntity = gameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el juego con id: "+id));

        return GameMapper.toResponse(gameEntity);
    }

    // &&&&&&& ################ UPDATE ################ &&&&&&&
    @Transactional
    public GameResponseDTO updateGame(Long id, GameRequestDTO requestDTO){
        GameEntity gameEntity = gameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el juego con id: "+id));

        final GameEntity updateGame = GameMapper.toEntity(gameEntity, requestDTO);
        final GameEntity newGame = gameRepository.save(updateGame);

        return GameMapper.toResponse(newGame);
    }

    // &&&&&&& ################ DELETE ################ &&&&&&&
    public void deleteById(Long id){
        if (gameRepository.existsById(id)){
            gameRepository.deleteById(id);
        } else {
            throw new RuntimeException("No se encontro el juego con id: "+id);
        }
    }

}

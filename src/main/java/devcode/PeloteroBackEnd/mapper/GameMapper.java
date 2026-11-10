package devcode.PeloteroBackEnd.mapper;

import devcode.PeloteroBackEnd.domain.entity.GameEntity;
import devcode.PeloteroBackEnd.domain.entity.TeamEntity;
import devcode.PeloteroBackEnd.dto.request.GameRequestDTO;
import devcode.PeloteroBackEnd.dto.response.GameResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class GameMapper {

    public GameMapper() {
        throw new UnsupportedOperationException("Esta clase no debe ser instanciada.");
    }

    public static GameEntity toEntity(GameEntity game, GameRequestDTO requestDTO){

        if (requestDTO == null) return null;

        game.setDatePlayer(requestDTO.datePlayer());
        game.setPlayers(requestDTO.players());
        game.setMoneyRaised(requestDTO.moneyRaised());

        if (requestDTO.teamId() != null){
            TeamEntity team = new TeamEntity();
            team.setId(requestDTO.teamId());
            game.setTeam(team);
        }

        return game;

    }

    public static GameResponseDTO toResponse(GameEntity game){

        if (game == null) return null;

        return new GameResponseDTO(
                game.getId(),
                game.getDatePlayer(),
                game.getPlayers(),
                game.getMoneyRaised(),
                game.getTeam().getName()
        );

    }
}

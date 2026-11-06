package devcode.PeloteroBackEnd.mapper;

import devcode.PeloteroBackEnd.domain.entity.TeamEntity;
import devcode.PeloteroBackEnd.dto.request.TeamRequestDTO;
import devcode.PeloteroBackEnd.dto.response.TeamResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class TeamMapper {

    public static TeamEntity toEntity(TeamEntity team, TeamRequestDTO requestDTO){

        if (requestDTO == null) return null;

        team.setName(requestDTO.name());
        team.setDistric(requestDTO.distric());
        team.setDepartment(requestDTO.department());
        team.setPais(requestDTO.pais());

        return team;

    }

    public static TeamResponseDTO toResponse(TeamEntity team){

        if (team == null) return null;

        return new TeamResponseDTO(
                team.getId(),
                team.getName(),
                team.getDistric(),
                team.getDepartment(),
                team.getPais()
        );

    }
}

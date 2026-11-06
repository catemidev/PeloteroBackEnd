package devcode.PeloteroBackEnd.service;

import devcode.PeloteroBackEnd.core.exception.ResourceNotFoundException;
import devcode.PeloteroBackEnd.domain.entity.TeamEntity;
import devcode.PeloteroBackEnd.dto.request.TeamRequestDTO;
import devcode.PeloteroBackEnd.dto.response.TeamResponseDTO;
import devcode.PeloteroBackEnd.mapper.TeamMapper;
import devcode.PeloteroBackEnd.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    // &&&&&&& ################ CREATE ################ &&&&&&&
    @Transactional
    public TeamResponseDTO createTeam(TeamRequestDTO requestDTO){
        final TeamEntity createTeam = TeamMapper.toEntity(new TeamEntity(), requestDTO);
        final TeamEntity newTeam = teamRepository.save(createTeam);

        return TeamMapper.toResponse(newTeam);
    }

    // &&&&&&& ################ READ ################ &&&&&&&
    @Transactional(readOnly = true)
    public TeamResponseDTO findById(Long id){
        TeamEntity teamEntity = teamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el equipo con id: "+id));

        return TeamMapper.toResponse(teamEntity);
    }

    // &&&&&&& ################ UPDATE ################ &&&&&&&
    @Transactional
    public TeamResponseDTO updateTeam(Long id, TeamRequestDTO requestDTO){
        TeamEntity teamEntity = teamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el equipo con id: "+id));

        final TeamEntity updateTeam = TeamMapper.toEntity(teamEntity, requestDTO);
        final TeamEntity newTeam = teamRepository.save(updateTeam);

        return TeamMapper.toResponse(newTeam);
    }

    // &&&&&&& ################ DELETE ################ &&&&&&&
    public void deleteById(Long id){
        if (teamRepository.existsById(id)){
            teamRepository.deleteById(id);
        } else {
            throw new RuntimeException("No se encontro el equipo con id: "+id);
        }
    }
}

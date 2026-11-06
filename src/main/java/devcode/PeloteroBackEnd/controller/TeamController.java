package devcode.PeloteroBackEnd.controller;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import devcode.PeloteroBackEnd.dto.request.TeamRequestDTO;
import devcode.PeloteroBackEnd.dto.response.TeamResponseDTO;
import devcode.PeloteroBackEnd.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/team")
public class TeamController {

    private final TeamService teamService;

    // &&&&&&& ################ CREATE ################ &&&&&&&
    @PostMapping
    private ResponseEntity<TeamResponseDTO> createTeam(
            @RequestBody TeamRequestDTO requestDTO){

        TeamResponseDTO teamResponse = teamService.createTeam(requestDTO);
        return new ResponseEntity<>(teamResponse, HttpStatus.CREATED);
    }

    // &&&&&&& ################ READ ################ &&&&&&&
    @GetMapping("/{id}")
    private ResponseEntity<TeamResponseDTO> findById(@PathVariable Long id){

        TeamResponseDTO teamResponseDTO = teamService.findById(id);
        return ResponseEntity.ok(teamResponseDTO);
    }

    // &&&&&&& ################ UPDATE ################ &&&&&&&
    @PutMapping("/{id}")
    private ResponseEntity<TeamResponseDTO> updateTeam(
            @PathVariable Long id,
            @RequestBody TeamRequestDTO requestDTO ){

        TeamResponseDTO teamResponseDTO = teamService.updateTeam(id, requestDTO);
        return ResponseEntity.ok(teamResponseDTO);
    }

    // &&&&&&& ################ DELETE ################ &&&&&&&
    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteTeam(@PathVariable Long id){

        try {
            teamService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }
}

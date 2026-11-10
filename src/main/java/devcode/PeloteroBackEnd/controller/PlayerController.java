package devcode.PeloteroBackEnd.controller;

import devcode.PeloteroBackEnd.dto.request.PlayerRequestDTO;
import devcode.PeloteroBackEnd.dto.request.TeamRequestDTO;
import devcode.PeloteroBackEnd.dto.response.PlayerResponseDTO;
import devcode.PeloteroBackEnd.dto.response.TeamResponseDTO;
import devcode.PeloteroBackEnd.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    // &&&&&&& ################ CREATE ################ &&&&&&&
    @PostMapping
    private ResponseEntity<PlayerResponseDTO> createPlayer(
            @RequestPart(value = "data") PlayerRequestDTO requestDTO,
            @RequestPart(value = "photo") MultipartFile photo){

        PlayerResponseDTO playerResponse = playerService.createPlayer(requestDTO, photo);
        return new ResponseEntity<>(playerResponse, HttpStatus.CREATED);
    }

    // &&&&&&& ################ READ ################ &&&&&&&
    @GetMapping("/{id}")
    private ResponseEntity<PlayerResponseDTO> findById(@PathVariable Long id){

        PlayerResponseDTO playerResponse = playerService.findById(id);
        return ResponseEntity.ok(playerResponse);
    }

    // &&&&&&& ################ UPDATE ################ &&&&&&&
    @PutMapping("/{id}")
    private ResponseEntity<PlayerResponseDTO> updateTeam(
            @PathVariable Long id,
            @RequestPart(value = "data") PlayerRequestDTO requestDTO,
            @RequestPart(value = "photo") MultipartFile photo){

        PlayerResponseDTO playerResponse = playerService.updatePlayer(id, requestDTO, photo);
        return ResponseEntity.ok(playerResponse);
    }

    // &&&&&&& ################ DELETE ################ &&&&&&&
    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteTeam(@PathVariable Long id){

        try {
            playerService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }
}

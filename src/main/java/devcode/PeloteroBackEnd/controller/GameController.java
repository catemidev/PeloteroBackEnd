package devcode.PeloteroBackEnd.controller;

import devcode.PeloteroBackEnd.dto.request.GameRequestDTO;
import devcode.PeloteroBackEnd.dto.response.GameResponseDTO;
import devcode.PeloteroBackEnd.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;

    // &&&&&&& ################ CREATE ################ &&&&&&&
    @PostMapping
    private ResponseEntity<GameResponseDTO> createGame(
            @RequestPart(value = "data") GameRequestDTO requestDTO){

        GameResponseDTO gameResponse = gameService.createGame(requestDTO);
        return new ResponseEntity<>(gameResponse, HttpStatus.CREATED);
    }

    // &&&&&&& ################ READ ################ &&&&&&&
    @GetMapping("/{id}")
    private ResponseEntity<GameResponseDTO> findById(@PathVariable Long id){

        GameResponseDTO gameResponse = gameService.findById(id);
        return ResponseEntity.ok(gameResponse);
    }

    // &&&&&&& ################ UPDATE ################ &&&&&&&
    @PutMapping("/{id}")
    private ResponseEntity<GameResponseDTO> updateGame(
            @PathVariable Long id,
            @RequestPart(value = "data") GameRequestDTO requestDTO){

        GameResponseDTO gameResponse = gameService.updateGame(id, requestDTO);
        return ResponseEntity.ok(gameResponse);
    }

    // &&&&&&& ################ DELETE ################ &&&&&&&
    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteGame(@PathVariable Long id){

        try {
            gameService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }

}

package devcode.PeloteroBackEnd.controller;

import devcode.PeloteroBackEnd.dto.response.PlayerResponseDTO;
import devcode.PeloteroBackEnd.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping("/{id}")
    public ResponseEntity<PlayerResponseDTO> findById(@PathVariable Long id){
        PlayerResponseDTO player = playerService.findById(id);
        return ResponseEntity.ok(player);
    }


}

package devcode.PeloteroBackEnd.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public record GameResponseDTO(
        Long id,
        LocalDateTime datePlayer,
        List<Integer> players,
        Integer moneyRaised,
        String teamName
) {
}

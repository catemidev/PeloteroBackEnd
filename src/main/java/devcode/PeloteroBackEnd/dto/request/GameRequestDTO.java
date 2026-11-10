package devcode.PeloteroBackEnd.dto.request;

import java.time.LocalDateTime;
import java.util.List;

public record GameRequestDTO (
        LocalDateTime datePlayer,
        List<Integer> players,
        Integer moneyRaised,
        Long teamId
){
}

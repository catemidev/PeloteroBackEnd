package devcode.PeloteroBackEnd.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // <--- Esto genera el constructor que te falta
@AllArgsConstructor
public class PlayerResponseDTO {
    private String name;
    private String nickName;
    private Integer level;
}
//public record PlayerResponseDTO(
//        String name,
//        String nickName,
//        Integer level
//) {
//    public PlayerResponseDTO() {
//        this(null, null, null);
//    }
//}

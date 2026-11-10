package devcode.PeloteroBackEnd.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "games")
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "date_player")
    private LocalDateTime datePlayer;

    @Column(nullable = false)
    private List<Integer> players;

    @Column(name = "money_raised")
    private Integer moneyRaised;

    // A nivel de clases lo siguiente son asociaciones
    // Tenemos referencia a otra clase
    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    private TeamEntity team;

}

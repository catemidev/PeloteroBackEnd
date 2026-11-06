package devcode.PeloteroBackEnd.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "players")
public class PlayerEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "nick_name")
    private String nickName;
    private Integer level;
    private String urlPhoto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_PLAYER_TEAM"))
    private TeamEntity team;

//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
}

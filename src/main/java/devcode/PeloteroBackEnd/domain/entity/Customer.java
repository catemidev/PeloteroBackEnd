package devcode.PeloteroBackEnd.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// con la anotacion @Data generas los set y get de los atributos
// con @NoArgsConstructor generas un constructor sin argumentos
@Data
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(name = "plan_subscription")
    private String planSubscription;
    @Column(name = "register_date")
    private LocalDateTime registerDate;
}

package devcode.PeloteroBackEnd.domain.entity;

//import codedevfre.com.pelotero.domain.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="first_name", nullable = false)
    private String firstName;
    @Column(name="last_name", nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String email;
    private String password;

//    @Enumerated(EnumType.STRING)
//    private Role role; // "admin, editor, lector"

//    @ManyToOne
//    @JoinColumn(name = "customer_id", nullable = false)
//    private Customer customer;
}

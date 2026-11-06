package devcode.PeloteroBackEnd.repository;

import devcode.PeloteroBackEnd.domain.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
}

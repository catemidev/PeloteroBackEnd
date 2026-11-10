package devcode.PeloteroBackEnd.repository;

import devcode.PeloteroBackEnd.domain.entity.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<GameEntity, Long> {
}

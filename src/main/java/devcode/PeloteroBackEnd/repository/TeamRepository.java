package devcode.PeloteroBackEnd.repository;

import devcode.PeloteroBackEnd.domain.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<TeamEntity, Long> {
}

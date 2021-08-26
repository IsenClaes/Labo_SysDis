package hepl.isen.TvaService.tva;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TvaRepository extends JpaRepository<Tva, Long> {
}

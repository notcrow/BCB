package BCB.BCB.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import BCB.BCB.model.Fatura;

@Repository
public interface FaturaRepository extends JpaRepository<Fatura, Long> {

}

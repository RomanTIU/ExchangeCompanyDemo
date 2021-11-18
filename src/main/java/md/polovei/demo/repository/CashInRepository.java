package md.polovei.demo.repository;

import md.polovei.demo.models.CashIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashInRepository extends JpaRepository<CashIn, Long> {
}

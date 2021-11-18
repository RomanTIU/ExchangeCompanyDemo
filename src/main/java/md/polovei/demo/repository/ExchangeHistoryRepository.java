package md.polovei.demo.repository;

import md.polovei.demo.models.ExchangeHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeHistoryRepository extends JpaRepository<ExchangeHistory, Long> {
}

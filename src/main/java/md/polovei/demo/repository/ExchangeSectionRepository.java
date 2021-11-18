package md.polovei.demo.repository;

import md.polovei.demo.models.ExchangeSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeSectionRepository extends JpaRepository<ExchangeSection, Long> {
}

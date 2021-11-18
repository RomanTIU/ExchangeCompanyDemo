package md.polovei.demo.repository;

import md.polovei.demo.models.CurrencyDictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyDictionaryRepository extends JpaRepository<CurrencyDictionary, Long> {
}

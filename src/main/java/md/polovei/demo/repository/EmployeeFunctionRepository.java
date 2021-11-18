package md.polovei.demo.repository;

import md.polovei.demo.models.EmployeeFunction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeFunctionRepository extends JpaRepository<EmployeeFunction, Long> {
}

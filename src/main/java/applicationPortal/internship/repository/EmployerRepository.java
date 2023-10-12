package applicationPortal.internship.repository;

import applicationPortal.internship.domain.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Integer> {
    @Override
    Optional<Employer> findById(Integer integer);
}

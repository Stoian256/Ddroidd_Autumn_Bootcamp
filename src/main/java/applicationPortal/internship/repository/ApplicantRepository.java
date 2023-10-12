package applicationPortal.internship.repository;

import applicationPortal.internship.domain.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {
    List<Applicant> findByApplications_Id(Integer id);
    List<Applicant> findByApplications_Employer_Id(Integer id);
}

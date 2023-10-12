package applicationPortal.internship.repository;

import applicationPortal.internship.domain.JobListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobListingRepository extends JpaRepository<JobListing, Integer> {
    List<JobListing> findByEmployer_Id(Integer id);
    @Override
    Optional<JobListing> findById(Integer integer);

    @Override
    void deleteById(Integer integer);
}

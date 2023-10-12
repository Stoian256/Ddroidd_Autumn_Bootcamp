package applicationPortal.internship.service;

import applicationPortal.internship.domain.Employer;
import applicationPortal.internship.domain.JobListing;
import applicationPortal.internship.exception.ServiceException;
import applicationPortal.internship.exception.ValidatorException;
import applicationPortal.internship.repository.EmployerRepository;
import applicationPortal.internship.repository.JobListingRepository;
import applicationPortal.internship.validation.JobListingValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobListingService {
    private final JobListingRepository jobListingRepository;
    private final EmployerRepository employerRepository;
    private final JobListingValidator jobListingValidator;

    public JobListing addJobListing(String jobTitle, String jobType, String jobDescription, Employer employer, LocalDate applicationDeadline) {
        JobListing jobListing = new JobListing(0, jobTitle, jobType, jobDescription, applicationDeadline, employer);
        jobListingRepository.save(jobListing);
        return jobListing;
    }

    /**
     * Metoda pentru adaugarea unui jobListing pentru un employer(definit prin id-ul lui)
     * Se valideazaintai noul obiect creat
     *
     * @param jobTitle
     * @param jobType
     * @param jobDescription
     * @param employerId
     * @param applicationDeadline
     * @return
     * @throws ValidatorException
     * @throws ServiceException
     */
    public JobListing addJobListing(String jobTitle, String jobType, String jobDescription, Integer employerId, LocalDate applicationDeadline) throws ValidatorException, ServiceException {
        Employer employer = employerRepository.findById(employerId).orElseThrow(() -> new ServiceException("Empoyer not found!\n"));
        JobListing jobListing = new JobListing(0, jobTitle, jobType, jobDescription, applicationDeadline, employer);
        jobListingValidator.validateJobListing(jobListing);
        jobListingRepository.save(jobListing);
        return jobListing;
    }

    public List<JobListing> findAll() {
        return jobListingRepository.findAll();
    }

    public List<JobListing> findAllByEmployerId(Integer employerId) {
        return jobListingRepository.findByEmployer_Id(employerId);
    }

    public void deleteJobLisitng(Integer jobListingId) {
        jobListingRepository.deleteById(jobListingId);
    }
}

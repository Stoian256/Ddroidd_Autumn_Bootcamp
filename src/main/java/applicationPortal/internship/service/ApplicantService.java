package applicationPortal.internship.service;

import applicationPortal.internship.domain.Address;
import applicationPortal.internship.domain.Applicant;
import applicationPortal.internship.domain.JobListing;
import applicationPortal.internship.exception.ServiceException;
import applicationPortal.internship.exception.ValidatorException;
import applicationPortal.internship.repository.AddressRepository;
import applicationPortal.internship.repository.ApplicantRepository;
import applicationPortal.internship.repository.JobListingRepository;
import applicationPortal.internship.validation.ApplicantValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicantService {
    private final ApplicantRepository applicantRepository;
    private final JobListingRepository jobListingRepository;
    private final ApplicantValidator applicantValidator;
    private final AddressRepository addressRepository;

    public Applicant addApplicant(String firstName, String lastName, String phoneNumber, String email, Address address, List<JobListing> applications) {
        Applicant applicant = new Applicant(0, firstName, lastName, phoneNumber, email, address, applications);
        applicantRepository.save(applicant);
        return applicant;
    }

    public Applicant applyForJobListing(String firstName, String lastName, String phoneNumber, String email, Integer addressId, Integer jobListingId) throws ServiceException, ValidatorException {
        Address address = addressRepository.findById(addressId).orElseThrow(() -> new ServiceException("Address not found!\n"));
        JobListing jobListing = jobListingRepository.findById(jobListingId).orElseThrow(() -> new ServiceException("Job listing not found!\n"));
        Applicant applicant = new Applicant(0, firstName, lastName, phoneNumber, email, address, Arrays.asList(jobListing));
        applicantValidator.validateApplicant(applicant);
        applicantRepository.save(applicant);
        return applicant;
    }

    public List<Applicant> findAll() {
        return applicantRepository.findAll();
    }

    public List<Applicant> findAllByEmployerId(Integer employerId) {
        return applicantRepository.findByApplications_Employer_Id(employerId);
    }

    public List<Applicant> findAllByJobListingId(Integer jobListingId) {
        return applicantRepository.findByApplications_Id(jobListingId);
    }
}

package applicationPortal.internship.main;

import applicationPortal.internship.domain.Address;
import applicationPortal.internship.domain.Applicant;
import applicationPortal.internship.domain.Employer;
import applicationPortal.internship.domain.JobListing;
import applicationPortal.internship.exception.ServiceException;
import applicationPortal.internship.exception.ValidatorException;
import applicationPortal.internship.repository.AddressRepository;
import applicationPortal.internship.repository.ApplicantRepository;
import applicationPortal.internship.repository.EmployerRepository;
import applicationPortal.internship.repository.JobListingRepository;
import applicationPortal.internship.service.AddressService;
import applicationPortal.internship.service.ApplicantService;
import applicationPortal.internship.service.EmployerService;
import applicationPortal.internship.service.JobListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationPortalMain {
    private final AddressService addressService;
    private final ApplicantService applicantService;
    private final EmployerService employerService;
    private final JobListingService jobListingService;
    private List<Address> addressList;
    private List<Applicant> applicants;
    private List<Employer> employers;
    private List<JobListing> jobListings;
    private final AddressRepository addressRepository;

    /*
    Using the classes defined, create a data structure with at least the following contents:
    2 Employers, each with at least 4 job listings
    and 10 applicants for each employer distributed across the available job listings.
     */
    public void createDataStructure() {
        Address address1 = addressService.addAddress("Str. Carol I, Nr. 11", "Romania", "Suceava", "Siret");
        Address address2 = addressService.addAddress("Str. Carol I, Nr. 09", "Romania", "Suceava", "Siret");
        Address address3 = addressService.addAddress("Str. Becas, Nr. 11C I, Ap. 07", "Romania", "Cluj", "Cluj-Napoca");
        Address address4 = addressService.addAddress("Str. Becas, Nr. 11C I, Ap. 10", "Romania", "Cluj", "Cluj-Napoca");
        Address address5 = addressService.addAddress("Str. Becas, Nr. 11A I, Ap. 11", "Romania", "Cluj", "Cluj-Napoca");
        addressList = Arrays.asList(address1, address2, address3, address4, address5);

        Employer employer1 = employerService.addEmployer("Ddroidd", "0777777777", "ddroidd@yaho.com", address1);
        Employer employer2 = employerService.addEmployer("Arobs", "0888888888", "arobs@yaho.com", address2);
        employers = Arrays.asList(employer1, employer2);

        LocalDate testDate = LocalDate.of(2023, 12, 1);
        //Ddroidd jobs
        JobListing jobListing1 = jobListingService.addJobListing("Java Developer", "Full time", "description", employer1, testDate);
        JobListing jobListing2 = jobListingService.addJobListing("C# Developer", "Full time", "description", employer1, testDate);
        JobListing jobListing3 = jobListingService.addJobListing("React Native Developer", "Full time", "description", employer1, testDate);
        JobListing jobListing4 = jobListingService.addJobListing("Python Developer", "Full time", "description", employer1, testDate);

        //Arobs jobs
        JobListing jobListing5 = jobListingService.addJobListing("Java Developer", "Full time", "description", employer2, testDate);
        JobListing jobListing6 = jobListingService.addJobListing("C# Developer", "Full time", "description", employer2, testDate);
        JobListing jobListing7 = jobListingService.addJobListing("React Native Developer", "Full time", "description", employer2, testDate);
        JobListing jobListing8 = jobListingService.addJobListing("Python Developer", "Full time", "description", employer2, testDate);
        jobListings = Arrays.asList(jobListing1, jobListing2, jobListing3, jobListing4, jobListing5, jobListing6, jobListing7, jobListing8);


        Applicant applicant1 = applicantService.addApplicant("Silviu", "Stoian", "0555555555", "silviu@yahoo.com", address3, Arrays.asList(jobListing1, jobListing2));
        Applicant applicant2 = applicantService.addApplicant("Sergiu", "Stoian", "0111111111", "silviu@yahoo.com", address3, Arrays.asList(jobListing1, jobListing2));
        Applicant applicant3 = applicantService.addApplicant("Vlad", "Stoian", "0222222222", "silviu@yahoo.com", address3, Arrays.asList(jobListing3));
        Applicant applicant4 = applicantService.addApplicant("Lucian", "Stoian", "0333333333", "silviu@yahoo.com", address3, Arrays.asList(jobListing4));
        Applicant applicant5 = applicantService.addApplicant("Silviu", "Popescu", "0444444444", "silviu@yahoo.com", address4, Arrays.asList(jobListing5));
        Applicant applicant6 = applicantService.addApplicant("Petrica", "Popescu", "0666666666", "silviu@yahoo.com", address4, Arrays.asList(jobListing6, jobListing7));
        Applicant applicant7 = applicantService.addApplicant("Ioana", "Popescu", "099999999", "silviu@yahoo.com", address4, Arrays.asList(jobListing8, jobListing1));
        Applicant applicant8 = applicantService.addApplicant("Andrei", "Suciu", "0230000000", "silviu@yahoo.com", address5, Arrays.asList(jobListing5));
        Applicant applicant9 = applicantService.addApplicant("Eusebiu", "Suciu", "0230111111", "silviu@yahoo.com", address5, Arrays.asList(jobListing4));
        Applicant applicant10 = applicantService.addApplicant("Elvira", "Suciu", "0230222222", "silviu@yahoo.com", address5, Arrays.asList(jobListing1));
        applicants = Arrays.asList(applicant1, applicant2, applicant3, applicant4, applicant5, applicant6, applicant7, applicant8, applicant9, applicant10);

    }

    /*
    Display the contents of the data structure defined
     */
    public void displayDataStructure() {
        System.out.println(addressList);
        System.out.println(employers);
        System.out.println(jobListings);
        System.out.println(applicants);
    }

    /*
    Display the contents of the data structure defined
     */
    public void displayFromDatabase() {
        addressService.findAll().forEach(System.out::println);
        System.out.println();
        applicantService.findAll().forEach(System.out::println);
        System.out.println();
        employerService.findAll().forEach(System.out::println);
        System.out.println();
        jobListingService.findAll().forEach(System.out::println);
    }

    public void opperations() {
        List<JobListing> jobs = add2NewJobListings();
        //add5Applicants(jobs);
        displayJobsByEmployer(21);
        displayApplicantsByEmployer();
        displayApplicantsByJobListing();
        deleteJobListing(jobs);
    }

    /*
    Create a method to add a new Job Listing for one of the Employers
    Validate the input data
    Using this method, add 2 new Job Listings for both Employers
     */
    public List<JobListing> add2NewJobListings() {
        employers = employerService.findAll();
        List<JobListing> newJobs = new ArrayList<>();
        try {
            newJobs.add(jobListingService.addJobListing("HR", "Full time", "description", employers.get(0).getId(), LocalDate.of(2023, 12, 1)));
        } catch (ValidatorException | ServiceException e) {
            System.out.println(e);
        }
        try {
            newJobs.add(jobListingService.addJobListing("HR", "Full time", "description", employers.get(1).getId(), LocalDate.of(2023, 12, 1)));
        } catch (ValidatorException | ServiceException e) {
            System.out.println(e);
        }
        System.out.println("Jobs added with success\n");
        return newJobs;
    }

    /*
    Using this method add 5 applicants to the newly created Job Listings
     */
    public void add5Applicants(List<JobListing> newJobs) {
        List<Address> address = addressService.findAll();
        try {
            applicantService.applyForJobListing("Silviu", "Man", "0555555555", "silviu@yahoo.com", address.get(0).getId(), newJobs.get(0).getId());
            applicantService.applyForJobListing("Iulian", "Agape", "0111111111", "silviu@yahoo.com", address.get(1).getId(), newJobs.get(0).getId());
            applicantService.applyForJobListing("Vlad", "Popa", "0222222222", "silviu@yahoo.com", address.get(0).getId(), newJobs.get(1).getId());
            applicantService.applyForJobListing("Lucian", "Stan", "0333333333", "silviu@yahoo.com", address.get(1).getId(), newJobs.get(1).getId());
            applicantService.applyForJobListing("Octavian", "Popescu", "0444444444", "silviu@yahoo.com", address.get(2).getId(), newJobs.get(0).getId());

        } catch (ServiceException | ValidatorException e) {
            System.out.println(e);
        }
        System.out.println("Applications added with success\n");
    }

    /*
    Create a method to display all Job Listings for an Employer
    Call the method and display the result
    */
    public void displayJobsByEmployer(Integer employerId) {
        System.out.println("Jobs for employer "+employerId+":");
        jobListingService.findAllByEmployerId(employerId).forEach(System.out::println);
    }

    /*
    Create a method that gets all applicants for an Employer
    Call the method and display the result
     */
    public void displayApplicantsByEmployer() {
        Integer employerId = 21;
        System.out.println("Applicants for employer "+employerId+":");
        applicantService.findAllByEmployerId(employerId).forEach(System.out::println);
    }

    /*
    Create a method that gets all applicants for a Job Listing
    Call the method and display the result
     */
    public void displayApplicantsByJobListing() {
        Integer jobListingId = 57;
        System.out.println("Applicants for job listing "+jobListingId+":");
        applicantService.findAllByJobListingId(jobListingId).forEach(System.out::println);
    }

    /*
    Create a method to delete a job listing
    Call the method to delete one of the job listings
    Call the method to display the job listings for the employer to show the deletion has taken place
     */
    public void deleteJobListing(List<JobListing> jobs){
        Integer jobListingId = jobs.get(0).getId();
        Employer employer = jobs.get(0).getEmployer();
        System.out.println("Before delete:");
        displayJobsByEmployer(employer.getId());
        jobListingService.deleteJobLisitng(jobListingId);
        System.out.println("After delete:");
        displayJobsByEmployer(employer.getId());

    }
}

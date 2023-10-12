package applicationPortal.internship;

import applicationPortal.internship.domain.JobListing;
import applicationPortal.internship.exception.ValidatorException;
import applicationPortal.internship.validation.JobListingValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JobListingValidatorTests {
    private JobListingValidator jobListingValidator;

    @BeforeEach
    public void setUp() {
        jobListingValidator = new JobListingValidator();
    }

    @Test
    public void testValidJobListing() throws ValidatorException {
        JobListing jobListing = JobListing.builder()
                .jobTitle("Software Developer")
                .jobType("Full-time")
                .jobDescription("Exciting job description.")
                .applicationDeadline(LocalDate.now().plusDays(7))
                .build();

        // A valid job listing should not throw an exception
        jobListingValidator.validateJobListing(jobListing);
    }

    @Test
    public void testEmptyJobTitle() {
        JobListing jobListing = JobListing.builder()
                .jobTitle("")
                .jobType("Part-time")
                .jobDescription("Job description.")
                .applicationDeadline(LocalDate.now().plusDays(7))
                .build();

        ValidatorException exception = assertThrows(ValidatorException.class, () -> jobListingValidator.validateJobListing(jobListing));
        // Verificați mesajul excepției
        assertEquals("Job title can not be empty!\n", exception.getMessage());

    }

    @Test
    public void testEmptyJobType() {
        JobListing jobListing = JobListing.builder()
                .jobTitle("QA Engineer")
                .jobType("")
                .jobDescription("Testing job description.")
                .applicationDeadline(LocalDate.now().plusDays(7))
                .build();

        ValidatorException exception = assertThrows(ValidatorException.class, () -> jobListingValidator.validateJobListing(jobListing));
        assertEquals("Job type can not be empty!\n", exception.getMessage());

    }

    @Test
    public void testEmptyJobDescription() {
        JobListing jobListing = JobListing.builder()
                .jobTitle("Designer")
                .jobType("Contract")
                .jobDescription("")
                .applicationDeadline(LocalDate.now().plusDays(7))
                .build();

        ValidatorException exception = assertThrows(ValidatorException.class, () -> jobListingValidator.validateJobListing(jobListing));
        assertEquals("Job descriptionn can not be empty!\n", exception.getMessage());

    }

    @Test
    public void testPastApplicationDeadline() {
        JobListing jobListing = JobListing.builder()
                .jobTitle("Data Analyst")
                .jobType("Full-time")
                .jobDescription("Data analysis job description.")
                .applicationDeadline(LocalDate.now().minusDays(1))
                .build();

        ValidatorException exception = assertThrows(ValidatorException.class, () -> jobListingValidator.validateJobListing(jobListing));
        assertEquals("Job application deadline can not be before current date!\n", exception.getMessage());

    }
}

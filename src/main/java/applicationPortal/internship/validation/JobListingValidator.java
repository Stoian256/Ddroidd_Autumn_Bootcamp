package applicationPortal.internship.validation;

import applicationPortal.internship.domain.JobListing;
import applicationPortal.internship.exception.ValidatorException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class JobListingValidator {
    public void validateJobListing(JobListing jobListing) throws ValidatorException {
        String errors = "";
        if (jobListing.getJobTitle().isEmpty())
            errors += "Job title can not be empty!\n";
        if (jobListing.getJobType().isEmpty())
            errors += "Job type can not be empty!\n";
        if (jobListing.getJobDescription().isEmpty())
            errors += "Job descriptionn can not be empty!\n";
        if (jobListing.getApplicationDeadline().isBefore(LocalDate.now()))
            errors += "Job application deadline can not be before current date!\n";

        if (!errors.isEmpty())
            throw new ValidatorException(errors);
    }
}
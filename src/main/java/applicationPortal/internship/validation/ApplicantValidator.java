package applicationPortal.internship.validation;


import applicationPortal.internship.domain.Applicant;
import applicationPortal.internship.exception.ValidatorException;
import org.springframework.stereotype.Component;


@Component
public class ApplicantValidator {
    public void validateApplicant(Applicant applicant) throws ValidatorException {
        String errors = "";
        if (applicant.getFirstName().isEmpty())
            errors += "First name can not be empty!\n";
        if (applicant.getLastName().isEmpty())
            errors += "Last name can not be empty!\n";
        if (applicant.getPhoneNumber().isEmpty())
            errors += "Phone number can not be empty!\n";
        if (applicant.getEmail().isEmpty())
            errors += "Email can not be empty!\n";

        if (!errors.isEmpty())
            throw new ValidatorException(errors);

    }
}

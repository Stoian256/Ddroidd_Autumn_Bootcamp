package applicationPortal.internship.exception;


/**
 * O clasa de exceptie pentru exceptiile din validator ce extinde clasa Exception
 */
public class ValidatorException extends Exception {
    public ValidatorException(String errors) {
        super(errors);
    }
}

package applicationPortal.internship.exception;

public class ServiceException extends Exception{
    public ServiceException(String errors) {
        super(errors);
    }
}

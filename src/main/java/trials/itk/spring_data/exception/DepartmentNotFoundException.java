package trials.itk.spring_data.exception;

public class DepartmentNotFoundException extends RuntimeException {
	public DepartmentNotFoundException(String message) {
		super(message);
	}
}

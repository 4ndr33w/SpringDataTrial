package trials.itk.spring_data.data.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author 4ndr33w
 * @version 1.0
 */
@Getter
@RequiredArgsConstructor
public enum EmployeePosition {
	
	SLAVE("холоп"),
	MASTER("барин");
	
	private final String value;
}
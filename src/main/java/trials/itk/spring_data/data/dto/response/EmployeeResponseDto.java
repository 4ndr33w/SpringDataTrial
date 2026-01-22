package trials.itk.spring_data.data.dto.response;

import trials.itk.spring_data.data.enums.EmployeePosition;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author 4ndr33w
 * @version 1.1
 */
public record EmployeeResponseDto(
		UUID id,
		String firstName,
		String lastName,
		String email,
		EmployeePosition position,
		BigDecimal salary,
		UUID departmentId
) {
}
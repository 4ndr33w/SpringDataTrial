package trials.itk.spring_data.data.dto.response;

import trials.itk.spring_data.data.enums.EmployeePosition;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author 4ndr33w
 * @version 1.0
 */
public record EmployeeResponseDto(
		UUID id,
		String firstName,
		String lastName,
		EmployeePosition position,
		BigDecimal salary,
		UUID departmentId
) {
}
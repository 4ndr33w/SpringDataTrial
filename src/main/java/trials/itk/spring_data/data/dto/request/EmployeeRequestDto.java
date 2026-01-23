package trials.itk.spring_data.data.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import trials.itk.spring_data.data.enums.EmployeePosition;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author 4ndr33w
 * @version 1.1
 */
public record EmployeeRequestDto(
		@NotBlank String firstName,
		@NotBlank String lastName,
		@Email String email,
		@NotBlank String password,
		@NotNull EmployeePosition position,
		@PositiveOrZero BigDecimal salary,
		@NotNull UUID departmentId
) {
}
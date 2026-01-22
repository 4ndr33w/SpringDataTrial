package trials.itk.spring_data.data.dto.response;

import java.util.UUID;

/**
 * @author 4ndr33w
 * @version 1.0
 */
public record DepartmentResponseDto(
		UUID id,
		String name) {
}
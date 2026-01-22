package trials.itk.spring_data.data.dto.request;

import jakarta.validation.constraints.NotBlank;

/**
 * @author 4ndr33w
 * @version 1.0
 */
public record DepartmentRequestDto(@NotBlank String name) {
}
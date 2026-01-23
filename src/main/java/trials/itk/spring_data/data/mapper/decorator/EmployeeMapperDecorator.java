package trials.itk.spring_data.data.mapper.decorator;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import trials.itk.spring_data.data.dto.request.EmployeeRequestDto;
import trials.itk.spring_data.data.dto.response.EmployeeResponseDto;
import trials.itk.spring_data.data.entity.Employee;
import trials.itk.spring_data.data.mapper.EmployeeMapper;

/**
 * @author 4ndr33w
 * @version 1.0
 */
@Setter
@Primary
@Component
public abstract class EmployeeMapperDecorator implements EmployeeMapper {
	
	@Autowired
	@Qualifier("delegate")
	private EmployeeMapper delegate;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Employee mapToEntity(EmployeeRequestDto request) {
		Employee employee = delegate.mapToEntity(request);
		String rawPassword = request.password();
		employee.setPassword(passwordEncoder.encode(rawPassword));
		
		return employee;
	}

		// MapStruct что-то выделывается,
		// начал ругаться, что не может достать department.id из entity в интерфейсу
		// до этого все работало
	@Override
		public EmployeeResponseDto mapToResponseDto(Employee entity) {
			return new EmployeeResponseDto(
							entity.getId(),
							entity.getFirstName(),
							entity.getLastName(),
							entity.getEmail(),
							entity.getPosition(),
							entity.getSalary(),
							entity.getDepartment().getId()
			);
	}
}
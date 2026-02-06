package trials.itk.spring_data.service;

import trials.itk.spring_data.data.dto.request.EmployeeRequestDto;
import trials.itk.spring_data.data.dto.response.EmployeeResponseDto;

import java.util.List;
import java.util.UUID;

/**
 * @author 4ndr33w
 * @version 1.0
 */
public interface EmployeeService {
	
	EmployeeResponseDto create(EmployeeRequestDto request);
	EmployeeResponseDto update(UUID id, EmployeeRequestDto update);
	void delete(UUID id);
	EmployeeResponseDto getById(UUID id);
	List<EmployeeResponseDto> getAll();
	List<EmployeeResponseDto> getByDepartmentId(UUID departmentId);
}
package trials.itk.spring_data.service;

import trials.itk.spring_data.data.dto.request.DepartmentRequestDto;
import trials.itk.spring_data.data.dto.response.DepartmentResponseDto;

import java.util.List;
import java.util.UUID;

/**
 * @author 4ndr33w
 * @version 1.0
 */
public interface DepartmentService {
	
	DepartmentResponseDto create(DepartmentRequestDto request);
	DepartmentResponseDto update(UUID id, DepartmentRequestDto update);
	void delete(UUID id);
	DepartmentResponseDto getById(UUID id);
	List<DepartmentResponseDto> getAll();
}
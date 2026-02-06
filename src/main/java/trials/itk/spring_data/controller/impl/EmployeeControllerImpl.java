package trials.itk.spring_data.controller.impl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import trials.itk.spring_data.controller.EmployeeController;
import trials.itk.spring_data.data.dto.request.EmployeeRequestDto;
import trials.itk.spring_data.data.dto.response.EmployeeResponseDto;
import trials.itk.spring_data.service.EmployeeService;

import java.util.List;
import java.util.UUID;

/**
 * @author 4ndr33w
 * @version 1.0
 */
@RestController
@RequiredArgsConstructor
public class EmployeeControllerImpl implements EmployeeController {
	
	private final EmployeeService employeeService;
	
	@Override
	public ResponseEntity<EmployeeResponseDto> create(@Valid EmployeeRequestDto request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.create(request));
	}
	
	@Override
	public ResponseEntity<EmployeeResponseDto> getById(UUID id) {
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getById(id));
	}
	
	@Override
	public ResponseEntity<List<EmployeeResponseDto>> getByDepartmentId(UUID departmentId) {
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getByDepartmentId(departmentId));
	}
	
	@Override
	public ResponseEntity<EmployeeResponseDto> update(UUID id, @Valid EmployeeRequestDto request) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(employeeService.update(id, request));
	}
	
	@Override
	public ResponseEntity<Void> delete(UUID id) {
		employeeService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@Override
	public ResponseEntity<List<EmployeeResponseDto>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAll());
	}
}
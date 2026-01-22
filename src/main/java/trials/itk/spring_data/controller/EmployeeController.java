package trials.itk.spring_data.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import trials.itk.spring_data.data.dto.request.EmployeeRequestDto;
import trials.itk.spring_data.data.dto.response.EmployeeResponseDto;

import java.util.List;
import java.util.UUID;

/**
 * @author 4ndr33w
 * @version 1.0
 */
@RequestMapping("/api/v1/employees")
public interface EmployeeController {
	
	@PostMapping
	ResponseEntity<EmployeeResponseDto> create(@RequestBody EmployeeRequestDto request);
	
	@GetMapping("/{id}")
	ResponseEntity<EmployeeResponseDto> getById(@PathVariable UUID id);
	
	@GetMapping("/department/{departmentId}")
	ResponseEntity<List<EmployeeResponseDto>> getByDepartmentId(@PathVariable UUID departmentId);
	
	@PatchMapping("/{id}")
	ResponseEntity<EmployeeResponseDto> update(@PathVariable UUID id, @RequestBody EmployeeRequestDto request);
	
	@DeleteMapping("/{id}")
	ResponseEntity<Void> delete(@PathVariable UUID id);
	
	@GetMapping
	ResponseEntity<List<EmployeeResponseDto>> getAll();
}
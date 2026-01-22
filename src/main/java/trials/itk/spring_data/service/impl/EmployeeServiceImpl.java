package trials.itk.spring_data.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trials.itk.spring_data.data.dto.request.EmployeeRequestDto;
import trials.itk.spring_data.data.dto.response.EmployeeResponseDto;
import trials.itk.spring_data.data.entity.Department;
import trials.itk.spring_data.data.entity.Employee;
import trials.itk.spring_data.data.mapper.EmployeeMapper;
import trials.itk.spring_data.data.repository.DepartmentRepository;
import trials.itk.spring_data.data.repository.EmployeeRepository;
import trials.itk.spring_data.exception.DepartmentNotFoundException;
import trials.itk.spring_data.exception.EmployeeNotFoundException;
import trials.itk.spring_data.service.EmployeeService;

import java.util.List;
import java.util.UUID;

/**
 * @author 4ndr33w
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	private final EmployeeMapper employeeMapper;
	private final DepartmentRepository departmentRepository;
	
	@Override
	@Transactional
	public EmployeeResponseDto create(EmployeeRequestDto request) {
		Department existingDepartment = departmentRepository.findById(request.departmentId())
				.orElseThrow(() -> new DepartmentNotFoundException("Department not found"));
		
		Employee newEmployee = employeeMapper.mapToEntity(request);
		newEmployee.setDepartment(existingDepartment);
		Employee savedEmployee = employeeRepository.save(newEmployee);
		
		return employeeMapper.mapToResponseDto(savedEmployee);
	}
	
	@Override
	@Transactional
	public EmployeeResponseDto update(UUID id, EmployeeRequestDto update) {
		Employee existingEmployee =  getEmployeeByIdOrElseThrow(id);
		
		if(update.departmentId() != null) {
			Department newEmployeeDepartment = departmentRepository.findById(update.departmentId())
					.orElseThrow(() -> new EmployeeNotFoundException("Department not found"));
			existingEmployee.setDepartment(newEmployeeDepartment);
		}
		Employee updatedEmployee = employeeMapper.updateEntity(update, existingEmployee);
		
		return employeeMapper.mapToResponseDto(updatedEmployee);
	}
	
	@Override
	@Transactional
	public void delete(UUID id) {
		Employee existingEmployee = getEmployeeByIdOrElseThrow(id);
		employeeRepository.delete(existingEmployee);
	
	}
	
	@Override
	@Transactional(readOnly = true)
	public EmployeeResponseDto getById(UUID id) {
		Employee employee = getEmployeeByIdOrElseThrow(id);
		
		return employeeMapper.mapToResponseDto(employee);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<EmployeeResponseDto> getAll() {
		List<Employee> employees = employeeRepository.findAll();
		
		return employees.stream()
				.map(employeeMapper::mapToResponseDto)
				.toList();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<EmployeeResponseDto> getByDepartmentId(UUID departmentId) {
		if (!departmentRepository.existsById(departmentId)) {
			throw new DepartmentNotFoundException("Department not found");
		}
		List<Employee> employees = employeeRepository.findByDepartmentId(departmentId);

		return employees.stream()
				.map(employeeMapper::mapToResponseDto)
				.toList();
	}
	
	private Employee getEmployeeByIdOrElseThrow(UUID id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
	}
}
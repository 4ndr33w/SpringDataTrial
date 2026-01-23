package trials.itk.spring_data.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trials.itk.spring_data.data.entity.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author 4ndr33w
 * @version 1.1
 */
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
	
	List<Employee> findByDepartmentId(UUID departmentId);
	Optional<Employee> findByEmail(String email);
}
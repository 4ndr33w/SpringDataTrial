package trials.itk.spring_data.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trials.itk.spring_data.data.entity.Department;

import java.util.UUID;

/**
 * @author 4ndr33w
 * @version 1.0
 */
public interface DepartmentRepository extends JpaRepository<Department, UUID> {
}
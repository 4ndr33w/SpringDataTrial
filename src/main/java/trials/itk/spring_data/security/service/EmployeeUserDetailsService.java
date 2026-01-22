package trials.itk.spring_data.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trials.itk.spring_data.data.entity.Employee;
import trials.itk.spring_data.data.repository.EmployeeRepository;
import trials.itk.spring_data.security.data.EmployeeUserDetails;

/**
 * @author 4ndr33w
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class EmployeeUserDetailsService implements UserDetailsService {
	
	private final EmployeeRepository employeeRepository;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee existingEmployee = employeeRepository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		
		return new EmployeeUserDetails(existingEmployee);
	}
}
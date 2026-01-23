package trials.itk.spring_data.security.data;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import trials.itk.spring_data.data.entity.Employee;

import java.util.Collection;
import java.util.List;

/**
*
* @version 1.0
* @author 4ndr33w
*/
@RequiredArgsConstructor
public class EmployeeUserDetails implements UserDetails {
	
	private final Employee employee;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(employee.getPosition());
	}
	
	@Override
	public String getPassword() {
		return employee.getPassword();
	}
	
	@Override
	public String getUsername() {
		return employee.getEmail();
	}
}
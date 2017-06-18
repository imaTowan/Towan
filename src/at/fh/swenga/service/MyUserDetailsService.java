package at.fh.swenga.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.dao.UserRepository;
import at.fh.swenga.model.UserModel;
import at.fh.swenga.model.UserRoleModel;

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserRepository userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel user = null;
		List<UserModel> userList = userDao.findByUsername(username);
		if (userList != null && userList.size() > 0) {
			user = userList.get(0);
		}
		if (user == null) {
			throw new UsernameNotFoundException("user was not found");
		}
		List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());
		return buildUserForAuthentication(user, authorities);
	}

	private org.springframework.security.core.userdetails.User buildUserForAuthentication(UserModel user,
			List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				/*user.isActivated(),
				true, // account not expired
				true, // credentials not expired
				true, // account not locked*/
				authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<UserRoleModel> userRoles) {
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		for (UserRoleModel userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
		return Result;
	}
}

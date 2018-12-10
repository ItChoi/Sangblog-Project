package ver2.blog.sang.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ver2.blog.sang.persistence.ManagerDao;

public class UserDetailsServiceImpl implements UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	
	@Autowired
	ManagerDao managerDao;

	
	@Override
	public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
		// UserDetailsService : 아이디를 통해 계정 정보 GET
		
		// % 매니저 페이지에서 따로 권한을 주는 방법 필요
		// % 매니저  / 유저
		// 1. loginId 를 통해 권한 확인
		// 2. 매니저 / 그냥 유저 구분해서 한번ㅇ ㅔ어케? -> x
		
     	// JdbcDaoImpl
		// RoleVoter
		
		
		// ManagerInfo managerInfo = managerDao.getManagerInfoByLoginId(loginId);
		String password = managerDao.getPasswordByLoginId(loginId);
		
		Collection<SimpleGrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("ROLE_MANAGER"));
		
		// @SuppressWarnings("null")
		UserDetails user = new User(loginId, password, roles);
		
		return user;
	}

	
	
	
	
}

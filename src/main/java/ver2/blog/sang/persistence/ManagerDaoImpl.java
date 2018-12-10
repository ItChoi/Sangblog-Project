package ver2.blog.sang.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ver2.blog.sang.auth.UserDetailsServiceImpl;
import ver2.blog.sang.domain.ManagerCertificate;
import ver2.blog.sang.domain.ManagerExperience;
import ver2.blog.sang.domain.ManagerInfo;

@Repository
public class ManagerDaoImpl implements ManagerDao {
	private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	
	private static final String NAMESPACE = "ver2.blog.sang.ManagerMapper";
	
	@Autowired SqlSession sqlSession;

	@Override
	public ManagerInfo getManagerInfoByLoginId(String loginId) {
		return sqlSession.selectOne(NAMESPACE + ".getManagerInfoByLoginId", loginId);
	}

	@Override
	public List<ManagerExperience> getManagerExperienceByManagerId(int managerId) {
		return sqlSession.selectList(NAMESPACE + ".getManagerExperienceByManagerId", managerId);
	}

	@Override
	public List<ManagerCertificate> getManagerCertificateByManagerId(int managerId) {
		return sqlSession.selectList(NAMESPACE + ".getManagerCertificate", managerId);
	}

	@Override
	public void updateManagerInfo(ManagerInfo managerInfo) {
		sqlSession.update(NAMESPACE + ".updateManagerInfo", managerInfo);
	}

	@Override
	public int getManagerIdByLoginId(String loginId) {
		return sqlSession.selectOne(NAMESPACE + ".getManagerIdByLoginId", loginId);
	}

	@Override
	public void insertSpec(ManagerInfo managerInfo) {
		if (managerInfo.getManagerCertificate() != null) {
			sqlSession.insert(NAMESPACE + ".insertCertificate", managerInfo);
		} 
		
		if (managerInfo.getManagerExperience() != null) {
			sqlSession.insert(NAMESPACE + ".insertExperience", managerInfo);
		}
		
	}
	
	@Override
	public int deleteSpec(int specId, String type) {
		int successStatus = 0;
		
		if ("certificate".equals(type)) {
			successStatus = sqlSession.delete(NAMESPACE + ".deleteCertificate", specId);
		}
		
		if ("experience".equals(type)) {
			successStatus = sqlSession.delete(NAMESPACE + ".deleteExperience", specId);
		}
		
		return successStatus;
	}

	@Override
	public String getPasswordByLoginId(String loginId) {
		/*Map<String, String> map = new HashMap<>();
		map.put("loginId", loginId);
		map.put("password", password);*/
		return sqlSession.selectOne(NAMESPACE + ".getPasswordByLoginId", loginId);
	}
	

}

package ver2.blog.sang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ver2.blog.sang.domain.ManagerCertificate;
import ver2.blog.sang.domain.ManagerExperience;
import ver2.blog.sang.domain.ManagerInfo;
import ver2.blog.sang.mapper.ManagerMapper;
import ver2.blog.sang.persistence.ManagerDao;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired ManagerDao managerDao;
	
	// @Autowired ManagerMapper managerMapper;
	
	@Override
	public ManagerInfo getManagerInfoByLoginId(String loginId) {
		return managerDao.getManagerInfoByLoginId(loginId);
	}

	/*@Override
	public ManagerInfo getManagerInfo() {
		return managerMapper.getManagerInfo();
	}*/
	
	@Override
	public List<ManagerExperience> getManagerExperienceByManagerId(int managerId) {
		return managerDao.getManagerExperienceByManagerId(managerId);
	}

	@Override
	public List<ManagerCertificate> getManagerCertificateByManagerId(int managerId) {
		return managerDao.getManagerCertificateByManagerId(managerId);
	}

	@Override
	public void updateManagerInfo(ManagerInfo managerInfo) {
		managerDao.updateManagerInfo(managerInfo);
	}

	@Override
	public int getManagerIdByLoginId(String loginId) {
		return managerDao.getManagerIdByLoginId(loginId);
		
	}

	@Override
	public void insertSpec(ManagerInfo managerInfo) {
		managerDao.insertSpec(managerInfo);
	}

	@Override
	public int deleteSpec(int specId, String type) {
		return managerDao.deleteSpec(specId, type);
	}

	@Override
	public String getPasswordByLoginId(String loginId) {
		return managerDao.getPasswordByLoginId(loginId);
	}
	

	
}

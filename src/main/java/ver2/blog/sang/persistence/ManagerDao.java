package ver2.blog.sang.persistence;

import java.util.List;

import ver2.blog.sang.domain.ManagerCertificate;
import ver2.blog.sang.domain.ManagerExperience;
import ver2.blog.sang.domain.ManagerInfo;

public interface ManagerDao {
	public ManagerInfo getManagerInfoByLoginId(String loginId);
	public List<ManagerExperience> getManagerExperienceByManagerId(int managerId);
	public List<ManagerCertificate> getManagerCertificateByManagerId(int managerId);
	public void updateManagerInfo(ManagerInfo managerInfo);
	public int getManagerIdByLoginId(String loginId);
	public void insertSpec(ManagerInfo managerInfo);
	public int deleteSpec(int specId, String type);
	public String getPasswordByLoginId(String loginId);
}

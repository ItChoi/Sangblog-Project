package ver2.blog.sang.service;

import java.util.List;

import ver2.blog.sang.domain.ManagerCertificate;
import ver2.blog.sang.domain.ManagerExperience;
import ver2.blog.sang.domain.ManagerInfo;

public interface ManagerService {
	// 매니저 정보 불러오기
	public ManagerInfo getManagerInfoByLoginId(String loginId);
	// 매니저 아이디에 해당하는 경력정보 불러오기
	public List<ManagerExperience> getManagerExperienceByManagerId(int managerId);
	// 매니저 아이디에 해당하는 자격증 정보 불러오기
	public List<ManagerCertificate> getManagerCertificateByManagerId(int managerId);
	// 매니저 정보만 수정
	public void updateManagerInfo(ManagerInfo managerInfo);
	// 로그인 아이디에 해당하는 매니저 정보 불러오기
	public int getManagerIdByLoginId(String loginId);
	// 자격증 / 경력 정보 추가하기
	public void insertSpec(ManagerInfo managerInfo);
	// 자격증 / 경력 정보 구분하여 삭제하기
	public int deleteSpec(int specId, String type);
	// 아이디 / 비밀번호 체크
	public String getPasswordByLoginId(String loginId);
	
}

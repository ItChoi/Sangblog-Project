package ver2.blog.sang.domain;

public class ManagerExperience {
	private int experienceId;
	private int managerId;
	private String workYear;
	private String company;
	private String workDetail;
	
	public ManagerExperience() { }
	public ManagerExperience(int experienceId, int managerId, String workYear, String company, String workDetail) {
		this.experienceId = experienceId;
		this.managerId = managerId;
		this.workYear = workYear;
		this.company = company;
		this.workDetail = workDetail;
	}

	public int getExperienceId() {
		return experienceId;
	}
	public void setExperienceId(int experienceId) {
		this.experienceId = experienceId;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getWorkYear() {
		return workYear;
	}
	public void setWorkYear(String workYear) {
		this.workYear = workYear;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getWorkDetail() {
		return workDetail;
	}
	public void setWorkDetail(String workDetail) {
		this.workDetail = workDetail;
	}
	
	
}

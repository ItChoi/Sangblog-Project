package ver2.blog.sang.domain;

public class ManagerCertificate {
	private int certificateId;
	private int managerId;
	private String getYear;
	private String certificateName;
	
	public ManagerCertificate() { }
	
	public ManagerCertificate(int certificateId, int managerId, String getYear, String certificateName) {
		this.certificateId = certificateId;
		this.managerId = managerId;
		this.getYear = getYear;
		this.certificateName = certificateName;
	}

	public int getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(int certificateId) {
		this.certificateId = certificateId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getGetYear() {
		return getYear;
	}

	public void setGetYear(String getYear) {
		this.getYear = getYear;
	}

	public String getCertificateName() {
		return certificateName;
	}

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}


	
	
}

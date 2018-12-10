package ver2.blog.sang.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class ManagerInfo {
	private int managerId;
	private String loginId;
	private String password;
	private String name;
	private String phoneNumber;
	private String email;
	private String introduce;
	private String imageName;
	private String imageSrc;
	private Date loginDate;
	
	private String phoneNumber1;
	private String phoneNumber2;
	private String phoneNumber3;
	
	
				
	private String phoneNumberLabel;
	
	private ManagerCertificate managerCertificate;
	private ManagerExperience managerExperience;
	
	
	
	private MultipartFile file;

	public ManagerInfo() { }
	
	public ManagerInfo(String password) {
		this.password = password;
	}


	public int getManagerId() {
		return managerId;
	}


	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}


	public String getLoginId() {
		return loginId;
	}


	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getIntroduce() {
		return introduce;
	}


	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}


	public String getImageName() {
		return imageName;
	}


	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	public String getImageSrc() {
		return imageSrc;
	}

	public void setImageSrc(String imageSrc) {
		this.imageSrc = imageSrc;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}


	public MultipartFile getFile() {
		return file;
	}


	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getPhoneNumberLabel() {
		phoneNumber = phoneNumber1 + "-" + phoneNumber2 + "-" + phoneNumber3;
		
		if ("--".equals(phoneNumber)) {
			return "";
		} else {
			return phoneNumber;
		}
		
	}

	public void setPhoneNumberLabel(String phoneNumber) {
		if (phoneNumber != "" && phoneNumber != null) {
			String[] phoneDivide = phoneNumber.split("-");
			this.phoneNumber1 = phoneDivide[0];
			this.phoneNumber2 = phoneDivide[1];
			this.phoneNumber3 = phoneDivide[2];
		}
		
	}

	public String getPhoneNumber1() {
		return phoneNumber1;
	}

	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public String getPhoneNumber3() {
		return phoneNumber3;
	}



	public void setPhoneNumber3(String phoneNumber3) {
		this.phoneNumber3 = phoneNumber3;
	}



	public ManagerCertificate getManagerCertificate() {
		return managerCertificate;
	}


	public void setManagerCertificate(ManagerCertificate managerCertificate) {
		this.managerCertificate = managerCertificate;
	}



	public ManagerExperience getManagerExperience() {
		return managerExperience;
	}



	public void setManagerExperience(ManagerExperience managerExperience) {
		this.managerExperience = managerExperience;
	}

	

	
	
	
}

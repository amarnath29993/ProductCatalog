package com.productcatalog.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	private String name;
	private String emailId;
	private String password;
	private String phone;
	private String status;
	private Date dateOfEnquiry;
	/*@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="customerId",referencedColumnName="customerId")
	private Set<Address> addressId = new HashSet<Address>();*/
	private Integer addressId;
	private String securityQuestions;
	private String answer;

	public Customer() {
		super();
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateOfEnquiry() {
		return dateOfEnquiry;
	}

	public void setDateOfEnquiry(Date dateOfEnquiry) {
		this.dateOfEnquiry = dateOfEnquiry;
	}

	
	public String getSecurityQuestions() {
		return securityQuestions;
	}

	public void setSecurityQuestions(String securityQuestions) {
		this.securityQuestions = securityQuestions;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", emailId=" + emailId + ", password="
				+ password + ", phone=" + phone + ", status=" + status + ", dateOfEnquiry=" + dateOfEnquiry
				+ ", addressId=" + addressId + ", securityQuestions=" + securityQuestions + ", answer=" + answer + "]";
	}

	

	
}

package com.productcatalog.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
    private String mobileNumber;
	
	private String customerName;
	
	private String emailId;
	
	private String password;
	
	private String secQuestion;
	
	private String secAns;
	
	private boolean status=true;
	
	/*@OneToOne(targetEntity=Address.class,cascade=CascadeType.ALL)
	private Address address;
	*/
	

	public Customer() {
		super();
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	public String getSecQuestion() {
		return secQuestion;
	}

	public void setSecQuestion(String secQuestion) {
		this.secQuestion = secQuestion;
	}

	public String getSecAns() {
		return secAns;
	}

	public void setSecAns(String secAns) {
		this.secAns = secAns;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Customer [mobileNumber=" + mobileNumber + ", customerName=" + customerName + ", emailId=" + emailId
				+ ", password=" + password + ", secQuestion=" + secQuestion + ", secAns=" + secAns + ", status="
				+ status + "]";
	}

	

	
}

package com.ibm.userregistration.entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
@Entity
@Table(name="userdetails")
public class UserDetails 
{
    @Id
    @Column(name="username")
    String username;
    @Column(name="password")
    String password;
    @Column(name="first_name")
    String firstName;
    @Column(name="last_name")
    String lastName;
    @Column(name="email_id")
    String emailId;
    @Column(name="mobile_no")
    long mobileNo;
    public UserDetails() {}
	public UserDetails(String username, String password, String firstName, String lastName, String emailId,long mobileNo) 
	{
		this.username = username;		this.password = password;		this.firstName = firstName;
		this.lastName = lastName;		this.emailId = emailId;		this.mobileNo = mobileNo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
}

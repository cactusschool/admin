package com.ashish.cactus.school.admin.db.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;



/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
@Where(clause="(delete_ind is NULL or delete_ind='N') and (user_approved_ind='Y')")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id", unique=true, nullable=false)
	private int userId;

	@Column(name="account_locked")
	private String accountLocked;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_user", length=50)
	private String createUser;

	@Column(name="delete_ind", length=2)
	private String deleteInd;

	@Column(name="delete_reason", length=100)
	private String deleteReason;

	@Column(name="end_date")
	private Timestamp endDate;

	@Column(name="first_name", nullable=false, length=50)
	private String firstName;

	@Column(name="last_logged_in")
	private Timestamp lastLoggedIn;

	@Column(name="last_name", length=50)
	private String lastName;

	@Column(name="middle_name", length=50)
	private String middleName;

	@Column(name="parent_id")
	private int parentId;

	@Column(nullable=false, length=50)
	private String password;

	@Column(name="update_date")
	private Timestamp updateDate;

	@Column(name="update_user", length=50)
	private String updateUser;

	@Column(name="user_name", nullable=false, length=50)
	private String userName;

	@Column(name="user_approval_comment", length=100)
	private String userApprovalComment;

	@Column(name="user_approved_ind", length=2)
	private String userApprovedInd;
	
	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="user", cascade={CascadeType.REMOVE,CascadeType.MERGE, CascadeType.REFRESH}, fetch=FetchType.LAZY)
	private List<Address> addresses;

	//bi-directional many-to-one association to SchoolUser
	@OneToMany(mappedBy="user")
	private List<SchoolUser> schoolUsers;
	
	//bi-directional many-to-one association to LicenseDetail
	@OneToMany(mappedBy="schoolMaster", cascade={CascadeType.REMOVE,CascadeType.MERGE, CascadeType.REFRESH}, fetch=FetchType.LAZY)
	private List<LicenseDetail> licenseDetails;

	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="user")
	private List<AdminUserRole> userRoles;
		
	public User() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAccountLocked() {
		return this.accountLocked;
	}

	public void setAccountLocked(String accountLocked) {
		this.accountLocked = accountLocked;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getDeleteInd() {
		return this.deleteInd;
	}

	public void setDeleteInd(String deleteInd) {
		this.deleteInd = deleteInd;
	}

	public String getDeleteReason() {
		return this.deleteReason;
	}

	public void setDeleteReason(String deleteReason) {
		this.deleteReason = deleteReason;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Timestamp getLastLoggedIn() {
		return this.lastLoggedIn;
	}

	public void setLastLoggedIn(Timestamp lastLoggedIn) {
		this.lastLoggedIn = lastLoggedIn;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public int getParentId() {
		return this.parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setUser(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setUser(null);

		return address;
	}

	public List<SchoolUser> getSchoolUsers() {
		return this.schoolUsers;
	}

	public void setSchoolUsers(List<SchoolUser> schoolUsers) {
		this.schoolUsers = schoolUsers;
	}

	public SchoolUser addSchoolUser(SchoolUser schoolUser) {
		getSchoolUsers().add(schoolUser);
		schoolUser.setUser(this);

		return schoolUser;
	}

	public SchoolUser removeSchoolUser(SchoolUser schoolUser) {
		getSchoolUsers().remove(schoolUser);
		schoolUser.setUser(null);

		return schoolUser;
	}

	public String getUserApprovalComment() {
		return this.userApprovalComment;
	}

	public void setUserApprovalComment(String userApprovalComment) {
		this.userApprovalComment = userApprovalComment;
	}

	public String getUserApprovedInd() {
		return this.userApprovedInd;
	}

	public void setUserApprovedInd(String userApprovedInd) {
		this.userApprovedInd = userApprovedInd;
	}
	
	public List<LicenseDetail> getLicenseDetails() {
		return this.licenseDetails;
	}

	public void setLicenseDetails(List<LicenseDetail> licenseDetails) {
		this.licenseDetails = licenseDetails;
	}

	public LicenseDetail addLicenseDetail(LicenseDetail licenseDetail) {
		getLicenseDetails().add(licenseDetail);
		licenseDetail.setUser(this);

		return licenseDetail;
	}

	public LicenseDetail removeLicenseDetail(LicenseDetail licenseDetail) {
		getLicenseDetails().remove(licenseDetail);
		licenseDetail.setUser(null);

		return licenseDetail;
	}
	
	public List<AdminUserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<AdminUserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public AdminUserRole addUserRole(AdminUserRole userRole) {
		getUserRoles().add(userRole);
		userRole.setUser(this);

		return userRole;
	}

	public AdminUserRole removeUserRole(AdminUserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.setUser(null);

		return userRole;
	}
}
package com.ashish.cactus.school.admin.db.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Where;

import java.sql.Timestamp;


/**
 * The persistent class for the license_details database table.
 * 
 */
@Entity
@Table(name="license_details")
@NamedQuery(name="LicenseDetail.findAll", query="SELECT l FROM LicenseDetail l")
@Where(clause="delete_ind is NULL or delete_ind='N'")
public class LicenseDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="license_id", unique=true, nullable=false)
	private int licenseId;

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

	@Column(name="payment_needed", length=2)
	private String paymentNeeded;

	@Column(name="start_date")
	private Timestamp startDate;

	@Column(name="subscription_fees")
	private double subscriptionFees;

	@Column(name="update_date")
	private Timestamp updateDate;

	@Column(name="update_user", length=50)
	private String updateUser;

	//bi-directional many-to-one association to SchoolMaster
	@ManyToOne
	@JoinColumn(name="school_id")
	private SchoolMaster schoolMaster;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public LicenseDetail() {
	}

	public int getLicenseId() {
		return this.licenseId;
	}

	public void setLicenseId(int licenseId) {
		this.licenseId = licenseId;
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

	public String getPaymentNeeded() {
		return this.paymentNeeded;
	}

	public void setPaymentNeeded(String paymentNeeded) {
		this.paymentNeeded = paymentNeeded;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public double getSubscriptionFees() {
		return this.subscriptionFees;
	}

	public void setSubscriptionFees(double subscriptionFees) {
		this.subscriptionFees = subscriptionFees;
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

	public SchoolMaster getSchoolMaster() {
		return this.schoolMaster;
	}

	public void setSchoolMaster(SchoolMaster schoolMaster) {
		this.schoolMaster = schoolMaster;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
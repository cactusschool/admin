package com.ashish.cactus.school.admin.db.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Where;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the modules_permission database table.
 * 
 */
@Entity
@Table(name="modules_permission")
@NamedQuery(name="ModulesPermission.findAll", query="SELECT m FROM ModulesPermission m")
@Where(clause="delete_ind is NULL or delete_ind='N'")
public class ModulesPermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="module_permission_id", unique=true, nullable=false)
	private int modulePermissionId;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_user", length=50)
	private String createUser;

	@Column(name="delete_ind", length=2)
	private String deleteInd;

	@Column(name="delete_reason", length=100)
	private String deleteReason;

	@Column(name="update_date")
	private Timestamp updateDate;

	@Column(name="update_user", length=50)
	private String updateUser;

	//bi-directional many-to-one association to ModuleMaster
	@ManyToOne
	@JoinColumn(name="module_id", nullable=false)
	private ModuleMaster moduleMaster;

	//bi-directional many-to-one association to SchoolMaster
	@ManyToOne
	@JoinColumn(name="school_id")
	private SchoolMaster schoolMaster;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public ModulesPermission() {
	}

	public int getModulePermissionId() {
		return this.modulePermissionId;
	}

	public void setModulePermissionId(int modulePermissionId) {
		this.modulePermissionId = modulePermissionId;
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

	public ModuleMaster getModuleMaster() {
		return this.moduleMaster;
	}

	public void setModuleMaster(ModuleMaster moduleMaster) {
		this.moduleMaster = moduleMaster;
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
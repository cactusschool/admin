package com.ashish.cactus.school.admin.db.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Where;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the module_master database table.
 * 
 */
@Entity
@Table(name="module_master")
@NamedQuery(name="ModuleMaster.findAll", query="SELECT m FROM ModuleMaster m")
@Where(clause="delete_ind is NULL or delete_ind='N'")
public class ModuleMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="module_id", unique=true, nullable=false)
	private int moduleId;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_user", length=50)
	private String createUser;

	@Column(name="delete_ind", length=2)
	private String deleteInd;

	@Column(name="delete_reason", length=100)
	private String deleteReason;

	@Column(length=100)
	private String description;

	@Column(name="module_feature", length=50)
	private String moduleFeature;

	@Column(name="module_name", nullable=false, length=50)
	private String moduleName;

	@Column(name="update_date")
	private Timestamp updateDate;

	@Column(name="update_user", length=50)
	private String updateUser;

	//bi-directional many-to-one association to ModulesPermission
	@OneToMany(mappedBy="moduleMaster")
	private List<ModulesPermission> modulesPermissions;

	public ModuleMaster() {
	}

	public int getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModuleFeature() {
		return this.moduleFeature;
	}

	public void setModuleFeature(String moduleFeature) {
		this.moduleFeature = moduleFeature;
	}

	public String getModuleName() {
		return this.moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
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

	public List<ModulesPermission> getModulesPermissions() {
		return this.modulesPermissions;
	}

	public void setModulesPermissions(List<ModulesPermission> modulesPermissions) {
		this.modulesPermissions = modulesPermissions;
	}

	public ModulesPermission addModulesPermission(ModulesPermission modulesPermission) {
		getModulesPermissions().add(modulesPermission);
		modulesPermission.setModuleMaster(this);

		return modulesPermission;
	}

	public ModulesPermission removeModulesPermission(ModulesPermission modulesPermission) {
		getModulesPermissions().remove(modulesPermission);
		modulesPermission.setModuleMaster(null);

		return modulesPermission;
	}

}
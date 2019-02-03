package com.ashish.cactus.school.admin.input;

import io.swagger.annotations.ApiModelProperty;

public class ModuleDetails {
	@ApiModelProperty(position=1, value="")
	private int moduleId;
	@ApiModelProperty(position=2, value="")
	private String moduleName;
	@ApiModelProperty(position=3, value="")
	private String moduleFeature;
	@ApiModelProperty(position=4, value="")
	private String description;
	@ApiModelProperty(position=5, value="")
	private DeleteDetails deleteDetails;
	@ApiModelProperty(position=6, value="")
	private AuditDetails auditDetails;
	public int getModuleId() {
		return moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getModuleFeature() {
		return moduleFeature;
	}
	public void setModuleFeature(String moduleFeature) {
		this.moduleFeature = moduleFeature;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public DeleteDetails getDeleteDetails() {
		return deleteDetails;
	}
	public void setDeleteDetails(DeleteDetails deleteDetails) {
		this.deleteDetails = deleteDetails;
	}
	public AuditDetails getAuditDetails() {
		return auditDetails;
	}
	public void setAuditDetails(AuditDetails auditDetails) {
		this.auditDetails = auditDetails;
	}
}

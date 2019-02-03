package com.ashish.cactus.school.admin.input;

import java.util.EnumSet;

public class RoleDetails {
	private int roleId;
	private String roleName;
	private String roleDescription;
	private DeleteDetails deleteDetails;
	private AuditDetails auditDetails;
	private EnumSet<PermissionEnum> permissions;
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
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
	public EnumSet<PermissionEnum> getPermissions() {
		return permissions;
	}
	public void setPermissions(EnumSet<PermissionEnum> permissions) {
		this.permissions = permissions;
	}
}

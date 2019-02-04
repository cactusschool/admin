package com.ashish.cactus.school.admin.input;

import io.swagger.annotations.ApiModelProperty;

import java.util.EnumSet;

public class RoleDetails {
	@ApiModelProperty(position=1, value="")
	private int roleId;
	
	@ApiModelProperty(position=2, value="")
	private String roleName;
	
	@ApiModelProperty(position=3, value="")
	private String roleDescription;
	
	@ApiModelProperty(position=4, value="")
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
	public EnumSet<PermissionEnum> getPermissions() {
		return permissions;
	}
	public void setPermissions(EnumSet<PermissionEnum> permissions) {
		this.permissions = permissions;
	}
}

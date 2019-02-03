package com.ashish.cactus.school.admin.input;

public enum PermissionEnum {
	CREATE("CREATE"),
	READ("READ"),
	UPDATE("UPDATE"),
	DELETE("DELETE");
	
	private String value;
	PermissionEnum(String value) {
		this.value = value;
	}
	
	public String toString() {
		return String.valueOf(value);
	}
}

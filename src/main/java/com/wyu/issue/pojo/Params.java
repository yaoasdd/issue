package com.wyu.issue.pojo;

public class Params {

	private User params;

	public User getParams() {
		return params;
	}

	public void setParams(User params) {
		this.params = params;
	}

	@Override
	public String toString() {
		return "Params [params=" + params + ", getParams()=" + getParams() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}

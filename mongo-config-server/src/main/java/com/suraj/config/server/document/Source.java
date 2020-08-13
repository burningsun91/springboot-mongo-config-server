package com.suraj.config.server.document;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Source implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1302530447290000100L;
	
	private Map<String, Object> user;
	
	public Source() {
		this.user = new HashMap<String, Object>();
	}

	public Source(Map<String, Object> user) {
		this.user = user;
	}

	public Map<String, Object> getUser() {
		return user;
	}

	public void setUser(Map<String, Object> user) {
		this.user = user;
	}
	
	

}

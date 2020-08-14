package com.suraj.config.server.document;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Source implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1302530447290000100L;
	
	private Map<String, Object> properties;
	
	public Source() {
		this.properties = new HashMap<String, Object>();
	}

	public Source(Map<String, Object> properties) {
		this.properties = properties;
	}

	public Map<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}
	
	
	

}

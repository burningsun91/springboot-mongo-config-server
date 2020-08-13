package com.suraj.config.server.document;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PropertySource implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8759752090435988938L;
	
	@Id
	private String _id;

	private String applicationName;
	
	private String label;
	
	private String profile;
	
	private Source source;
	
	public PropertySource() {
		// TODO Auto-generated constructor stub
	}
	
	public PropertySource(String label, String profile, Source source) {
		super();
		this.label = label;
		this.profile = profile;
		this.source = source;
	}


	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public Source getSource() {
		return source;
	}
	public void setSource(Source source) {
		this.source = source;
	}
	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	

}

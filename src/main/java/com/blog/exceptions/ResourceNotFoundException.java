package com.blog.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	public String resourceName;
	public String resourceField;
	public int resource;

	public ResourceNotFoundException(String resourceName, String resourceField, int resource) {
		// super(resourceName + " not found with "+resourceField+ " : "+resource);
		super(String.format("%s not found with %s : %d", resourceName, resourceField, resource));
		this.resourceName = resourceName;
		this.resourceField = resourceField;
		this.resource = resource;
	}

}

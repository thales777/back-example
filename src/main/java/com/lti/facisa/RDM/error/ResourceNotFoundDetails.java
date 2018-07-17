package com.lti.facisa.RDM.error;

public class ResourceNotFoundDetails extends ErrorDetails {
	
	 public static final class Builder {
	        private String name;
	        private int status;
	        private String detail;
	        private String developerMessage;

	        private Builder() {
	        }

	        public static Builder newBuilder() {
	            return new Builder();
	        }

	        public Builder name(String name) {
	            this.name = name;
	            return this;
	        }

	        public Builder status(int status) {
	            this.status = status;
	            return this;
	        }

	        public Builder detail(String detail) {
	            this.detail = detail;
	            return this;
	        }

	        public Builder developerMessage(String developerMessage) {
	            this.developerMessage = developerMessage;
	            return this;
	        }

	        public ResourceNotFoundDetails build() {
	            ResourceNotFoundDetails resourceNotFoundDetails = new ResourceNotFoundDetails();
	            resourceNotFoundDetails.setDeveloperMessage(developerMessage);
	            resourceNotFoundDetails.setName(name);
	            resourceNotFoundDetails.setDetail(detail);
	            resourceNotFoundDetails.setStatus(status);
	            return resourceNotFoundDetails;
	        }
	    }

}

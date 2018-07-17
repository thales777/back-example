package com.lti.facisa.RDM.error;

public class ValidationErrorDetails extends ErrorDetails {

	private String field;
	private String fieldMessage;
	
	 public static final class Builder {
		 
	        private String name;
	        private int status;
	        private String detail;
	        private String developerMessage;
	        private String field;
	        private String fieldMessage;
	        
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

	        public Builder field(String field) {
	            this.field = field;
	            return this;
	        }

	        public Builder fieldMessage(String fieldMessage) {
	            this.fieldMessage = fieldMessage;
	            return this;
	        }
	        
	        public ValidationErrorDetails build() {
	            ValidationErrorDetails validationErrorDetails = new ValidationErrorDetails();
	            validationErrorDetails.setDeveloperMessage(developerMessage);
	            validationErrorDetails.setName(name);
	            validationErrorDetails.setDetail(detail);
	            validationErrorDetails.setStatus(status);
	            validationErrorDetails.fieldMessage = fieldMessage;
	            validationErrorDetails.field = field;
	            return validationErrorDetails;
	       }
	 }

	public String getField() {
		return field;
	}

	public String getFieldMessage() {
		return fieldMessage;
	}	 
}

package com.npopov.philharmonic.impresario.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ImpresarioUpdateRequest {

        @NotBlank(message = "First name cannot be blank")
        @Size(max = 100, message = "First name must not exceed 100 characters")
        private String firstName;

        @Size(max = 100, message = "Last name must not exceed 100 characters")
        private String lastName;

        @Size(max = 200, message = "Organization must not exceed 200 characters")
        private String organization;

        @Size(max = 200, message = "Contact info must not exceed 200 characters")
        private String contactInfo;

        public ImpresarioUpdateRequest() {
        }

        public ImpresarioUpdateRequest(String firstName, String lastName, String organization, String contactInfo) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.organization = organization;
                this.contactInfo = contactInfo;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public String getOrganization() {
                return organization;
        }

        public void setOrganization(String organization) {
                this.organization = organization;
        }

        public String getContactInfo() {
                return contactInfo;
        }

        public void setContactInfo(String contactInfo) {
                this.contactInfo = contactInfo;
        }
}
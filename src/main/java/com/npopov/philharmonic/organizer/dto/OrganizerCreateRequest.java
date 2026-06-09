package com.npopov.philharmonic.organizer.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class OrganizerCreateRequest {

        @NotBlank(message = "Name cannot be blank")
        @Size(max = 100, message = "Name must not exceed 100 characters")
        String name;

        @Size(max = 200, message = "Contact info must not exceed 200 characters")
        String contactInfo;

        @Size(max = 50, message = "Type must not exceed 50 characters")
        String type;

        public OrganizerCreateRequest(String name, String contactInfo, String type) {
                this.name = name;
                this.contactInfo = contactInfo;
                this.type = type;
        }

        public OrganizerCreateRequest() {}

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getContactInfo() {
                return contactInfo;
        }

        public void setContactInfo(String contactInfo) {
                this.contactInfo = contactInfo;
        }

        public String getType() {
                return type;
        }

        public void setType(String type) {
                this.type = type;
        }
}
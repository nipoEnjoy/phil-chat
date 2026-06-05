package com.npopov.philharmonic.artist.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ArtistUpdateRequest {
        @NotBlank(message = "First name cannot be blank")
        @Size(max = 100, message = "First name must not exceed 100 characters")
        String firstName;

        @Size(max = 100, message = "Last name must not exceed 100 characters")
        String lastName;

        @Size(max = 100, message = "Stage name must not exceed 100 characters")
        String stageName;

        @Size(max = 200, message = "Contact info must not exceed 200 characters")
        String contactInfo;

        public ArtistUpdateRequest() {}

        public ArtistUpdateRequest(String firstName, String lastName, String stageName, String contactInfo) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.stageName = stageName;
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

        public String getStageName() {
                return stageName;
        }

        public void setStageName(String stageName) {
                this.stageName = stageName;
        }

        public String getContactInfo() {
                return contactInfo;
        }

        public void setContactInfo(String contactInfo) {
                this.contactInfo = contactInfo;
        }
}
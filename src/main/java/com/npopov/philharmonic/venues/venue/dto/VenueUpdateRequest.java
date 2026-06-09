package com.npopov.philharmonic.venues.venue.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.npopov.philharmonic.venues.cinema.dto.CinemaCreateRequest;
import com.npopov.philharmonic.venues.cinema.dto.CinemaUpdateRequest;
import com.npopov.philharmonic.venues.concert.dto.ConcertVenueCreateRequest;
import com.npopov.philharmonic.venues.concert.dto.ConcertVenueUpdateRequest;
import com.npopov.philharmonic.venues.culturalcentre.dto.CulturalCentreCreateRequest;
import com.npopov.philharmonic.venues.culturalcentre.dto.CulturalCentreUpdateRequest;
import com.npopov.philharmonic.venues.theatre.dto.TheatreCreateRequest;
import com.npopov.philharmonic.venues.theatre.dto.TheatreUpdateRequest;
import com.npopov.philharmonic.venues.varietystage.dto.VarietyStageCreateRequest;
import com.npopov.philharmonic.venues.varietystage.dto.VarietyStageUpdateRequest;
import com.npopov.philharmonic.venues.venue.domain.VenueType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

// Jackson inheritance
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "venueType"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TheatreUpdateRequest.class, name = "THEATRE"),
        @JsonSubTypes.Type(value = CinemaUpdateRequest.class, name = "CINEMA"),
        @JsonSubTypes.Type(value = ConcertVenueUpdateRequest.class, name = "CONCERT_VENUE"),
        @JsonSubTypes.Type(value = VarietyStageUpdateRequest.class, name = "VARIETY_STAGE"),
        @JsonSubTypes.Type(value = CulturalCentreUpdateRequest.class, name = "CULTURAL_CENTRE")
})
public class VenueUpdateRequest {
        @NotBlank(message = "Venue name cannot be blank")
        @Size(max = 100, message = "Venue name must not exceed 100 characters")
        String name;

//        @NotNull(message = "Venue type is required")
//        VenueType venueType;

        @Size(max = 200, message = "Address must not exceed 200 characters")
        String address;

        @Size(max = 100, message = "City must not exceed 100 characters")
        String city;

        @Size(max = 500, message = "Description must not exceed 500 characters")
        String description;

        public VenueUpdateRequest(String name, String address, String city, String description) {
                this.name = name;
//                this.venueType = venueType;
                this.address = address;
                this.city = city;
                this.description = description;
        }

        public VenueUpdateRequest() {
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

//        public VenueType getVenueType() {
//                return venueType;
//        }
//
//        public void setVenueType(VenueType venueType) {
//                this.venueType = venueType;
//        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public String getCity() {
                return city;
        }

        public void setCity(String city) {
                this.city = city;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }
}
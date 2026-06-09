package com.npopov.philharmonic.venues.cinema.dto;

import com.npopov.philharmonic.venues.venue.domain.VenueType;
import com.npopov.philharmonic.venues.venue.dto.VenueCreateRequest;
import com.npopov.philharmonic.venues.venue.dto.VenueUpdateRequest;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class CinemaUpdateRequest extends VenueUpdateRequest {

    @NotNull(message = "Screen width cannot be null")
    @Positive(message = "Screen width should be a positive number")
    private Integer screenWidthMm;

    @NotNull(message = "Screen height cannot be null")
    @Positive(message = "Screen height should be a positive number")
    private Integer screenHeightMm;

    @Positive(message = "Screen diagonal should be a positive number")
    private Integer screenDiagonalMm;

    @Size(max = 50, message = "Aspect ration must not exceed 50 characters")
    private String screenAspectRatio;

    public CinemaUpdateRequest(String name,
                               String address, String city, String description,
                               Integer screenWidthMm, Integer screenHeightMm,
                               Integer screenDiagonalMm, String screenAspectRatio) {
        super(name, address, city, description);
        this.screenWidthMm = screenWidthMm;
        this.screenHeightMm = screenHeightMm;
        this.screenDiagonalMm = screenDiagonalMm;
        this.screenAspectRatio = screenAspectRatio;
    }

    public Integer getScreenWidthMm() {
        return screenWidthMm;
    }

    public void setScreenWidthMm(Integer screenWidthMm) {
        this.screenWidthMm = screenWidthMm;
    }

    public Integer getScreenHeightMm() {
        return screenHeightMm;
    }

    public void setScreenHeightMm(Integer screenHeightMm) {
        this.screenHeightMm = screenHeightMm;
    }

    public Integer getScreenDiagonalMm() {
        return screenDiagonalMm;
    }

    public void setScreenDiagonalMm(Integer screenDiagonalMm) {
        this.screenDiagonalMm = screenDiagonalMm;
    }

    public String getScreenAspectRatio() {
        return screenAspectRatio;
    }

    public void setScreenAspectRatio(String screenAspectRatio) {
        this.screenAspectRatio = screenAspectRatio;
    }
}

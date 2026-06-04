package com.npopov.philharmonic.venue.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "cinema")
@PrimaryKeyJoinColumn(name = "id")
public class Cinema extends Venue {

    @Column(name = "screen_width_mm", nullable = false)
    private Integer screenWidthMm;

    @Column(name = "screen_height_mm", nullable = false)
    private Integer screenHeightMm;

    @Column(name = "screen_diagonal_mm")
    private Integer screenDiagonalMm;

    @Column(name = "screen_aspect_ratio")
    private String screenAspectRatio;

    public Cinema() {}

    public Cinema(String name, VenueType venueType, String address, String city, String description, Integer screenWidthMm, Integer screenHeightMm, Integer screenDiagonalMm, String screenAspectRatio) {
        super(name, venueType, address, city, description);
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
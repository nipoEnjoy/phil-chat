package com.npopov.philharmonic.artist.dto;

import com.npopov.philharmonic.genre.dto.GenreResponse;

import java.time.LocalDateTime;
import java.util.List;

public class ArtistResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String stageName;
    private String contactInfo;
    private List<GenreResponse> genres;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ArtistResponse() {}

    public ArtistResponse(Long id, String firstName, String lastName, String stageName, String contactInfo, List<GenreResponse> genres, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.stageName = stageName;
        this.contactInfo = contactInfo;
        this.genres = genres;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<GenreResponse> getGenres() {
        return genres;
    }

    public void setGenres(List<GenreResponse> genres) {
        this.genres = genres;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
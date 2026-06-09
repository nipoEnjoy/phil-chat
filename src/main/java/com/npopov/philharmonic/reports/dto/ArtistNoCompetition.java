package com.npopov.philharmonic.reports.dto;

public class ArtistNoCompetition {
    private Long id;
    private String firstName;
    private String lastName;
    private String stageName;

    public ArtistNoCompetition(Long id, String firstName, String lastName, String stageName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.stageName = stageName;
    }

    public ArtistNoCompetition() {}

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
}

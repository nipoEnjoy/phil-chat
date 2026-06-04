package com.npopov.philharmonic.impresario.domain;

import com.npopov.philharmonic.artist.domain.ArtistImpresario;
import com.npopov.philharmonic.shared.domain.Auditable;
import com.npopov.philharmonic.shared.domain.HasId;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "impresario")
public class Impresario extends Auditable implements HasId<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "organization")
    private String organization;

    @Column(name = "contact_info")
    private String contactInfo;

    @OneToMany(mappedBy = "impresario", fetch = FetchType.LAZY)
    private Set<ArtistImpresario> artistImpresarios;

    public Impresario() {}

    public Impresario(String firstName, String lastName, String organization, String contactInfo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.organization = organization;
        this.contactInfo = contactInfo;
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

    public Set<ArtistImpresario> getArtistImpresarios() {
        return artistImpresarios;
    }

    public void setArtistImpresarios(Set<ArtistImpresario> artistImpresarios) {
        this.artistImpresarios = artistImpresarios;
    }
}
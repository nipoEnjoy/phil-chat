package com.npopov.philharmonic.artist.dto;

import com.npopov.philharmonic.artist.domain.Artist;
import com.npopov.philharmonic.identity.user.domain.User;
import com.npopov.philharmonic.identity.user.dto.UserResponse;

public final class ArtistMapper {
    private ArtistMapper() {}

    public static Artist toArtist(ArtistCreateRequest request) {
        if (request == null) return new Artist();
        return new Artist(
                request.firstName(),
                request.lastName(),
                request.stageName(),
                request.contactInfo()
        );
    }

    public static Artist toArtist(ArtistUpdateRequest request) {
        if (request == null) return new Artist();
        return new Artist(
                request.firstName(),
                request.lastName(),
                request.stageName(),
                request.contactInfo()
        );
    }

    public static ArtistResponse toResponse(Artist artist) {
        if (artist == null) return null;
        return new ArtistResponse(
                artist.getId(),
                artist.getFirstName(),
                artist.getLastName(),
                artist.getStageName(),
                artist.getContactInfo(),
                artist.getCreatedAt(),
                artist.getUpdatedAt()
        );
    }
}

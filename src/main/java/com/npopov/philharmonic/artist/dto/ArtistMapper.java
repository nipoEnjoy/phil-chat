package com.npopov.philharmonic.artist.dto;

import com.npopov.philharmonic.artist.domain.Artist;
import com.npopov.philharmonic.identity.user.domain.User;
import com.npopov.philharmonic.identity.user.dto.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class ArtistMapper {
    private ArtistMapper() {}

    public Artist toArtistFromCreate(ArtistCreateRequest request) {
        if (request == null) return new Artist();
        return new Artist(
                request.getFirstName(),
                request.getLastName(),
                request.getStageName(),
                request.getContactInfo()
        );
    }

    public Artist toArtistFromUpdate(ArtistUpdateRequest request) {
        if (request == null) return new Artist();
        return new Artist(
                request.getFirstName(),
                request.getLastName(),
                request.getStageName(),
                request.getContactInfo()
        );
    }

    public ArtistResponse toResponse(Artist artist) {
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

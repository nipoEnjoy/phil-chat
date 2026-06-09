package com.npopov.philharmonic.organizer.dto;

import com.npopov.philharmonic.organizer.domain.Organizer;
import org.springframework.stereotype.Component;

@Component
public class OrganizerMapper {

    public Organizer toOrganizerFromCreate(OrganizerCreateRequest request) {
        return new Organizer(
                request.getName(),
                request.getContactInfo(),
                request.getType()
        );
    }

    public Organizer toOrganizerFromUpdate(OrganizerUpdateRequest request) {
        return new Organizer(
                request.getName(),
                request.getContactInfo(),
                request.getType()
        );
    }

    public OrganizerResponse toResponse(Organizer organizer) {
        return new OrganizerResponse(
                organizer.getId(),
                organizer.getName(),
                organizer.getContactInfo(),
                organizer.getType(),
                organizer.getCreatedAt(),
                organizer.getUpdatedAt()
        );
    }
}

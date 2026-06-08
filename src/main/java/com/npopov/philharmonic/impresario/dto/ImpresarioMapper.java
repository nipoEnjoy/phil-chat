package com.npopov.philharmonic.impresario.dto;

import com.npopov.philharmonic.impresario.domain.Impresario;
import org.springframework.stereotype.Component;

@Component
public class ImpresarioMapper {

    public Impresario toImpresarioFromCreate(ImpresarioCreateRequest request) {
        return new Impresario(
                request.getFirstName(),
                request.getLastName(),
                request.getOrganization(),
                request.getContactInfo()
        );
    }

    public Impresario toImpresarioFromUpdate(ImpresarioUpdateRequest request) {
        return new Impresario(
                request.getFirstName(),
                request.getLastName(),
                request.getOrganization(),
                request.getContactInfo()
        );
    }

    public ImpresarioResponse toResponse(Impresario impresario) {
        return new ImpresarioResponse(
                impresario.getId(),
                impresario.getFirstName(),
                impresario.getLastName(),
                impresario.getOrganization(),
                impresario.getContactInfo(),
                impresario.getCreatedAt(),
                impresario.getUpdatedAt()
        );
    }
}

package com.npopov.philharmonic.venues.varietystage.dto;

import com.npopov.philharmonic.venues.varietystage.domain.VarietyStage;
import org.springframework.stereotype.Component;

@Component
public class VarietyStageMapper {

    public VarietyStage toVarietyStageFromCreate(VarietyStageCreateRequest request) {
        return new VarietyStage(
                request.getName(),
                request.getAddress(),
                request.getCity(),
                request.getDescription(),
                request.getGenreFocus()
        );
    }

    public VarietyStage toVarietyStageFromUpdate(VarietyStageUpdateRequest request) {
        return new VarietyStage(
                request.getName(),
                request.getAddress(),
                request.getCity(),
                request.getDescription(),
                request.getGenreFocus()
        );
    }

    public VarietyStageResponse toResponse(VarietyStage varietyStage) {
        return new VarietyStageResponse(
                varietyStage.getId(),
                varietyStage.getName(),
                varietyStage.getAddress(),
                varietyStage.getCity(),
                varietyStage.getDescription(),
                varietyStage.getCreatedAt(),
                varietyStage.getUpdatedAt(),
                varietyStage.getGenreFocus()
        );
    }
}

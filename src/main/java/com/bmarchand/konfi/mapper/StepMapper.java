package com.bmarchand.konfi.mapper;

import com.bmarchand.konfi.controller.request.StepRequest;
import com.bmarchand.konfi.repository.entities.StepEntity;
import com.bmarchand.konfi.service.model.Step;
import org.springframework.stereotype.Component;

@Component
public class StepMapper {

    StepEntity toEntity(Step dto) {
        return StepEntity
                .builder()
                .id(dto.getId())
                .description(dto.getDescription())
                .stepOrder(dto.getStepOrder())
                .build();
    }

    Step toDto(StepEntity entity) {
        return Step
                .builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .stepOrder(entity.getStepOrder())
                .build();
    }

    Step toStep(StepRequest request) {
        return Step
                .builder()
                .description(request.getDescription())
                .stepOrder(request.getStepOrder())
                .build();
    }
}

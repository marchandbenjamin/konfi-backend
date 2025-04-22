package com.bmarchand.konfi.mapper;

import com.bmarchand.konfi.controller.request.StepRequest;
import com.bmarchand.konfi.repository.entities.StepEntity;
import com.bmarchand.konfi.service.model.Step;

public interface StepMapper {
    Step toDto(StepEntity entity);
    StepEntity toEntity(Step dto);
    Step toStep(StepRequest request);
}

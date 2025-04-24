package com.bmarchand.konfi.controller.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StepRequest {
    private String description;
    private int stepOrder;
}

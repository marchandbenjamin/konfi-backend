package com.bmarchand.konfi.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Step {
    private Long id;
    private String description;
    private Integer stepOrder;
}

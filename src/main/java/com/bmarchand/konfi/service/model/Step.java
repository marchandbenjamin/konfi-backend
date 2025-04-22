package com.bmarchand.konfi.service.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Step {
    private Long id;
    private String description;
    private Integer stepOrder;
}

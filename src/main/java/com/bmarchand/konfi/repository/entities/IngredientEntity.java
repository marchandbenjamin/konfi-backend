package com.bmarchand.konfi.repository.entities;

import com.bmarchand.konfi.service.model.Recipe;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class IngredientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private BigDecimal quantity;

    private String unit;

    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = false)
    private RecipeEntity recipe;

}

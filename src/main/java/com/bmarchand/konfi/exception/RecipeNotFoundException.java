package com.bmarchand.konfi.exception;


public class RecipeNotFoundException extends RuntimeException {

    public RecipeNotFoundException(Long id) {
        super("Recipe not found with id: " + id);
    }

    public RecipeNotFoundException(String message) {
        super(message);
    }
}
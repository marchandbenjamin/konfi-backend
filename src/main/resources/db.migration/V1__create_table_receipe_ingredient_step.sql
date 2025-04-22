CREATE TABLE recipe (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
);

CREATE TABLE ingredient (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    quantity DECIMAL(10, 2),
    unit VARCHAR(50),
    recipe_id INT,
    FOREIGN KEY (recipe_id) REFERENCES recipe(id) ON DELETE CASCADE
);

CREATE TABLE step (
    id SERIAL PRIMARY KEY,
    description TEXT NOT NULL,
    step_order INT NOT NULL,
    recipe_id INT,
    FOREIGN KEY (recipe_id) REFERENCES recipe(id) ON DELETE CASCADE,
    CONSTRAINT step_order_unique UNIQUE (recipe_id, step_order)
);

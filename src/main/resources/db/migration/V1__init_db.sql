CREATE TABLE Client (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(200) CHECK (LENGTH(name) >= 3 AND LENGTH(name) <= 200) NOT NULL
);

CREATE TABLE Planet (
    id VARCHAR(10) PRIMARY KEY CHECK (id ~ '^[A-Z0-9]+$') NOT NULL,
    name VARCHAR(500) CHECK (LENGTH(name) >= 1 AND LENGTH(name) <= 500) NOT NULL
);

CREATE TABLE Ticket (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    client_id BIGINT NOT NULL,
    from_planet_id VARCHAR(10) NOT NULL,
    to_planet_id VARCHAR(10) NOT NULL,
    CONSTRAINT fk_client_id FOREIGN KEY  (client_id) REFERENCES Client(id),
    CONSTRAINT fk_from_planet_id FOREIGN KEY  (from_planet_id) REFERENCES Planet(id),
    CONSTRAINT fk_to_planet_id FOREIGN KEY  (to_planet_id) REFERENCES Planet(id)
);
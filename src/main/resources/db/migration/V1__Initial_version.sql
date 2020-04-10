CREATE TABLE users
(
    id      SERIAL PRIMARY KEY,
    name varchar(30) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    created_at TIMESTAMP
);

CREATE TABLE locations (
    id serial PRIMARY KEY,
    name VARCHAR (30) NOT NULL,
    image_url VARCHAR,
    created_at TIMESTAMP
);

CREATE TABLE travels (
    id serial PRIMARY KEY,
    user_id int REFERENCES users(id),
    location_id int REFERENCES locations(id),
    price MONEY NOT NULL,
    scheduled_to TIMESTAMP,
    created_at TIMESTAMP
);

CREATE TABLE products (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    created_by VARCHAR(100) NOT NULL,
    created_on timestamp NOT NULL,
    updated_by VARCHAR(255),
    updated_on timestamp,
    version INT,
    brand VARCHAR(255),
    colour VARCHAR(255),
    description VARCHAR(255),
    price VARCHAR(25),
    title VARCHAR(255)
);

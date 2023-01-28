CREATE TABLE prices (
    id SERIAL PRIMARY KEY,
    brand_id INT NOT NULL,
    start_date date NOT NULL,
    end_date date,
    price_list INT NOT NULL,
    product_id INT NOT NULL,
    priority INT NOT NULL,
    price INT NOT NULL,
    curr varchar(255) NOT NULL
);

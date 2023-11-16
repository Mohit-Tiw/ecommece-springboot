CREATE TABLE categories (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(255) NOT NULL,
                            description TEXT
);

CREATE TABLE products (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          description TEXT,
                          price DECIMAL(10, 2) NOT NULL,
                          category_id INTEGER REFERENCES categories(id),
                          stock_quantity INTEGER NOT NULL
);


CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(255) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       email VARCHAR(255) UNIQUE NOT NULL
);
CREATE TABLE carts (
                       id SERIAL PRIMARY KEY,
                       user_id INTEGER REFERENCES users(id),
                       created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW()
);

CREATE TABLE cart_items (
                            id SERIAL PRIMARY KEY,
                            cart_id INTEGER REFERENCES carts(id),
                            product_id INTEGER REFERENCES products(id),
                            quantity INTEGER NOT NULL,
                            added_at TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW()
);
CREATE TABLE orders (
                        id SERIAL PRIMARY KEY,
                        user_id INTEGER REFERENCES users(id),
                        order_date TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
                        status VARCHAR(50) DEFAULT 'PENDING'
);

CREATE TABLE order_items (
                             id SERIAL PRIMARY KEY,
                             order_id INTEGER REFERENCES orders(id),
                             product_id INTEGER REFERENCES products(id),
                             quantity INTEGER NOT NULL,
                             price_at_purchase DECIMAL(10, 2)
);

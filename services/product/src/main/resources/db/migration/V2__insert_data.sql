-- Insert data into category table
INSERT INTO category (id, name, description) VALUES
                                                 (nextval('category_seq'), 'Electronics', 'Devices and gadgets'),
                                                 (nextval('category_seq'), 'Clothing', 'Apparel and accessories'),
                                                 (nextval('category_seq'), 'Books', 'Printed and digital books');

-- Insert data into product table
INSERT INTO product (id, name, description, available_quantity, price, category_id) VALUES
                                                                                        (nextval('product_seq'), 'Smartphone', 'Latest model smartphone', 100.0, 699.99, (SELECT id FROM category WHERE name = 'Electronics')),
                                                                                        (nextval('product_seq'), 'T-Shirt', 'Cotton graphic tee', 200.0, 19.99, (SELECT id FROM category WHERE name = 'Clothing')),
                                                                                        (nextval('product_seq'), 'Novel', 'Bestselling fiction book', 50.0, 14.99, (SELECT id FROM category WHERE name = 'Books')),
                                                                                        (nextval('product_seq'), 'Laptop', 'High-performance laptop', 30.0, 1299.99, (SELECT id FROM category WHERE name = 'Electronics')),
                                                                                        (nextval('product_seq'), 'Jeans', 'Blue denim jeans', 150.0, 49.99, (SELECT id FROM category WHERE name = 'Clothing'));
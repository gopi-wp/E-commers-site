INSERT INTO product (category, name, price, discount, image) VALUES
('milk','Full Cream Milk',60,5,'https://images.unsplash.com/...milk...'),
('milk','Toned Milk',50,0,'https://images.unsplash.com/...milk...'),
('milk','Curd',40,10,'https://images.unsplash.com/...milk...'),
('sweets','Kaju Katli',250,10,'https://images.unsplash.com/...sweets...'),
('sweets','Gulab Jamun',180,5,'https://images.unsplash.com/...sweets...'),
('vegetables','Tomatoes (1kg)',40,5,'https://images.unsplash.com/...veg...'),
('pooja','Incense Sticks',50,8,'https://images.unsplash.com/...pooja...');

-- sample user (password: 'password' encoded later by bcrypt during runtime or store pre-encoded)
INSERT INTO users (username, password, role) VALUES ('admin', '$2a$10$DUMMY_HASH_REPLACE', 'ROLE_ADMIN');

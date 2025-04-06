-- Add order_number column to orders table
ALTER TABLE orders ADD COLUMN client_secret VARCHAR(255) NOT NULL;
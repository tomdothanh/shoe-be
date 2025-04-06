-- Add order_number column to orders table
ALTER TABLE orders ADD COLUMN order_number VARCHAR(20) NOT NULL UNIQUE;

-- Create index for faster lookups
CREATE INDEX idx_orders_order_number ON orders(order_number); 
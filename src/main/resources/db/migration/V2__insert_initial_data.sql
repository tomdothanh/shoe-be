-- Insert 10 shoe products
INSERT INTO products (id, name, description, price, image_url) VALUES
-- Nike Air Force 1
('11111111-1111-1111-1111-111111111111', 'Nike Air Force 1', 'Classic white sneakers with iconic design', 110.00, 'https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/20547d52-3e1b-4c3d-b917-f0d7e0eb8bdf/custom-nike-air-force-1-low-by-you-shoes.png'),
-- Adidas Ultraboost
('22222222-2222-2222-2222-222222222222', 'Adidas Ultraboost', 'Premium running shoes with responsive cushioning', 190.00, 'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/f338d78c641d424b8aafaf37017909f8_9366/Giay_Ultrabounce_DJen_HP5797_01_standard.jpg'),
-- New Balance 990v5
('33333333-3333-3333-3333-333333333333', 'New Balance 990v5', 'Premium running shoes with ENCAP midsole', 175.00, 'https://nb.scene7.com/is/image/NB/w990gl5_nb_05_i?$dw_detail_main_lg$&bgc=f1f1f1&layer=1&bgcolor=f1f1f1&blendMode=mult&scale=10&wid=1600&hei=1600'),
-- Converse Chuck Taylor
('44444444-4444-4444-4444-444444444444', 'Converse Chuck Taylor', 'Classic canvas sneakers', 65.00, 'https://www.converse.vn/media/catalog/product/0/8/0882-CON162050C000005-1.jpg'),
-- Puma RS-X
('55555555-5555-5555-5555-555555555555', 'Puma RS-X', 'Chunky sneakers with retro design', 100.00, 'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_2000,h_2000/global/390776/52/sv01/fnd/EEA/fmt/png/RS-X-Efekt-PRM-Sneakers'),
-- Vans Old Skool
('66666666-6666-6666-6666-666666666666', 'Vans Old Skool', 'Classic skate shoes with side stripe', 60.00, 'https://bizweb.dktcdn.net/100/140/774/products/vans-old-skool-black-white-vn000d3hy28-2.jpg?v=1625905148527'),
-- Reebok Classic
('77777777-7777-7777-7777-777777777777', 'Reebok Classic', 'Retro leather sneakers', 80.00, 'https://www.reebok.com/cdn/shop/files/100008493_SLC_eCom-tif.png?v=1736438133'),
-- Asics Gel-Kayano
('88888888-8888-8888-8888-888888888888', 'Asics Gel-Kayano', 'Premium running shoes with GEL technology', 160.00, 'https://images.asics.com/is/image/asics/1201A019_005_SR_RT_GLB?$sfcc-product$'),
-- Under Armour HOVR
('99999999-9999-9999-9999-999999999999', 'Under Armour HOVR', 'Energy return running shoes', 120.00, 'https://about.underarmour.com/content/ua/about/na/us/en/stories/2018/11/ua-hovr-guardian/_jcr_content/root/container/image.coreimg.jpg'),
-- Fila Disruptor
('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 'Fila Disruptor', 'Chunky platform sneakers', 90.00, 'https://fila-vietnam.com.vn/wp-content/uploads/2024/10/fila-viet-nam-x-barneys-new-york-fila-disruptor-2-exp-5xm01776e-100-5-jpeg.jpg');

-- Insert variants for each product (3 colors, sizes 7-10)
-- Nike Air Force 1 variants
INSERT INTO variants (id, product_id, color, size, quantity, image_urls, price) VALUES
('11111111-1111-1111-1111-111111111111', '11111111-1111-1111-1111-111111111111', 'White', '7', 10, '["https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/20547d52-3e1b-4c3d-b917-f0d7e0eb8bdf/custom-nike-air-force-1-low-by-you-shoes.png"]', 110.00),
('11111111-1111-1111-1111-111111111112', '11111111-1111-1111-1111-111111111111', 'Black', '7', 10, '["https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/20547d52-3e1b-4c3d-b917-f0d7e0eb8bdf/custom-nike-air-force-1-low-by-you-shoes.png"]', 110.00),
('11111111-1111-1111-1111-111111111113', '11111111-1111-1111-1111-111111111111', 'Red', '7', 10, '["https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/20547d52-3e1b-4c3d-b917-f0d7e0eb8bdf/custom-nike-air-force-1-low-by-you-shoes.png"]', 110.00);

-- Adidas Ultraboost variants
INSERT INTO variants (id, product_id, color, size, quantity, image_urls, price) VALUES
('22222222-2222-2222-2222-222222222221', '22222222-2222-2222-2222-222222222222', 'Black', '7', 10, '["https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/f338d78c641d424b8aafaf37017909f8_9366/Giay_Ultrabounce_DJen_HP5797_01_standard.jpg"]', 190.00),
('22222222-2222-2222-2222-222222222222', '22222222-2222-2222-2222-222222222222', 'White', '7', 10, '["https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/f338d78c641d424b8aafaf37017909f8_9366/Giay_Ultrabounce_DJen_HP5797_01_standard.jpg"]', 190.00),
('22222222-2222-2222-2222-222222222223', '22222222-2222-2222-2222-222222222222', 'Blue', '7', 10, '["https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/f338d78c641d424b8aafaf37017909f8_9366/Giay_Ultrabounce_DJen_HP5797_01_standard.jpg"]', 190.00);

-- New Balance 990v5 variants
INSERT INTO variants (id, product_id, color, size, quantity, image_urls, price) VALUES
('33333333-3333-3333-3333-333333333331', '33333333-3333-3333-3333-333333333333', 'Grey', '7', 10, '["https://nb.scene7.com/is/image/NB/w990gl5_nb_05_i?$dw_detail_main_lg$&bgc=f1f1f1&layer=1&bgcolor=f1f1f1&blendMode=mult&scale=10&wid=1600&hei=1600"]', 175.00),
('33333333-3333-3333-3333-333333333332', '33333333-3333-3333-3333-333333333333', 'Black', '7', 10, '["https://nb.scene7.com/is/image/NB/w990gl5_nb_05_i?$dw_detail_main_lg$&bgc=f1f1f1&layer=1&bgcolor=f1f1f1&blendMode=mult&scale=10&wid=1600&hei=1600"]', 175.00),
('33333333-3333-3333-3333-333333333333', '33333333-3333-3333-3333-333333333333', 'Navy', '7', 10, '["https://nb.scene7.com/is/image/NB/w990gl5_nb_05_i?$dw_detail_main_lg$&bgc=f1f1f1&layer=1&bgcolor=f1f1f1&blendMode=mult&scale=10&wid=1600&hei=1600"]', 175.00);

-- Converse Chuck Taylor variants
INSERT INTO variants (id, product_id, color, size, quantity, image_urls, price) VALUES
('44444444-4444-4444-4444-444444444441', '44444444-4444-4444-4444-444444444444', 'Black', '7', 10, '["https://www.converse.vn/media/catalog/product/0/8/0882-CON162050C000005-1.jpg"]', 65.00),
('44444444-4444-4444-4444-444444444442', '44444444-4444-4444-4444-444444444444', 'White', '7', 10, '["https://www.converse.vn/media/catalog/product/0/8/0882-CON162050C000005-1.jpg"]', 65.00),
('44444444-4444-4444-4444-444444444443', '44444444-4444-4444-4444-444444444444', 'Red', '7', 10, '["https://www.converse.vn/media/catalog/product/0/8/0882-CON162050C000005-1.jpg"]', 65.00);

-- Puma RS-X variants
INSERT INTO variants (id, product_id, color, size, quantity, image_urls, price) VALUES
('55555555-5555-5555-5555-555555555551', '55555555-5555-5555-5555-555555555555', 'Black/White', '7', 10, '["https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_2000,h_2000/global/390776/52/sv01/fnd/EEA/fmt/png/RS-X-Efekt-PRM-Sneakers"]', 100.00),
('55555555-5555-5555-5555-555555555552', '55555555-5555-5555-5555-555555555555', 'Blue/Red', '7', 10, '["https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_2000,h_2000/global/390776/52/sv01/fnd/EEA/fmt/png/RS-X-Efekt-PRM-Sneakers"]', 100.00),
('55555555-5555-5555-5555-555555555553', '55555555-5555-5555-5555-555555555555', 'Grey/Orange', '7', 10, '["https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_2000,h_2000/global/390776/52/sv01/fnd/EEA/fmt/png/RS-X-Efekt-PRM-Sneakers"]', 100.00);

-- Vans Old Skool variants
INSERT INTO variants (id, product_id, color, size, quantity, image_urls, price) VALUES
('66666666-6666-6666-6666-666666666661', '66666666-6666-6666-6666-666666666666', 'Black/White', '7', 10, '["https://bizweb.dktcdn.net/100/140/774/products/vans-old-skool-black-white-vn000d3hy28-2.jpg?v=1625905148527"]', 60.00),
('66666666-6666-6666-6666-666666666662', '66666666-6666-6666-6666-666666666666', 'Red/White', '7', 10, '["https://bizweb.dktcdn.net/100/140/774/products/vans-old-skool-black-white-vn000d3hy28-2.jpg?v=1625905148527"]', 60.00),
('66666666-6666-6666-6666-666666666663', '66666666-6666-6666-6666-666666666666', 'Blue/White', '7', 10, '["https://bizweb.dktcdn.net/100/140/774/products/vans-old-skool-black-white-vn000d3hy28-2.jpg?v=1625905148527"]', 60.00);

-- Reebok Classic variants
INSERT INTO variants (id, product_id, color, size, quantity, image_urls, price) VALUES
('77777777-7777-7777-7777-777777777771', '77777777-7777-7777-7777-777777777777', 'White', '7', 10, '["https://www.reebok.com/cdn/shop/files/100008493_SLC_eCom-tif.png?v=1736438133"]', 80.00),
('77777777-7777-7777-7777-777777777772', '77777777-7777-7777-7777-777777777777', 'Black', '7', 10, '["https://www.reebok.com/cdn/shop/files/100008493_SLC_eCom-tif.png?v=1736438133"]', 80.00),
('77777777-7777-7777-7777-777777777773', '77777777-7777-7777-7777-777777777777', 'Navy', '7', 10, '["https://www.reebok.com/cdn/shop/files/100008493_SLC_eCom-tif.png?v=1736438133"]', 80.00);

-- Asics Gel-Kayano variants
INSERT INTO variants (id, product_id, color, size, quantity, image_urls, price) VALUES
('88888888-8888-8888-8888-888888888881', '88888888-8888-8888-8888-888888888888', 'Black/Red', '7', 10, '["https://images.asics.com/is/image/asics/1201A019_005_SR_RT_GLB?$sfcc-product$"]', 160.00),
('88888888-8888-8888-8888-888888888882', '88888888-8888-8888-8888-888888888888', 'White/Blue', '7', 10, '["https://images.asics.com/is/image/asics/1201A019_005_SR_RT_GLB?$sfcc-product$"]', 160.00),
('88888888-8888-8888-8888-888888888883', '88888888-8888-8888-8888-888888888888', 'Grey/Orange', '7', 10, '["https://images.asics.com/is/image/asics/1201A019_005_SR_RT_GLB?$sfcc-product$"]', 160.00);

-- Under Armour HOVR variants
INSERT INTO variants (id, product_id, color, size, quantity, image_urls, price) VALUES
('99999999-9999-9999-9999-999999999991', '99999999-9999-9999-9999-999999999999', 'Black', '7', 10, '["https://about.underarmour.com/content/ua/about/na/us/en/stories/2018/11/ua-hovr-guardian/_jcr_content/root/container/image.coreimg.jpg"]', 120.00),
('99999999-9999-9999-9999-999999999992', '99999999-9999-9999-9999-999999999999', 'White', '7', 10, '["https://about.underarmour.com/content/ua/about/na/us/en/stories/2018/11/ua-hovr-guardian/_jcr_content/root/container/image.coreimg.jpg"]', 120.00),
('99999999-9999-9999-9999-999999999993', '99999999-9999-9999-9999-999999999999', 'Red', '7', 10, '["https://about.underarmour.com/content/ua/about/na/us/en/stories/2018/11/ua-hovr-guardian/_jcr_content/root/container/image.coreimg.jpg"]', 120.00);

-- Fila Disruptor variants
INSERT INTO variants (id, product_id, color, size, quantity, image_urls, price) VALUES
('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaa1', 'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 'White', '7', 10, '["https://fila-vietnam.com.vn/wp-content/uploads/2024/10/fila-viet-nam-x-barneys-new-york-fila-disruptor-2-exp-5xm01776e-100-5-jpeg.jpg"]', 90.00),
('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaa2', 'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 'Black', '7', 10, '["https://fila-vietnam.com.vn/wp-content/uploads/2024/10/fila-viet-nam-x-barneys-new-york-fila-disruptor-2-exp-5xm01776e-100-5-jpeg.jpg"]', 90.00),
('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaa3', 'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 'Pink', '7', 10, '["https://fila-vietnam.com.vn/wp-content/uploads/2024/10/fila-viet-nam-x-barneys-new-york-fila-disruptor-2-exp-5xm01776e-100-5-jpeg.jpg"]', 90.00); 
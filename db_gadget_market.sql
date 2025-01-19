-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 19, 2025 at 08:26 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_gadget_market`
--

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `category_id` int(1) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`category_id`, `name`) VALUES
(1, 'Flagship Phone'),
(2, 'Mid Range Phone'),
(3, 'Entry Level Phone');

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE `city` (
  `city_id` int(1) NOT NULL,
  `city_name` varchar(100) NOT NULL,
  `province_id` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `favorites`
--

CREATE TABLE `favorites` (
  `favorite_id` int(1) NOT NULL,
  `user_id` int(1) NOT NULL,
  `product_id` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `order_id` int(1) NOT NULL,
  `user_id` int(1) NOT NULL,
  `order_date` datetime NOT NULL,
  `payment_due` datetime NOT NULL,
  `payment_token` varchar(255) NOT NULL,
  `payment_url` varchar(255) NOT NULL,
  `payment_status` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `base_total_price` decimal(16,2) NOT NULL,
  `tax_amount` decimal(16,2) NOT NULL,
  `tax_percent` decimal(16,2) NOT NULL,
  `discount_amount` decimal(16,2) NOT NULL,
  `discount_percent` decimal(16,2) NOT NULL,
  `shipping_cost` decimal(16,2) NOT NULL,
  `grand_total` decimal(16,2) NOT NULL,
  `note` text NOT NULL,
  `customer_first_name` varchar(255) NOT NULL,
  `customer_last_name` varchar(255) NOT NULL,
  `customer_address1` varchar(255) NOT NULL,
  `customer_address2` varchar(255) NOT NULL,
  `customer_phone` varchar(255) NOT NULL,
  `customer_email` varchar(255) NOT NULL,
  `customer_city_id` varchar(255) NOT NULL,
  `customer_province_id` varchar(255) NOT NULL,
  `customer_postcode` int(1) NOT NULL,
  `shipping_courier` varchar(255) NOT NULL,
  `shipping_service_name` varchar(255) NOT NULL,
  `approved_by` int(1) NOT NULL,
  `approved_at` datetime NOT NULL,
  `cancelled_at` datetime NOT NULL,
  `cancelled_by` int(1) NOT NULL,
  `cancellation_note` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `order_items`
--

CREATE TABLE `order_items` (
  `order_id` int(1) NOT NULL,
  `product_id` int(1) NOT NULL,
  `quantity` tinyint(4) DEFAULT NULL,
  `weight` smallint(6) DEFAULT NULL,
  `discount_percent` tinyint(4) DEFAULT NULL,
  `discount_amount` decimal(16,2) DEFAULT NULL,
  `base_price` decimal(16,2) DEFAULT NULL,
  `base_total` decimal(16,2) DEFAULT NULL,
  `tax_percent` tinyint(4) DEFAULT NULL,
  `tax_amount` decimal(16,2) DEFAULT NULL,
  `subtotal` decimal(16,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE `payments` (
  `Payment_id` int(1) NOT NULL,
  `Order_id` int(1) NOT NULL,
  `Number` varchar(255) NOT NULL,
  `Amount` decimal(16,2) NOT NULL,
  `Method` enum('Bayar di Tempat','Transfer Bank','Dompet Digital','') NOT NULL,
  `Status` varchar(255) NOT NULL,
  `Token` varchar(255) NOT NULL,
  `Payloads` longtext NOT NULL,
  `Payment_type` varchar(255) NOT NULL,
  `Va_number` varchar(255) NOT NULL,
  `Vendor_name` varchar(255) NOT NULL,
  `Biller_code` varchar(255) NOT NULL,
  `Bill_key` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `product_id` int(1) NOT NULL,
  `quantity` int(1) NOT NULL,
  `weight` int(1) NOT NULL,
  `description` text NOT NULL,
  `category_id` int(1) NOT NULL,
  `price` int(1) NOT NULL,
  `name` varchar(100) NOT NULL,
  `gambar` varchar(100) NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`product_id`, `quantity`, `weight`, `description`, `category_id`, `price`, `name`, `gambar`, `status`) VALUES
(2, 10, 231, '<html>\r\nLayar\r\n<br/>Layar Super Retina XDR\r\n<br/>Layar OLED menyeluruh 6,1 inci (diagonal)\r\n<br/>Resolusi 2556 x 1179 piksel pada 460 ppi\r\n\r\n<br/>Chip\r\n<br/>Chip A18\r\n\r\n<br/>Perekaman Video\r\n<br/>Perekaman video Dolby Vision 4K pada <br/>kecepatan 24 fps, 25 fps, 30 fps, <br/>atau 60 fps\r\n</html>', 1, 18000000, 'Iphone 16 Biru Laut Ultra', 'iphone 16.png', 1),
(3, 10, 198, '<html>\r\nProsesor\r\n<br/>Snapdragon® 8 Elite Mobile Platform\r\n\r\n<br/>Tipe RAM\r\n<br/>LPDDR5X Ultra\r\n\r\n<br/>Tipe ROM\r\n<br/>UFS 4.1*\r\n\r\n<br/>Baterai\r\n<br/>Produk ini mengadopsi desain seri sel ganda: \r\n<br/>Kapasitas tipikal: 3075mAh (7.68V), setara dengan 6150mAh (3.84V). \r\n<br/>Energi tipikal: 23,62Wh\r\n\r\n<br/>Daya Pengisian\r\n<br/>120 Watt\r\n</html>', 1, 10000000, 'Iqoo 13 12+256 Legend', 'iqoo 13.png', 1),
(4, 10, 209, '<html>\r\nProsesor\r\n<br/>Dimensity 9400\r\n\r\n<br/>Sertifikasi IP\r\n<br/>IP68 dan IP69\r\n\r\n<br/>Sistem Operasi\r\n<br/>Funtouch OS 15\r\n\r\n<br/>Versi Android\r\n<br/>Android 15\r\n\r\n<br/>Baterai\r\n<br/>Produk ini menggunakan desain sel tunggal:\r\n<br/>Kapasitas tipikal: 5800 mAh (3,84V) <br/>Energi tipikal: 22,28 Wh\r\n<br/>Kapasitas terukur: 5695 mAh (3,84V) <br/>Energi terukur: 21,87 Wh\r\n\r\n<br/>Daya Pengecasan\r\n<br/>90W\r\n\r\n<br/>Kamera\r\n<br/>Depan 32 MP/Belakang 50 MP + 50 MP + 50 MP\r\n\r\n<br/>Aperture\r\n<br/>Depan f/2.0 (32MP), Belakang f/1.57 (50MP) + f/2.0 (50MP) + f/2.57 (50MP)\r\n</html>', 1, 13000000, 'Vivo X200 12/256 Hijau', 'vivo x200.png', 1),
(5, 10, 215, '<html>\r\nLayar\r\n<br/>LTPO OLED, 68B colors, 120Hz, Dolby Vision, HDR10+, 1000 nits (typ), 3000 nits (peak)\r\n\r\n<br/>OS Android 14, upgradable to Android 15, up to 4 major Android upgrades, HyperOS 1.1\r\n\r\n<br/>Chipset	Qualcomm SM8650-AB Snapdragon 8 Gen 3 (4 nm)\r\n\r\n<br/>Kamera\r\n<br/>50 MP, f/1.6, 23mm (wide), 1/1.31\", <br/>1.2µm, dual pixel PDAF, OIS\r\n<br/>50 MP, f/2.0, 75mm (telephoto), <br/>PDAF (10cm - ∞), OIS, 3.2x optical zoom\r\n50 MP, f/2.2, 14mm, 115˚ (ultrawide)\r\n</html>', 1, 12000000, 'Xiaomi 14 12/256 Jade Green', 'xiaomi 14.png', 1),
(6, 3, 199, '<html>\r\nLAYAR\r\n</br>Jenis : Super AMOLED\r\n</br>Ukuran : 6.5 inci\r\n</br>Refresh Rate : 90 Hz\r\n</br>Resolusi : 1080 x 2340 piksel\r\n</br>HARDWARE\r\n</br>Chipset : MediaTek Helio G99\r\n</br>MEMORI\r\n</br>RAM : 8 GB\r\n</br>Memori Internal : 128 GB\r\n</html>', 3, 2500000, 'Samsung Galaxy A15 8GB/128GB', 'samsung a15.png', 1),
(7, 5, 205, '<html>\r\nMediaTek Dimensity 8300-Ultra\r\n</br>2 GB, 256 GB + 8 GB Ruang Ekstra | 12 GB, 512 GB + 16 GB Ruang EkstraUFS 4.0 + LPDDR5X 8533 Mbps\r\n</br>Layar AI 144 Hz generasi baru\r\n</br>Bahan: AMOLED\r\n</br>Resolusi: 2712 x 1220, 446 ppi\r\n</br>Refresh rate: Hingga 144 Hz\r\n</br>Lensa optik profesional LeicaLEICA VARIO-SUMMILUX 1:1,7-2,2/15-50 ASPH.\r\n</html>', 2, 6500000, 'Xiaomi 14t 12/256GB', 'xiaomi 14t.png', 1),
(8, 3, 205, '<html>\r\n</br>KAPASITAS BATERAI 5.000 mAh\r\n</br>PENGISIAN DAYA Tipe C\r\n</br>PROSESOR T603 Octa-core\r\n</br>SISTEM OPERASI Android ™13 (edisi Go)\r\n</br>JARINGAN 4G/3G/2G\r\n</br>KAMERA DEPAN 8MP\r\n</br>KAMERA BELAKANG 13 MP AI ganda\r\n</br>TAMPILAN Tampilan 6,6 inci\r\n</br>RESOLUSI 720*1612\r\n</br>Sistem itel OS 13\r\n</br>Sensor Sensor Sidik Jari Samping\r\n</html>', 3, 999000, 'Itel A70 4/64Gb', 'itel a70.png', 1),
(9, 5, 205, '<html>\r\n</br>KAPASITAS BATERAI 5.000 mAh\r\n</br>PENGISIAN DAYA Tipe C\r\n</br>PROSESOR T603 Octa-core\r\n</br>SISTEM OPERASI Android ™13 (edisi Go)\r\n</br>JARINGAN 4G/3G/2G\r\n</br>KAMERA DEPAN 8MP\r\n</br>KAMERA BELAKANG 13 MP AI ganda\r\n</br>TAMPILAN Tampilan 6,6 inci\r\n</br>RESOLUSI 720*1612\r\n</br>Sistem itel OS 13\r\n</br>Sensor Sensor Sidik Jari Samping\r\n</html>', 3, 1150000, 'Itel A70 8/128Gb', 'itel a70.png', 1);

-- --------------------------------------------------------

--
-- Table structure for table `provinces`
--

CREATE TABLE `provinces` (
  `province_id` int(1) NOT NULL,
  `province_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `provinces`
--

INSERT INTO `provinces` (`province_id`, `province_name`) VALUES
(1, 'Jawa Barat'),
(2, 'Jawa Tengah'),
(3, 'Jawa Timur'),
(4, 'Bali'),
(5, 'DKI Jakarta'),
(6, 'Banten'),
(7, 'Sulawesi Selatan'),
(8, 'Kalimatan Timur'),
(9, 'Papua Barat'),
(10, 'Aceh'),
(11, 'Maluku');

-- --------------------------------------------------------

--
-- Table structure for table `review`
--

CREATE TABLE `review` (
  `order_id` int(1) NOT NULL,
  `user_id` int(1) NOT NULL,
  `product_id` int(1) NOT NULL,
  `rating` tinyint(4) NOT NULL,
  `content` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(1) NOT NULL,
  `username` varchar(50) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `city_id` int(1) NOT NULL,
  `postcode` int(1) NOT NULL,
  `password` varchar(50) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`category_id`);

--
-- Indexes for table `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`city_id`),
  ADD KEY `province_id` (`province_id`);

--
-- Indexes for table `favorites`
--
ALTER TABLE `favorites`
  ADD PRIMARY KEY (`favorite_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `order_items`
--
ALTER TABLE `order_items`
  ADD KEY `order_id` (`order_id`,`product_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`Payment_id`),
  ADD KEY `Foreign Key` (`Order_id`),
  ADD KEY `Foreign Key1` (`Number`),
  ADD KEY `Foreign Key3` (`Token`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`),
  ADD KEY `category_id` (`category_id`);

--
-- Indexes for table `provinces`
--
ALTER TABLE `provinces`
  ADD PRIMARY KEY (`province_id`);

--
-- Indexes for table `review`
--
ALTER TABLE `review`
  ADD KEY `order_id` (`order_id`,`user_id`,`product_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `fk_city_id` (`city_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `category_id` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `city`
--
ALTER TABLE `city`
  MODIFY `city_id` int(1) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `favorites`
--
ALTER TABLE `favorites`
  MODIFY `favorite_id` int(1) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
  MODIFY `order_id` int(1) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `product_id` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `provinces`
--
ALTER TABLE `provinces`
  MODIFY `province_id` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `city`
--
ALTER TABLE `city`
  ADD CONSTRAINT `city_ibfk_1` FOREIGN KEY (`province_id`) REFERENCES `provinces` (`province_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `favorites`
--
ALTER TABLE `favorites`
  ADD CONSTRAINT `favorites_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  ADD CONSTRAINT `favorites_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `order_items`
--
ALTER TABLE `order_items`
  ADD CONSTRAINT `order_items_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `order_items_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `categories` (`category_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `review`
--
ALTER TABLE `review`
  ADD CONSTRAINT `review_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `review_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `review_ibfk_3` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `fk_city_id` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

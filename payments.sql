-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 14, 2025 at 10:06 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `TUBES`
--

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

--
-- Indexes for dumped tables
--

--
-- Indexes for table `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`Payment_id`),
  ADD KEY `Foreign Key` (`Order_id`),
  ADD KEY `Foreign Key1` (`Number`),
  ADD KEY `Foreign Key3` (`Token`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

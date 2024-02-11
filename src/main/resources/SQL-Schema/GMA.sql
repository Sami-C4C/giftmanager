-- phpMyAdmin SQL Dump
-- version 4.9.5deb2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jan 11, 2023 at 01:18 PM
-- Server version: 8.0.31-0ubuntu0.20.04.2
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `GMA`
--

-- --------------------------------------------------------

--
-- Table structure for table `gift`
--

CREATE TABLE `gift` (
  `id` bigint NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `date_of_creation` datetime(6) DEFAULT NULL,
  `ean` int DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `giftlist_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `gift`
--

INSERT INTO `gift` (`id`, `category`, `date_of_creation`, `ean`, `link`, `price`, `title`, `giftlist_id`) VALUES
(1, 'FOODS', '2022-01-26 00:12:00.000000', 123, 'https://www.deinetorte.de/', 150, 'Kuchen', 1),
(2, 'MODE', '2022-01-26 00:12:00.000000', 432, 'https://www.ebay.com/', 85, 'Adidas shuhe', 1),
(3, 'WEARS', '2022-01-27 00:12:00.000000', 567, 'https://en.zalando.de/', 200, 'Mantel', 1),
(4, 'WEARS', '2023-01-02 00:01:00.000000', 752, 'https://www.ebay.com/', 150, 'Levis Hose', 2),
(5, 'ELECTRONICS', '2023-01-03 00:01:00.000000', 879, 'https://www.amazon.de', 150, 'Tablet', 2),
(6, 'TECHNICS', '2023-01-03 00:01:00.000000', 941, 'https://www.amazon.de', 180, 'Air Fryer', 3),
(7, 'ELECTRONICS', '2023-01-06 00:01:00.000000', 629, 'https://www.amazon.de', 250, 'Galaxy Handy', 3);

-- --------------------------------------------------------

--
-- Table structure for table `giftlist`
--

CREATE TABLE `giftlist` (
  `giftlist_id` bigint NOT NULL,
  `budget` double DEFAULT NULL,
  `due_date` datetime(6) DEFAULT NULL,
  `event` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `total_price` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `giftlist`
--

INSERT INTO `giftlist` (`giftlist_id`, `budget`, `due_date`, `event`, `title`, `total_price`) VALUES
(1, 650, '2022-01-14 00:12:00.000000', 'CHRISTMAS', '1st List - CHRISTMAS', 635),
(2, 400, '2023-01-30 00:01:00.000000', 'BIRTHDAY', '2nd List - BIRTHDAY', 300),
(3, 450, '2023-01-12 00:01:00.000000', 'MOTHERS_DAY', '3rd List - MOTHERS_DAY', 430);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `gift`
--
ALTER TABLE `gift`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_h42kvp3273b5yhe9fljp6k4a0` (`ean`),
  ADD KEY `FKpk28h76dlwavg7kfedwepl8vt` (`giftlist_id`);

--
-- Indexes for table `giftlist`
--
ALTER TABLE `giftlist`
  ADD PRIMARY KEY (`giftlist_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `gift`
--
ALTER TABLE `gift`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `giftlist`
--
ALTER TABLE `giftlist`
  MODIFY `giftlist_id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `gift`
--
ALTER TABLE `gift`
  ADD CONSTRAINT `FKpk28h76dlwavg7kfedwepl8vt` FOREIGN KEY (`giftlist_id`) REFERENCES `giftlist` (`giftlist_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jul 08, 2024 at 01:19 PM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbpeternakan_2210010125`
--

-- --------------------------------------------------------

--
-- Table structure for table `pemasukkans`
--

CREATE TABLE `pemasukkans` (
  `id` int NOT NULL,
  `nama` varchar(191) NOT NULL,
  `tanggal` date DEFAULT NULL,
  `harga` decimal(15,2) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `pemasukkans`
--

INSERT INTO `pemasukkans` (`id`, `nama`, `tanggal`, `harga`, `created_at`, `updated_at`) VALUES
(1, 'Jaya', '2024-06-23', '1200000.00', '2024-06-23 13:20:51', '2024-06-23 13:20:51');

-- --------------------------------------------------------

--
-- Table structure for table `pengeluarans`
--

CREATE TABLE `pengeluarans` (
  `id` int NOT NULL,
  `nama` varchar(191) NOT NULL,
  `tanggal` date DEFAULT NULL,
  `harga` decimal(15,2) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `pengeluarans`
--

INSERT INTO `pengeluarans` (`id`, `nama`, `tanggal`, `harga`, `created_at`, `updated_at`) VALUES
(1, 'Jaya', '2024-06-23', '300000.00', '2024-06-23 13:21:30', '2024-06-23 13:21:30');

-- --------------------------------------------------------

--
-- Table structure for table `produks`
--

CREATE TABLE `produks` (
  `id` int NOT NULL,
  `jenis` varchar(191) NOT NULL,
  `nama` varchar(191) NOT NULL,
  `harga` bigint NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `produks`
--

INSERT INTO `produks` (`id`, `jenis`, `nama`, `harga`, `created_at`, `updated_at`) VALUES
(1, 'Pangan', 'Gamal', 500000, '2024-06-11 01:02:40', '2024-06-22 01:11:00'),
(2, 'Pangan', 'Daun Singkong', 600000, '2024-06-11 01:02:40', '2024-06-22 01:23:49'),
(3, 'Pangan', 'Turi', 700000, '2024-06-11 01:02:40', '2024-06-22 01:24:01'),
(4, 'Pangan', 'Kaliandra', 800000, '2024-06-11 01:02:40', '2024-06-22 01:24:09'),
(5, 'Pangan', 'Rumput Gajah Taiwan', 1000000, '2024-06-11 01:02:40', '2024-06-22 01:24:19');

-- --------------------------------------------------------

--
-- Table structure for table `produk_belis`
--

CREATE TABLE `produk_belis` (
  `id` int NOT NULL,
  `jenis` varchar(191) NOT NULL,
  `jumlah` int NOT NULL,
  `tanggal_beli` date DEFAULT NULL,
  `harga` decimal(15,2) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `produks_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `produk_belis`
--

INSERT INTO `produk_belis` (`id`, `jenis`, `jumlah`, `tanggal_beli`, `harga`, `created_at`, `updated_at`, `produks_id`) VALUES
(1, 'Pangan', 2, '2024-06-22', '1000000.00', '2024-06-22 01:50:27', '2024-06-22 01:50:27', 1);

-- --------------------------------------------------------

--
-- Table structure for table `produk_juals`
--

CREATE TABLE `produk_juals` (
  `id` int NOT NULL,
  `jenis` varchar(191) NOT NULL,
  `jumlah` int NOT NULL,
  `tanggal_jual` date DEFAULT NULL,
  `harga` decimal(15,2) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `produks_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `produk_juals`
--

INSERT INTO `produk_juals` (`id`, `jenis`, `jumlah`, `tanggal_jual`, `harga`, `created_at`, `updated_at`, `produks_id`) VALUES
(1, 'Pangan', 2, '2024-06-22', '1000000.00', '2024-06-23 12:56:32', '2024-06-23 12:56:32', 1);

-- --------------------------------------------------------

--
-- Table structure for table `saldos`
--

CREATE TABLE `saldos` (
  `id` int NOT NULL,
  `saldo` decimal(15,2) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `saldos`
--

INSERT INTO `saldos` (`id`, `saldo`, `created_at`, `updated_at`) VALUES
(1, '45000000.00', '2024-06-23 13:06:56', '2024-06-23 13:07:50');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pemasukkans`
--
ALTER TABLE `pemasukkans`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pengeluarans`
--
ALTER TABLE `pengeluarans`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `produks`
--
ALTER TABLE `produks`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `produk_belis`
--
ALTER TABLE `produk_belis`
  ADD PRIMARY KEY (`id`),
  ADD KEY `produks_belis` (`produks_id`);

--
-- Indexes for table `produk_juals`
--
ALTER TABLE `produk_juals`
  ADD PRIMARY KEY (`id`),
  ADD KEY `produks_juals` (`produks_id`) USING BTREE;

--
-- Indexes for table `saldos`
--
ALTER TABLE `saldos`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `produks`
--
ALTER TABLE `produks`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `produk_belis`
--
ALTER TABLE `produk_belis`
  ADD CONSTRAINT `produks_belis` FOREIGN KEY (`produks_id`) REFERENCES `produks` (`id`);

--
-- Constraints for table `produk_juals`
--
ALTER TABLE `produk_juals`
  ADD CONSTRAINT `produks_id` FOREIGN KEY (`produks_id`) REFERENCES `produks` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

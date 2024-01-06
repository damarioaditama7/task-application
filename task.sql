-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 06, 2024 at 05:34 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `task`
--

-- --------------------------------------------------------

--
-- Table structure for table `task`
--

CREATE TABLE `task` (
  `id` varchar(255) NOT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `deadline` date DEFAULT NULL,
  `created_at` date DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `updated_at` date DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `task`
--

INSERT INTO `task` (`id`, `user_id`, `description`, `status`, `deadline`, `created_at`, `created_by`, `updated_at`, `updated_by`) VALUES
('595c8009-0c17-44cd-b62e-b5a5e8e83ba0', '', 'test1', 'COMPLETED', NULL, '2024-01-06', 'SYSTEM', '2024-01-06', 'SYSTEM'),
('65358df3-de68-431f-9975-e0b790a094d5', NULL, 'test2', 'CREATED', '2024-01-10', '2024-01-06', 'SYSTEM', '2024-01-06', 'SYSTEM'),
('cd1fa8a6-12dc-4c24-994f-e86d8b8f4b4b', NULL, 'test1', 'COMPLETED', '2024-01-10', '2024-01-06', 'SYSTEM', '2024-01-06', 'SYSTEM'),
('e408b64d-c88e-492f-be74-a52ef9841829', '', 'test1', 'CREATED', NULL, '2024-01-06', 'SYSTEM', '2024-01-06', 'SYSTEM'),
('f2457c89-7a3c-4ad8-842e-3d1ccaf905ac', '', 'test', 'CREATED', NULL, '2024-01-06', 'SYSTEM', '2024-01-06', 'SYSTEM');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `task`
--
ALTER TABLE `task`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

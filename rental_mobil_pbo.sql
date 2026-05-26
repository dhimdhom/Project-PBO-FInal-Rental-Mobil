-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 26 Bulan Mei 2026 pada 18.18
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rental_mobil_pbo`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'hamba allah', 'bismillah');

-- --------------------------------------------------------

--
-- Struktur dari tabel `mobil`
--

CREATE TABLE `mobil` (
  `id` int(11) NOT NULL,
  `nama_mobil` varchar(100) DEFAULT NULL,
  `harga_per_hari` double DEFAULT NULL,
  `status_mobil` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `mobil`
--

INSERT INTO `mobil` (`id`, `nama_mobil`, `harga_per_hari`, `status_mobil`) VALUES
(1, 'Toyota Avanza 2010', 300000, 'Tersedia'),
(2, 'Toyota Avanza 2015', 350000, 'Tersedia'),
(3, 'Toyota Avanza 2020', 450000, 'Tidak Tersedia'),
(4, 'Honda Brio 2018', 250000, 'Tersedia'),
(5, 'Honda Brio 2022', 350000, 'Tersedia'),
(6, 'Mitsubishi Pajero 2021', 750000, 'Tersedia'),
(7, 'Mitsubishi Pajero Sport 2023', 950000, 'Tersedia'),
(8, 'Toyota Fortuner 2022', 850000, 'Tersedia'),
(9, 'Toyota Fortuner GR 2024', 1200000, 'Tersedia'),
(10, 'Suzuki Ertiga 2019', 280000, 'Tersedia'),
(11, 'Suzuki Ertiga Hybrid 2023', 450000, 'Tersedia'),
(12, 'Daihatsu Xenia 2012', 250000, 'Tersedia'),
(13, 'Daihatsu Xenia 2021', 380000, 'Tersedia'),
(14, 'Honda HR-V 2020', 500000, 'Tersedia'),
(15, 'Honda HR-V Turbo 2024', 850000, 'Tersedia'),
(16, 'Toyota Innova Reborn 2021', 600000, 'Tersedia'),
(17, 'Toyota Innova Zenix 2024', 950000, 'Tersedia'),
(18, 'Toyota Alphard 2022', 1500000, 'Tidak Tersedia'),
(19, 'Toyota Alphard Hybrid 2024', 2500000, 'Tersedia'),
(20, 'Honda Civic Turbo 2021', 700000, 'Tersedia'),
(21, 'Honda Civic RS 2024', 1000000, 'Tersedia'),
(22, 'Suzuki XL7 2020', 400000, 'Tersedia'),
(23, 'Suzuki XL7 Hybrid 2024', 550000, 'Tersedia'),
(24, 'Nissan Livina 2019', 320000, 'Tersedia'),
(25, 'Nissan Livina 2023', 450000, 'Tersedia'),
(26, 'Wuling Almaz 2022', 450000, 'Tersedia'),
(27, 'Hyundai Creta 2023', 550000, 'Tersedia'),
(28, 'Hyundai Stargazer 2024', 500000, 'Tersedia'),
(29, 'Kia Seltos 2022', 600000, 'Tersedia'),
(30, 'Mazda CX-5 2023', 900000, 'Tersedia'),
(31, 'BMW X1 2022', 1800000, 'Tersedia'),
(32, 'BMW 320i 2024', 2200000, 'Tersedia'),
(33, 'Mercedes Benz C200 2023', 2500000, 'Tersedia'),
(34, 'Toyota Camry 2022', 1200000, 'Tersedia'),
(35, 'Honda Jazz 2017', 300000, 'Tersedia'),
(36, 'Suzuki Karimun 2015', 200000, 'Tersedia'),
(37, 'Toyota Yaris 2021', 320000, 'Tersedia'),
(38, 'Honda CR-V 2023', 750000, 'Tersedia'),
(39, 'Daihatsu Terios 2022', 350000, 'Tersedia'),
(40, 'Mitsubishi Xpander 2024', 400000, 'Tersedia'),
(41, 'Toyota Rush 2021', 380000, 'Tersedia'),
(42, 'Isuzu Mu-X 2023', 800000, 'Tersedia'),
(43, 'Jeep Wrangler Rubicon 2024', 3000000, 'Tersedia'),
(44, 'Mini Cooper S 2023', 2000000, 'Tersedia'),
(45, 'Tesla Model 3 2024', 3500000, 'Tersedia'),
(46, 'BYD Seal 2024', 1800000, 'Tersedia'),
(47, 'Honda Accord 2023', 1000000, 'Tersedia'),
(48, 'Toyota Raize 2022', 350000, 'Tersedia'),
(49, 'Suzuki Jimny 2024', 950000, 'Tersedia'),
(50, 'Hyundai Ioniq 5 2024', 2500000, 'Tersedia'),
(51, 'Mitsubishi Triton 2022', 700000, 'Tersedia'),
(52, 'Ford Ranger Raptor 2024', 1500000, 'Tersedia'),
(53, 'Toyota Hilux 2023', 850000, 'Tersedia'),
(54, 'Honda Mobilio 2019', 280000, 'Tersedia'),
(55, 'Toyota Agya 2018', 220000, 'Tersedia'),
(56, 'Toyota Agya 2023', 320000, 'Tersedia'),
(57, 'Toyota Calya 2020', 300000, 'Tersedia'),
(58, 'Toyota Veloz 2024', 550000, 'Tersedia'),
(59, 'Honda City Hatchback 2023', 650000, 'Tersedia'),
(60, 'Honda WR-V 2024', 500000, 'Tersedia'),
(61, 'Honda BR-V 2022', 450000, 'Tersedia'),
(62, 'Honda BR-V Prestige 2024', 650000, 'Tersedia'),
(63, 'Suzuki Baleno 2022', 350000, 'Tersedia'),
(64, 'Suzuki S-Presso 2023', 250000, 'Tersedia'),
(65, 'Suzuki Carry Pickup 2021', 300000, 'Tersedia'),
(66, 'Daihatsu Ayla 2019', 200000, 'Tersedia'),
(67, 'Daihatsu Sigra 2021', 280000, 'Tersedia'),
(68, 'Daihatsu Rocky 2023', 450000, 'Tersedia'),
(69, 'Mitsubishi Outlander 2022', 850000, 'Tersedia'),
(70, 'Mitsubishi Delica 2021', 950000, 'Tersedia'),
(71, 'Nissan Serena 2023', 900000, 'Tersedia'),
(72, 'Nissan X-Trail 2022', 700000, 'Tersedia'),
(73, 'Hyundai Santa Fe 2024', 1200000, 'Tersedia'),
(74, 'Hyundai Palisade 2024', 2000000, 'Tersedia'),
(75, 'Kia Sonet 2023', 500000, 'Tersedia'),
(76, 'Kia Carnival 2024', 1800000, 'Tersedia'),
(77, 'Mazda 2 Hatchback 2022', 500000, 'Tersedia'),
(78, 'Mazda 3 Sedan 2024', 950000, 'Tersedia'),
(79, 'Mazda CX-30 2024', 1100000, 'Tersedia'),
(80, 'BMW X5 2024', 4500000, 'Tersedia'),
(81, 'BMW 520i 2023', 3500000, 'Tersedia'),
(82, 'Mercedes Benz E300 2024', 5000000, 'Tersedia'),
(83, 'Mercedes Benz GLC 2023', 4200000, 'Tersedia'),
(84, 'Audi A4 2023', 2800000, 'Tersedia'),
(85, 'Audi Q5 2024', 4000000, 'Tersedia'),
(86, 'Lexus RX 300 2024', 4500000, 'Tersedia'),
(87, 'Lexus LM 350 2024', 7000000, 'Tersedia'),
(88, 'Wuling Confero 2021', 250000, 'Tersedia'),
(89, 'Wuling Air EV 2024', 650000, 'Tersedia'),
(90, 'Chery Omoda 5 2024', 700000, 'Tersedia'),
(91, 'Chery Tiggo 8 2024', 950000, 'Tersedia'),
(92, 'BYD Dolphin 2024', 1200000, 'Tersedia'),
(93, 'BYD Atto 3 2024', 1700000, 'Tersedia'),
(94, 'Tesla Model Y 2024', 4500000, 'Tersedia'),
(95, 'Ford Everest 2023', 1500000, 'Tersedia'),
(96, 'Ford Ranger Wildtrak 2024', 1800000, 'Tersedia'),
(97, 'Jeep Compass 2023', 2200000, 'Tersedia'),
(98, 'Mini Cooper Cabrio 2024', 3500000, 'Tersedia'),
(99, 'Porsche Cayenne 2024', 8000000, 'Tersedia'),
(100, 'Land Rover Defender 2024', 9000000, 'Tersedia');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `id` int(11) NOT NULL,
  `nama_penyewa` varchar(100) DEFAULT NULL,
  `id_mobil` int(11) DEFAULT NULL,
  `lama_sewa` int(11) DEFAULT NULL,
  `harga_per_hari` double DEFAULT NULL,
  `total_harga` double DEFAULT NULL,
  `status_pembayaran` enum('Lunas','Belum Lunas') DEFAULT NULL,
  `status_sewa` enum('Sedang Disewa','Selesai') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`id`, `nama_penyewa`, `id_mobil`, `lama_sewa`, `harga_per_hari`, `total_harga`, `status_pembayaran`, `status_sewa`) VALUES
(11, 'Auliandi', 3, 3, 450000, 1350000, 'Lunas', 'Sedang Disewa'),
(12, 'Raihan', 18, 2, 1500000, 3000000, 'Lunas', 'Sedang Disewa');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `mobil`
--
ALTER TABLE `mobil`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_mobil` (`id_mobil`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `mobil`
--
ALTER TABLE `mobil`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- AUTO_INCREMENT untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`id_mobil`) REFERENCES `mobil` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

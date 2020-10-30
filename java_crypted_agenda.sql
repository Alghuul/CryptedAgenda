-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3308
-- Généré le :  Dim 05 jan. 2020 à 02:39
-- Version du serveur :  8.0.18
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `java_crypted_agenda`
--

-- --------------------------------------------------------

--
-- Structure de la table `agenda`
--

DROP TABLE IF EXISTS `agenda`;
CREATE TABLE IF NOT EXISTS `agenda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Date` date NOT NULL,
  `Hour` varchar(50) NOT NULL,
  `Duration` varchar(50) NOT NULL,
  `Event` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `agenda`
--

INSERT INTO `agenda` (`id`, `Date`, `Hour`, `Duration`, `Event`) VALUES
(5, '2020-01-06', '10h-12H', '2h', 'oa9funo5G1rDIe4JdXoJCA=='),
(4, '2020-01-01', '8H-12H', '4 hours', 'qXMjT9wgVtR+rFFWW131g1S1r3zDwOSOQn6Ba/lUv34='),
(6, '2020-01-01', '34', 'nvofijo', 'oijfovikp'),
(7, '2020-01-02', '2H', '2H', 'Hello bitch');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Fname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Lname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Mail` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Pass` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Bdate` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `Fname`, `Lname`, `Mail`, `Pass`, `Bdate`) VALUES
(2, 'Ihsane', 'Mohamed Amine', 'amineihsane@gmail.com', 'LvwCTQoVlFXhzT4eAyYW+UL9E970He/s/1+8rS2u9Gw=', '1996-10-07');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

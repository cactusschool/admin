-- --------------------------------------------------------
-- Host:                         18.191.242.227
-- Server version:               10.1.37-MariaDB - Source distribution
-- Server OS:                    Linux
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for cactusschool_admin
DROP DATABASE IF EXISTS `cactusschool_admin`;
CREATE DATABASE IF NOT EXISTS `cactusschool_admin` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `cactusschool_admin`;

-- Dumping structure for table cactusschool_admin.address
DROP TABLE IF EXISTS `address`;
CREATE TABLE IF NOT EXISTS `address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `school_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `address_name` varchar(100) DEFAULT NULL,
  `address_line1` varchar(75) NOT NULL,
  `address_line2` varchar(75) DEFAULT NULL,
  `address_line3` varchar(75) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `pin_code` varchar(10) DEFAULT NULL,
  `dist_code` varchar(4) DEFAULT NULL,
  `state_code` varchar(4) DEFAULT NULL,
  `country_code` varchar(4) DEFAULT NULL,
  `delete_ind` varchar(2) DEFAULT NULL,
  `delete_reason` varchar(100) DEFAULT NULL,
  `create_user` varchar(100) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_user` varchar(100) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`address_id`),
  KEY `FK_address_school_master` (`school_id`),
  KEY `FK_address_users` (`user_id`),
  CONSTRAINT `FK_address_school_master` FOREIGN KEY (`school_id`) REFERENCES `school_master` (`school_id`),
  CONSTRAINT `FK_address_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=latin1;

-- Dumping data for table cactusschool_admin.address: ~33 rows (approximately)
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` (`address_id`, `school_id`, `user_id`, `address_name`, `address_line1`, `address_line2`, `address_line3`, `city`, `pin_code`, `dist_code`, `state_code`, `country_code`, `delete_ind`, `delete_reason`, `create_user`, `create_date`, `update_user`, `update_date`) VALUES
	(2, 8, NULL, NULL, 'Queen Palace, Kalipur Check Post', '', '', 'Dankuni', '712709', 'HLY', 'WB', 'IND', NULL, NULL, NULL, NULL, NULL, NULL),
	(9, 1, NULL, NULL, 'Queen Palace, Kalipur Check Post', '', '', 'Dankuni', '712709', 'HLY', 'WB', 'IND', 'Y', 'Updated school address with a new address', NULL, NULL, 'ashish', '2019-02-03 22:58:38'),
	(10, 1, NULL, NULL, 'Queen Palace, Kalipur Check Post', '', '', 'Dankuni', '712709', 'HLY', 'WB', 'IND', 'Y', 'Updated school address with a new address', NULL, NULL, 'ashish', '2019-02-03 22:58:38'),
	(11, 1, NULL, NULL, 'Queen Palace, Kalipur Check Post', 'Opposite to Hero honda showroom', '', 'Dankuni', '712709', 'HLY', 'WB', 'IND', 'Y', 'Updated school address with a new address', NULL, NULL, 'ashish', '2019-02-03 22:58:38'),
	(14, 1, NULL, NULL, 'Queen Palace, Kalipur Check Post', 'Opposite to Hero honda showroom', '', 'Dankuni', '712709', 'HLY', 'WB', 'IND', 'Y', 'Updated school address with a new address', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(15, 1, NULL, NULL, 'Queen Palace, Kalipur Check Post', 'Opposite to Hero honda showroom', '', 'Dankuni', '712709', 'HLY', 'WB', 'IND', 'Y', 'Updated school address with a new address', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(16, 1, NULL, NULL, 'Queen Palace, Kalipur Check Post', 'Opposite to Hero honda showroom', '', 'Dankuni', '712709', 'HLY', 'WB', 'IND', 'Y', 'Updated school address with a new address', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(17, 1, NULL, NULL, 'Queen Palace, Kalipur Check Post', 'Opposite to Hero honda showroom', '', 'Dankuni', '712709', 'HLY', 'WB', 'IND', 'Y', 'Updated school address with a new address', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(23, 1, NULL, NULL, 'Queen Palace, Kalipur Check Post', 'Opposite to Hero honda showroom', '', 'Dankuni', '712709', 'HLY', 'WB', 'IND', 'Y', 'Updated school address with a new address', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(24, 1, NULL, NULL, 'Queen Palace, Kalipur Check Post', 'Opposite to Hero honda showroom', '', 'Dankuni', '712709', 'HLY', 'WB', 'IND', 'Y', 'Updated school address with a new address', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(33, 1, NULL, NULL, 'Queen Palace, Kalipur Check Post', 'Opposite to Hero honda showroom', '', 'Dankuni', '712709', 'HLY', 'WB', 'IND', 'Y', 'Updated school address with a new address', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(34, 1, NULL, NULL, 'Queen Palace, Kalipur Check Post', 'Opposite to Hero honda showroom', '', 'Dankuni', '712709', 'HLY', 'WB', 'IND', 'Y', 'Updated school address with a new address', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(35, 1, NULL, NULL, 'Queen Palace, Kalipur Check Post', 'Opposite to Hero honda showroom', '', 'Dankuni', '712709', 'HLY', 'WB', 'IND', 'Y', 'Updated school address with a new address', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(36, 1, NULL, NULL, 'Queen Palace, Kalipur Check Post', 'Opposite to Hero honda showroom', '', 'Dankuni', '712709', 'HLY', 'WB', 'IND', 'Y', 'Updated school address with a new address', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(37, 1, NULL, NULL, 'Queen Palace, Kalipur Check Post', 'Opposite to Hero honda showroom', '', 'Dankuni', '712709', 'HLY', 'WB', 'IND', 'Y', 'Updated school address with a new address', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(38, 1, NULL, NULL, 'Queen Palace, Kalipur Check Post', 'Opposite to Hero honda showroom', '', 'Dankuni', '712709', 'HLY', 'WB', 'IND', 'Y', 'Updated school address with a new address', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(39, 1, NULL, NULL, 'Queen Palace, Kalipur Check Post', 'Opposite to Hero honda showroom', '', 'Dankuni', '712709', 'HLY', 'WB', 'IND', 'Y', 'Updated school address with a new address', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(40, 1, NULL, NULL, 'Queen Palace, Kalipur Check Post', 'Opposite to Hero honda showroom', '', 'Dankuni', '712709', 'HLY', 'WB', 'IND', 'Y', 'Updated school address with a new address', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(41, 1, NULL, NULL, 'Queen Palace, Kalipur Check Post', 'Opposite to Hero honda showroom', '', 'Dankuni', '712709', 'HLY', 'WB', 'IND', 'Y', 'Updated school address with a new address', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(42, 1, NULL, NULL, 'Queen Palace, Kalipur Check Post', 'Opposite to Hero honda showroom', '', 'Dankuni', '712709', 'HLY', 'WB', 'IND', 'Y', 'Updated school address with a new address', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(43, 1, NULL, NULL, 'Queen Palace, Kalipur Check Post', 'Opposite to Hero honda showroom', '', 'Dankuni', '712709', 'HLY', 'WB', 'IND', 'Y', 'Updated school address with a new address', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(44, 1, NULL, NULL, 'Queen Palace, Kalipur Check Post', 'Opposite to Hero honda showroom', '', 'Dankuni', '712709', 'HLY', 'WB', 'IND', 'Y', 'Updated school address with a new address', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(45, 1, NULL, NULL, 'Queen Palace, Kalipur Check Post', 'Opposite to Hero honda showroom', '', 'Dankuni', '712709', 'HLY', 'WB', 'IND', NULL, NULL, 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(46, 9, NULL, NULL, 'Queen Palace, Kalipur Check Post', 'Opposite to Hero honda showroom', '', 'Dankuni', '712709', 'HLY', 'WB', 'IND', NULL, NULL, 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(47, 10, NULL, NULL, 'Queen Palace, Kalipur Check Post', 'Opposite to Hero honda showroom', '', 'Dankuni', '712709', 'HLY', 'WB', 'IND', NULL, NULL, 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(48, 11, NULL, NULL, 'Queen Palace, Kalipur Check Post', 'Opposite to Hero honda showroom', '', 'Dankuni', '712709', 'HLY', 'WB', 'IND', NULL, NULL, 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(53, 12, NULL, NULL, 'Queen Palace, Kalipur Check Post', 'Opposite to Hero honda showroom', '', 'Dankuni', '712709', 'HLY', 'WB', 'IND', NULL, NULL, 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(57, NULL, 8, NULL, 'Line1', 'Line2', 'Line3', 'City', '700000', 'BLR', 'KA', 'IN', 'N', 'NONE', 'ashish', '2019-02-05 20:36:25', 'ashish', '2019-02-05 20:36:25'),
	(60, NULL, 11, NULL, 'Line1', 'Line2', 'Line3', 'City', '700000', 'BLR', 'KA', 'IN', 'N', 'NONE', 'ashish', '2019-02-05 20:36:25', 'ashish', '2019-02-05 20:36:25'),
	(68, NULL, 19, NULL, 'Line1', 'Line2', 'Line3', 'City', '700000', 'BLR', 'KA', 'IN', 'N', 'NONE', 'ashish', '2019-02-05 20:36:25', 'ashish', '2019-02-05 20:36:25'),
	(69, NULL, 20, NULL, 'Line1', 'Line2', 'Line3', 'City', '700000', 'BLR', 'KA', 'IN', 'N', 'NONE', 'ashish', '2019-02-05 20:36:25', 'ashish', '2019-02-05 20:36:25'),
	(72, NULL, 23, NULL, 'Line1', 'Line2', 'Line3', 'City', '700000', 'BLR', 'KA', 'IN', 'N', 'NONE', 'ashish', '2019-02-05 20:36:25', 'ashish', '2019-02-05 20:36:25'),
	(73, NULL, 24, NULL, 'Line1', 'Line2', 'Line3', 'City', '700000', 'BLR', 'KA', 'IN', 'N', 'NONE', 'ashish', '2019-02-05 20:36:25', 'ashish', '2019-02-05 20:36:25'),
	(74, NULL, 25, NULL, 'Line1', 'Line2', 'Line3', 'City', '700000', 'BLR', 'KA', 'IN', 'N', 'NONE', 'ashish', '2019-02-05 20:36:25', 'ashish', '2019-02-05 20:36:25'),
	(75, NULL, 26, NULL, 'Line1', 'Line2', 'Line3', 'City', '700000', 'BLR', 'KA', 'IN', 'N', 'NONE', 'ashish', '2019-02-05 20:36:25', 'ashish', '2019-02-05 20:36:25');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;

-- Dumping structure for table cactusschool_admin.license_details
DROP TABLE IF EXISTS `license_details`;
CREATE TABLE IF NOT EXISTS `license_details` (
  `license_id` int(11) NOT NULL AUTO_INCREMENT,
  `school_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `payment_needed` varchar(2) DEFAULT NULL COMMENT 'Payment is needed only for school, parents and students. Fore teacher, school pays the subscription fees',
  `start_date` timestamp NULL DEFAULT NULL,
  `end_date` timestamp NULL DEFAULT NULL,
  `subscription_fees` double DEFAULT NULL,
  `delete_ind` varchar(2) DEFAULT NULL,
  `delete_reason` varchar(100) DEFAULT NULL,
  `create_user` varchar(50) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_user` varchar(50) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`license_id`),
  KEY `FK_license_details_school_master` (`school_id`),
  KEY `FK_license_details_users` (`user_id`),
  CONSTRAINT `FK_license_details_school_master` FOREIGN KEY (`school_id`) REFERENCES `school_master` (`school_id`),
  CONSTRAINT `FK_license_details_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- Dumping data for table cactusschool_admin.license_details: ~9 rows (approximately)
/*!40000 ALTER TABLE `license_details` DISABLE KEYS */;
INSERT INTO `license_details` (`license_id`, `school_id`, `user_id`, `payment_needed`, `start_date`, `end_date`, `subscription_fees`, `delete_ind`, `delete_reason`, `create_user`, `create_date`, `update_user`, `update_date`) VALUES
	(1, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(2, NULL, NULL, 'Y', '2019-02-03 02:58:38', '2021-02-03 02:58:38', 0, NULL, NULL, 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(3, NULL, NULL, 'Y', '2019-02-03 02:58:38', '2021-02-03 02:58:38', 0, NULL, NULL, 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(4, 1, NULL, 'Y', '2019-02-03 02:58:38', '2021-02-03 02:58:38', 0, 'Y', 'Updated school license with a new contract', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(5, 1, NULL, 'Y', '2019-02-03 02:58:38', '2021-02-03 02:58:38', 0, 'Y', 'Updated school license with a new contract', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(6, 1, NULL, 'Y', '2019-02-03 02:58:38', '2021-02-03 02:58:38', 0, 'Y', 'Updated school license with a new contract', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(7, 1, NULL, 'Y', '2019-02-03 02:58:38', '2021-02-03 02:58:38', 0, 'Y', 'Updated school license with a new contract', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(8, 1, NULL, 'Y', '2019-02-03 02:58:38', '2021-02-03 02:58:38', 0, NULL, NULL, 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(9, 12, NULL, 'Y', '2019-02-03 02:58:38', '2021-02-03 02:58:38', 200, NULL, NULL, 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38');
/*!40000 ALTER TABLE `license_details` ENABLE KEYS */;

-- Dumping structure for table cactusschool_admin.location_master
DROP TABLE IF EXISTS `location_master`;
CREATE TABLE IF NOT EXISTS `location_master` (
  `location_id` int(11) NOT NULL AUTO_INCREMENT,
  `district_code` varchar(5) NOT NULL,
  `district_name` varchar(20) NOT NULL,
  `state_code` varchar(5) NOT NULL,
  `state_name` varchar(20) NOT NULL,
  `country_code` varchar(5) NOT NULL,
  `country_name` varchar(20) NOT NULL,
  `delete_ind` varchar(2) DEFAULT NULL,
  `delete_reason` varchar(100) DEFAULT NULL,
  `create_user` varchar(50) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_user` varchar(50) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table cactusschool_admin.location_master: ~3 rows (approximately)
/*!40000 ALTER TABLE `location_master` DISABLE KEYS */;
INSERT INTO `location_master` (`location_id`, `district_code`, `district_name`, `state_code`, `state_name`, `country_code`, `country_name`, `delete_ind`, `delete_reason`, `create_user`, `create_date`, `update_user`, `update_date`) VALUES
	(1, 'HLY', 'Hooghly', 'WB', 'West Bengal', 'IN', 'India', NULL, NULL, 'ashish', '2019-02-03 19:59:54', NULL, NULL),
	(2, 'KOL', 'Kolkata', 'WB', 'West Bengal', 'IN', 'India', NULL, NULL, 'ashish', '2019-02-03 20:00:47', NULL, NULL),
	(3, 'BLR', 'Bangalore', 'KA', 'Karnataka', 'IN', 'India', NULL, NULL, 'ashish', '2019-02-03 20:00:39', NULL, NULL);
/*!40000 ALTER TABLE `location_master` ENABLE KEYS */;

-- Dumping structure for table cactusschool_admin.modules_permission
DROP TABLE IF EXISTS `modules_permission`;
CREATE TABLE IF NOT EXISTS `modules_permission` (
  `module_permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `school_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `module_id` int(11) NOT NULL,
  `delete_ind` varchar(2) DEFAULT NULL,
  `delete_reason` varchar(100) DEFAULT NULL,
  `create_user` varchar(50) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_user` varchar(50) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`module_permission_id`),
  KEY `FK_modules_permission_school_master` (`school_id`),
  KEY `FK_modules_permission_users` (`user_id`),
  KEY `FK_modules_permission_module_master` (`module_id`),
  CONSTRAINT `FK_modules_permission_module_master` FOREIGN KEY (`module_id`) REFERENCES `module_master` (`module_id`),
  CONSTRAINT `FK_modules_permission_school_master` FOREIGN KEY (`school_id`) REFERENCES `school_master` (`school_id`),
  CONSTRAINT `FK_modules_permission_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

-- Dumping data for table cactusschool_admin.modules_permission: ~18 rows (approximately)
/*!40000 ALTER TABLE `modules_permission` DISABLE KEYS */;
INSERT INTO `modules_permission` (`module_permission_id`, `school_id`, `user_id`, `module_id`, `delete_ind`, `delete_reason`, `create_user`, `create_date`, `update_user`, `update_date`) VALUES
	(1, 1, NULL, 1, 'Y', 'Other modules are updated. So deleting old modules', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(2, 1, NULL, 2, 'Y', 'Other modules are updated. So deleting old modules', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(3, 1, NULL, 3, 'Y', 'Other modules are updated. So deleting old modules', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(4, 1, NULL, 1, 'Y', 'Other modules are updated. So deleting old modules', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(5, 1, NULL, 2, 'Y', 'Other modules are updated. So deleting old modules', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(6, 1, NULL, 3, 'Y', 'Other modules are updated. So deleting old modules', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(7, 1, NULL, 1, 'Y', 'Other modules are updated. So deleting old modules', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(8, 1, NULL, 2, 'Y', 'Other modules are updated. So deleting old modules', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(9, 1, NULL, 3, 'Y', 'Other modules are updated. So deleting old modules', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(10, 1, NULL, 1, 'Y', 'Other modules are updated. So deleting old modules', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(11, 1, NULL, 2, 'Y', 'Other modules are updated. So deleting old modules', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(12, 1, NULL, 3, 'Y', 'Other modules are updated. So deleting old modules', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(19, 1, NULL, 1, 'Y', 'Other modules are updated. So deleting old modules', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(20, 1, NULL, 2, 'Y', 'Other modules are updated. So deleting old modules', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(21, 1, NULL, 3, 'Y', 'Other modules are updated. So deleting old modules', 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(22, 1, NULL, 1, NULL, NULL, 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(23, 1, NULL, 2, NULL, NULL, 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(24, 1, NULL, 3, NULL, NULL, 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38');
/*!40000 ALTER TABLE `modules_permission` ENABLE KEYS */;

-- Dumping structure for table cactusschool_admin.module_master
DROP TABLE IF EXISTS `module_master`;
CREATE TABLE IF NOT EXISTS `module_master` (
  `module_id` int(11) NOT NULL AUTO_INCREMENT,
  `module_name` varchar(50) NOT NULL,
  `module_feature` varchar(50) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `delete_ind` varchar(2) DEFAULT NULL,
  `delete_reason` varchar(100) DEFAULT NULL,
  `create_user` varchar(50) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_user` varchar(50) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table cactusschool_admin.module_master: ~3 rows (approximately)
/*!40000 ALTER TABLE `module_master` DISABLE KEYS */;
INSERT INTO `module_master` (`module_id`, `module_name`, `module_feature`, `description`, `delete_ind`, `delete_reason`, `create_user`, `create_date`, `update_user`, `update_date`) VALUES
	(1, 'NOTICE', 'VIEW_NOTICE', 'View Notices', NULL, NULL, 'ashish', '2019-02-03 20:56:00', NULL, NULL),
	(2, 'NOTICE', 'ADD_NOTICE', 'Add Notice', NULL, NULL, 'ashish', '2019-02-03 20:56:38', NULL, NULL),
	(3, 'NOTICE', 'UPDATE_NOTICE', 'Update Notice', NULL, NULL, 'ashish', '2019-02-03 20:56:38', NULL, NULL),
	(4, 'NOTICE', 'DELETE_NOTICE', 'Update Notice', NULL, NULL, 'ashish', '2019-02-03 20:56:38', NULL, NULL);
/*!40000 ALTER TABLE `module_master` ENABLE KEYS */;

-- Dumping structure for table cactusschool_admin.role_access
DROP TABLE IF EXISTS `role_access`;
CREATE TABLE IF NOT EXISTS `role_access` (
  `role_access_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `role_access_permission` enum('CREATE','READ','UPDATE','DELETE') NOT NULL,
  `delete_ind` varchar(2) DEFAULT NULL,
  `delete_reason` varchar(100) DEFAULT NULL,
  `create_user` varchar(50) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_user` varchar(50) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`role_access_id`),
  KEY `FK_role_access_role_master` (`role_id`),
  CONSTRAINT `FK_role_access_role_master` FOREIGN KEY (`role_id`) REFERENCES `role_master` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Dumping data for table cactusschool_admin.role_access: ~7 rows (approximately)
/*!40000 ALTER TABLE `role_access` DISABLE KEYS */;
INSERT INTO `role_access` (`role_access_id`, `role_id`, `role_access_permission`, `delete_ind`, `delete_reason`, `create_user`, `create_date`, `update_user`, `update_date`) VALUES
	(1, 1, 'CREATE', NULL, NULL, NULL, NULL, NULL, NULL),
	(2, 1, 'READ', NULL, NULL, NULL, NULL, NULL, NULL),
	(3, 1, 'UPDATE', NULL, NULL, NULL, NULL, NULL, NULL),
	(4, 1, 'DELETE', NULL, NULL, NULL, NULL, NULL, NULL),
	(5, 4, 'READ', NULL, NULL, NULL, NULL, NULL, NULL),
	(6, 3, 'CREATE', NULL, NULL, NULL, NULL, NULL, NULL),
	(7, 3, 'READ', NULL, NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `role_access` ENABLE KEYS */;

-- Dumping structure for table cactusschool_admin.role_master
DROP TABLE IF EXISTS `role_master`;
CREATE TABLE IF NOT EXISTS `role_master` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL,
  `role_desc` varchar(100) NOT NULL,
  `delete_ind` varchar(2) DEFAULT NULL,
  `delete_reason` varchar(100) DEFAULT NULL,
  `create_user` varchar(50) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_user` varchar(50) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Dumping data for table cactusschool_admin.role_master: ~6 rows (approximately)
/*!40000 ALTER TABLE `role_master` DISABLE KEYS */;
INSERT INTO `role_master` (`role_id`, `role_name`, `role_desc`, `delete_ind`, `delete_reason`, `create_user`, `create_date`, `update_user`, `update_date`) VALUES
	(1, 'ADMIN', 'Admin user', NULL, NULL, 'ashish', '2019-01-31 00:48:28', NULL, NULL),
	(2, 'PRINCIPAL', 'Principal', NULL, NULL, 'ashish', '2019-01-31 00:49:03', NULL, NULL),
	(3, 'TEACHER', 'Teacher', NULL, NULL, NULL, '2019-01-31 00:49:19', NULL, NULL),
	(4, 'PARENT', 'Parents', NULL, NULL, NULL, '2019-01-31 00:49:38', NULL, NULL),
	(5, 'ADMIN_SCHOOL', 'Admin School', NULL, NULL, 'ashish', '2019-02-03 06:23:02', NULL, NULL),
	(6, 'ADMIN_HEADOFFICE', 'Admin Headoffice', NULL, NULL, NULL, '2019-02-03 06:23:28', NULL, NULL);
/*!40000 ALTER TABLE `role_master` ENABLE KEYS */;

-- Dumping structure for table cactusschool_admin.school_master
DROP TABLE IF EXISTS `school_master`;
CREATE TABLE IF NOT EXISTS `school_master` (
  `school_id` int(11) NOT NULL AUTO_INCREMENT,
  `school_parent_id` int(11) NOT NULL,
  `school_group_name` varchar(150) DEFAULT NULL,
  `school_name` varchar(150) NOT NULL,
  `address_id` int(11) DEFAULT NULL COMMENT 'Physical address and phone number',
  `context_root` varchar(50) NOT NULL,
  `db_name` varchar(50) NOT NULL,
  `school_code` varchar(50) NOT NULL,
  `sms_sender_id` varchar(50) DEFAULT NULL,
  `contract_id` int(11) DEFAULT NULL COMMENT 'Contract Details',
  `delete_ind` varchar(2) DEFAULT NULL,
  `delete_reason` varchar(100) DEFAULT NULL,
  `create_user` varchar(100) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_user` varchar(100) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`school_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- Dumping data for table cactusschool_admin.school_master: ~11 rows (approximately)
/*!40000 ALTER TABLE `school_master` DISABLE KEYS */;
INSERT INTO `school_master` (`school_id`, `school_parent_id`, `school_group_name`, `school_name`, `address_id`, `context_root`, `db_name`, `school_code`, `sms_sender_id`, `contract_id`, `delete_ind`, `delete_reason`, `create_user`, `create_date`, `update_user`, `update_date`) VALUES
	(1, 0, '', 'Test', 45, 'test', 'test3', '100110', 'TEST', 0, NULL, NULL, 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(2, 0, '', 'Test', 1, 'test', 'test2', '100100', 'TEST', 0, NULL, NULL, NULL, NULL, NULL, NULL),
	(3, 0, '', 'Test', 0, 'test', 'test', '100100', 'TEST', 0, NULL, NULL, NULL, NULL, NULL, NULL),
	(4, 0, '', 'Test', 0, 'test', 'test', '100100', 'TEST', 0, NULL, NULL, NULL, NULL, NULL, NULL),
	(6, 0, '', 'Test', 0, 'test', 'test', '100100', 'TEST', 0, NULL, NULL, NULL, NULL, NULL, NULL),
	(7, 0, '', 'Test', 0, 'test', 'test', '100101', 'TEST', 0, NULL, NULL, NULL, NULL, NULL, NULL),
	(8, 0, '', 'Test', 2, 'test', 'test3', '100110', 'TEST', 0, NULL, NULL, NULL, NULL, NULL, NULL),
	(9, 1, '', 'Test', 46, 'test', 'test3', '100190', 'TEST', 0, NULL, NULL, 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(10, 1, '', 'Test', 47, 'test', 'test3', '100290', 'TEST', 0, NULL, NULL, 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(11, 1, '', 'Test', 48, 'test', 'test3', '110290', 'TEST', 0, NULL, NULL, 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38'),
	(12, 1, '', 'Test', 53, 'test', 'test3', '120290', 'TEST', 0, NULL, NULL, 'ashish', '2019-02-03 22:58:38', 'ashish', '2019-02-03 22:58:38');
/*!40000 ALTER TABLE `school_master` ENABLE KEYS */;

-- Dumping structure for table cactusschool_admin.school_users
DROP TABLE IF EXISTS `school_users`;
CREATE TABLE IF NOT EXISTS `school_users` (
  `school_users_id` int(11) NOT NULL AUTO_INCREMENT,
  `school_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `delete_ind` varchar(2) DEFAULT NULL,
  `delete_reason` varchar(100) DEFAULT NULL,
  `create_user` varchar(50) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_user` varchar(50) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`school_users_id`),
  KEY `FK_school_users_school_master` (`school_id`),
  KEY `FK_school_users_users` (`user_id`),
  CONSTRAINT `FK_school_users_school_master` FOREIGN KEY (`school_id`) REFERENCES `school_master` (`school_id`),
  CONSTRAINT `FK_school_users_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table cactusschool_admin.school_users: ~2 rows (approximately)
/*!40000 ALTER TABLE `school_users` DISABLE KEYS */;
INSERT INTO `school_users` (`school_users_id`, `school_id`, `user_id`, `delete_ind`, `delete_reason`, `create_user`, `create_date`, `update_user`, `update_date`) VALUES
	(1, 1, 24, 'N', 'NONE', 'ashish', '2019-02-05 20:36:25', 'ashish', '2019-02-05 20:36:25'),
	(2, 1, 25, 'N', 'NONE', 'ashish', '2019-02-05 20:36:25', 'ashish', '2019-02-05 20:36:25'),
	(3, 1, 26, 'N', 'NONE', 'ashish', '2019-02-05 20:36:25', 'ashish', '2019-02-05 20:36:25');
/*!40000 ALTER TABLE `school_users` ENABLE KEYS */;

-- Dumping structure for table cactusschool_admin.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `middle_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `parent_id` int(11) DEFAULT '0' COMMENT 'Parent if of students can be stored here',
  `account_locked` varchar(2) DEFAULT '0',
  `user_approved_ind` varchar(2) DEFAULT '0',
  `user_approval_comment` varchar(100) DEFAULT '0',
  `end_date` timestamp NULL DEFAULT NULL COMMENT 'End date null means the user is active else not active',
  `delete_ind` varchar(2) DEFAULT NULL,
  `delete_reason` varchar(100) DEFAULT NULL,
  `last_logged_in` timestamp NULL DEFAULT NULL,
  `create_user` varchar(50) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_user` varchar(50) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

-- Dumping data for table cactusschool_admin.users: ~11 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`user_id`, `user_name`, `password`, `first_name`, `middle_name`, `last_name`, `parent_id`, `account_locked`, `user_approved_ind`, `user_approval_comment`, `end_date`, `delete_ind`, `delete_reason`, `last_logged_in`, `create_user`, `create_date`, `update_user`, `update_date`) VALUES
	(1, 'ashish', '$2a$10$u0pzkxGOPKkq1iufN19OtO/tsT1vq0FI58RUMWYq7nG8bZJBLar3u', 'Ashish', 'Kumar', 'Mondal', 0, '0', 'Y', '', NULL, NULL, NULL, '2019-01-31 00:47:54', 'ashish', '2019-01-31 00:47:58', NULL, NULL),
	(2, 'madhurjya', '$2a$10$u0pzkxGOPKkq1iufN19OtO/tsT1vq0FI58RUMWYq7nG8bZJBLar3u', 'Madhurjya', NULL, 'Saikia', 0, '0', 'Y', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(3, 'rajesh', '$2a$10$u0pzkxGOPKkq1iufN19OtO/tsT1vq0FI58RUMWYq7nG8bZJBLar3u', 'Rajesh', NULL, 'Karmakar', 0, '0', 'Y', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(4, 'pranab', '$2a$10$u0pzkxGOPKkq1iufN19OtO/tsT1vq0FI58RUMWYq7nG8bZJBLar3u', 'Pranab', NULL, NULL, 0, '0', 'Y', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(5, 'admin', '$2a$10$u0pzkxGOPKkq1iufN19OtO/tsT1vq0FI58RUMWYq7nG8bZJBLar3u', 'Admin', NULL, 'Admin', 0, '0', 'Y', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(8, 'ashish1', 'ashish', 'Ashish', 'Kumar', 'Mondal', 0, NULL, NULL, NULL, '2019-02-05 20:36:25', 'N', 'NONE', '2019-02-05 20:36:25', 'ashish', '2019-02-05 20:36:25', 'ashish', '2019-02-05 20:36:25'),
	(11, 'ashish2', 'ashish', 'Ashish', 'Kumar', 'Mondal', 0, NULL, NULL, NULL, '2019-02-05 20:36:25', 'N', 'NONE', '2019-02-05 20:36:25', 'ashish', '2019-02-05 20:36:25', 'ashish', '2019-02-05 20:36:25'),
	(19, 'ashish3', 'ashish', 'Ashish', 'Kumar', 'Mondal', 0, NULL, NULL, NULL, '2019-02-05 20:36:25', 'N', 'NONE', '2019-02-05 20:36:25', 'ashish', '2019-02-05 20:36:25', 'ashish', '2019-02-05 20:36:25'),
	(20, 'ashish4', 'ashish', 'Ashish', 'Kumar', 'Mondal', 0, NULL, 'Y', 'Staff creation auto approved', '2029-02-05 20:36:25', 'N', 'NONE', '2019-02-05 20:36:25', 'ashish', '2019-02-05 20:36:25', 'ashish', '2019-02-05 20:36:25'),
	(23, 'ashish5', '$2a$10$tpHUEOMP7W/JOOQtTrNqxuTK/2WNopkzCQEKyeJ7/zgG7r.h9KGg2', 'Ashish', 'Kumar', 'Mondal', 0, NULL, 'Y', 'Staff creation auto approved', '2029-02-09 20:36:25', 'N', 'NONE', '2019-02-05 20:36:25', 'ashish', '2019-02-05 20:36:25', 'ashish', '2019-02-05 20:36:25'),
	(24, 'ashish6', '$2a$10$wShjk5tB5wnCmF0Lj6.EQuU.5Y2L0OH.l0OE.EcPTehtk/4ygCwuq', 'Ashish', 'Kumar', 'Mondal', 0, NULL, 'Y', 'Staff creation is auto approved', '2029-02-05 00:36:25', 'N', 'NONE', '2019-02-05 20:36:25', 'ashish', '2019-02-05 20:36:25', 'ashish', '2019-02-05 20:36:25'),
	(25, 'ashish7', '$2a$10$/WFsVit4IfTLTzgfKfLx7uusIzQnUw6Gk1nVYxmA7HUiUmJe8ZUPS', 'Ashish', 'Kumar', 'Mondal', 0, NULL, 'Y', 'Staff creation is auto approved', '2029-02-05 20:36:25', 'N', 'NONE', '2019-02-05 20:36:25', 'ashish', '2019-02-05 20:36:25', 'ashish', '2019-02-05 20:36:25'),
	(26, 'ashish8', '$2a$10$emnVUVISv2R1bLBOKAypYepIqUUAYLEAoAgiqnZSYqXxG1zr0aRI6', 'Ashish', 'Kumar', 'Mondal', 0, NULL, 'Y', 'Staff creation is auto approved', '2029-02-05 20:36:25', 'N', 'NONE', '2019-02-05 20:36:25', 'ashish', '2019-02-05 20:36:25', 'ashish', '2019-02-05 20:36:25');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

-- Dumping structure for table cactusschool_admin.user_role
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE IF NOT EXISTS `user_role` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `delete_ind` varchar(2) DEFAULT NULL,
  `delete_reason` varchar(100) DEFAULT NULL,
  `create_user` varchar(50) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_user` varchar(50) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`user_role_id`),
  KEY `FK__users` (`user_id`),
  KEY `FK__role_master` (`role_id`),
  CONSTRAINT `FK__role_master` FOREIGN KEY (`role_id`) REFERENCES `role_master` (`role_id`),
  CONSTRAINT `FK__users` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- Dumping data for table cactusschool_admin.user_role: ~8 rows (approximately)
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`user_role_id`, `user_id`, `role_id`, `delete_ind`, `delete_reason`, `create_user`, `create_date`, `update_user`, `update_date`) VALUES
	(1, 1, 1, NULL, NULL, 'ashish', '2019-01-31 03:17:33', NULL, NULL),
	(2, 3, 4, NULL, NULL, 'ashish', '2019-01-31 03:17:40', NULL, NULL),
	(3, 19, 3, 'N', 'NONE', 'ashish', '2019-02-05 20:36:25', 'ashish', '2019-02-05 20:36:25'),
	(4, 20, 3, 'N', 'NONE', 'ashish', '2019-02-05 20:36:25', 'ashish', '2019-02-05 20:36:25'),
	(5, 23, 3, 'N', 'NONE', 'ashish', '2019-02-05 20:36:25', 'ashish', '2019-02-05 20:36:25'),
	(6, 24, 3, 'N', 'NONE', 'ashish', '2019-02-05 20:36:25', 'ashish', '2019-02-05 20:36:25'),
	(7, 25, 3, 'N', 'NONE', 'ashish', '2019-02-05 20:36:25', 'ashish', '2019-02-05 20:36:25'),
	(8, 26, 3, 'N', 'NONE', 'ashish', '2019-02-05 20:36:25', 'ashish', '2019-02-05 20:36:25');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

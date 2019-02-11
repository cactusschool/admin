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


-- Dumping database structure for cactusschool_school1_mgmt
DROP DATABASE IF EXISTS `cactusschool_school1_mgmt`;
CREATE DATABASE IF NOT EXISTS `cactusschool_school1_mgmt` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `cactusschool_school1_mgmt`;

-- Dumping structure for table cactusschool_school1_mgmt.academic_year
DROP TABLE IF EXISTS `academic_year`;
CREATE TABLE IF NOT EXISTS `academic_year` (
  `academic_year_id` int(11) NOT NULL AUTO_INCREMENT,
  `academic_year_startdate` date DEFAULT NULL,
  `academic_year_enddate` date DEFAULT NULL,
  `delete_ind` varchar(2) DEFAULT NULL,
  `delete_description` varchar(100) DEFAULT NULL,
  `create_user` varchar(50) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_user` varchar(50) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`academic_year_id`),
  UNIQUE KEY `academic_year_startdate` (`academic_year_startdate`),
  UNIQUE KEY `academic_year_enddate` (`academic_year_enddate`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table cactusschool_school1_mgmt.academic_year: ~0 rows (approximately)
/*!40000 ALTER TABLE `academic_year` DISABLE KEYS */;
/*!40000 ALTER TABLE `academic_year` ENABLE KEYS */;

-- Dumping structure for table cactusschool_school1_mgmt.attachment_master
DROP TABLE IF EXISTS `attachment_master`;
CREATE TABLE IF NOT EXISTS `attachment_master` (
  `attachment_id` int(11) NOT NULL,
  `attachment_name` varchar(100) DEFAULT NULL,
  `attachment_description` varchar(200) DEFAULT NULL,
  `attachment_path` varchar(500) DEFAULT NULL,
  `delete_ind` varchar(2) DEFAULT NULL,
  `delete_reason` varchar(100) DEFAULT NULL,
  `create_user` varchar(50) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_user` varchar(50) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`attachment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table cactusschool_school1_mgmt.attachment_master: ~0 rows (approximately)
/*!40000 ALTER TABLE `attachment_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `attachment_master` ENABLE KEYS */;

-- Dumping structure for table cactusschool_school1_mgmt.class_master
DROP TABLE IF EXISTS `class_master`;
CREATE TABLE IF NOT EXISTS `class_master` (
  `class_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(50) DEFAULT NULL,
  `class_description` varchar(100) DEFAULT NULL,
  `section_startdate` date DEFAULT NULL,
  `section_enddate` date DEFAULT NULL,
  `delete_ind` varchar(2) DEFAULT NULL,
  `delete_description` varchar(100) DEFAULT NULL,
  `create_user` varchar(50) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `delete_user` varchar(50) DEFAULT NULL,
  `delete_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`class_id`),
  UNIQUE KEY `class_name` (`class_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table cactusschool_school1_mgmt.class_master: ~0 rows (approximately)
/*!40000 ALTER TABLE `class_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `class_master` ENABLE KEYS */;

-- Dumping structure for table cactusschool_school1_mgmt.notice_master
DROP TABLE IF EXISTS `notice_master`;
CREATE TABLE IF NOT EXISTS `notice_master` (
  `notice_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) DEFAULT NULL,
  `section_id` int(11) DEFAULT NULL,
  `notice_name` varchar(100) DEFAULT NULL,
  `notice_description` varchar(500) DEFAULT NULL,
  `notice_content` blob,
  `notice_startdate` timestamp NULL DEFAULT NULL,
  `notice_enddate` timestamp NULL DEFAULT NULL,
  `delete_ind` varchar(2) DEFAULT NULL,
  `delete_description` varchar(100) DEFAULT NULL,
  `create_user` varchar(50) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_user` varchar(50) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`notice_id`),
  KEY `FK_notice_master_class_master` (`class_id`),
  KEY `FK_notice_master_section_master` (`section_id`),
  CONSTRAINT `FK_notice_master_class_master` FOREIGN KEY (`class_id`) REFERENCES `class_master` (`class_id`),
  CONSTRAINT `FK_notice_master_section_master` FOREIGN KEY (`section_id`) REFERENCES `section_master` (`section_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table cactusschool_school1_mgmt.notice_master: ~0 rows (approximately)
/*!40000 ALTER TABLE `notice_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `notice_master` ENABLE KEYS */;

-- Dumping structure for table cactusschool_school1_mgmt.notice_reference
DROP TABLE IF EXISTS `notice_reference`;
CREATE TABLE IF NOT EXISTS `notice_reference` (
  `notice_reference_id` int(11) NOT NULL AUTO_INCREMENT,
  `notice_id` int(11) DEFAULT NULL,
  `attachment_id` int(11) DEFAULT NULL,
  `delete_ind` varchar(2) DEFAULT NULL,
  `delete_reason` varchar(100) DEFAULT NULL,
  `create_user` varchar(50) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_user` varchar(50) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`notice_reference_id`),
  KEY `FK_notice_reference_notice_master` (`notice_id`),
  KEY `FK_notice_reference_attachment_master` (`attachment_id`),
  CONSTRAINT `FK_notice_reference_attachment_master` FOREIGN KEY (`attachment_id`) REFERENCES `attachment_master` (`attachment_id`),
  CONSTRAINT `FK_notice_reference_notice_master` FOREIGN KEY (`notice_id`) REFERENCES `notice_master` (`notice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table cactusschool_school1_mgmt.notice_reference: ~0 rows (approximately)
/*!40000 ALTER TABLE `notice_reference` DISABLE KEYS */;
/*!40000 ALTER TABLE `notice_reference` ENABLE KEYS */;

-- Dumping structure for table cactusschool_school1_mgmt.school_master
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

-- Dumping data for table cactusschool_school1_mgmt.school_master: ~0 rows (approximately)
/*!40000 ALTER TABLE `school_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `school_master` ENABLE KEYS */;

-- Dumping structure for table cactusschool_school1_mgmt.section_master
DROP TABLE IF EXISTS `section_master`;
CREATE TABLE IF NOT EXISTS `section_master` (
  `section_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) DEFAULT NULL,
  `section_name` varchar(50) DEFAULT NULL,
  `section_descrition` varchar(100) DEFAULT NULL,
  `section_startdate` date DEFAULT NULL,
  `section_enddate` date DEFAULT NULL,
  `delete_ind` varchar(2) DEFAULT NULL,
  `delete_description` varchar(100) DEFAULT NULL,
  `create_user` varchar(50) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_user` varchar(50) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`section_id`),
  KEY `FK_section_master_class_master` (`class_id`),
  CONSTRAINT `FK_section_master_class_master` FOREIGN KEY (`class_id`) REFERENCES `class_master` (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table cactusschool_school1_mgmt.section_master: ~0 rows (approximately)
/*!40000 ALTER TABLE `section_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `section_master` ENABLE KEYS */;

-- Dumping structure for table cactusschool_school1_mgmt.student_master
DROP TABLE IF EXISTS `student_master`;
CREATE TABLE IF NOT EXISTS `student_master` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_firstname` varchar(50) DEFAULT NULL,
  `student_middlename` varchar(50) DEFAULT NULL,
  `student_lastname` varchar(50) DEFAULT NULL,
  `student_description` varchar(50) DEFAULT NULL,
  `delete_ind` varchar(50) DEFAULT NULL,
  `delete_description` varchar(50) DEFAULT NULL,
  `create_user` varchar(50) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_user` varchar(50) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table cactusschool_school1_mgmt.student_master: ~0 rows (approximately)
/*!40000 ALTER TABLE `student_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_master` ENABLE KEYS */;

-- Dumping structure for table cactusschool_school1_mgmt.student_section
DROP TABLE IF EXISTS `student_section`;
CREATE TABLE IF NOT EXISTS `student_section` (
  `student_class_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `section_id` int(11) DEFAULT NULL,
  `class_start_date` date DEFAULT NULL,
  `class_end_date` date DEFAULT NULL,
  `delete_ind` varchar(2) DEFAULT NULL,
  `delete_reason` varchar(100) DEFAULT NULL,
  `create_user` varchar(50) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_user` varchar(50) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`student_class_id`),
  KEY `FK_student_section_student_master` (`student_id`),
  KEY `FK_student_section_section_master` (`section_id`),
  CONSTRAINT `FK_student_section_section_master` FOREIGN KEY (`section_id`) REFERENCES `section_master` (`section_id`),
  CONSTRAINT `FK_student_section_student_master` FOREIGN KEY (`student_id`) REFERENCES `student_master` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table cactusschool_school1_mgmt.student_section: ~0 rows (approximately)
/*!40000 ALTER TABLE `student_section` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_section` ENABLE KEYS */;

-- Dumping structure for table cactusschool_school1_mgmt.student_subject
DROP TABLE IF EXISTS `student_subject`;
CREATE TABLE IF NOT EXISTS `student_subject` (
  `student_subject_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  `student_subject_startdate` date DEFAULT NULL,
  `student_subject_enddate` date DEFAULT NULL,
  `delete_ind` varchar(50) DEFAULT NULL,
  `delete_reason` varchar(100) DEFAULT NULL,
  `create_user` varchar(50) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_user` varchar(50) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`student_subject_id`),
  KEY `FK_student_subject_student_master` (`student_id`),
  KEY `FK_student_subject_subject_master` (`subject_id`),
  CONSTRAINT `FK_student_subject_student_master` FOREIGN KEY (`student_id`) REFERENCES `student_master` (`student_id`),
  CONSTRAINT `FK_student_subject_subject_master` FOREIGN KEY (`subject_id`) REFERENCES `subject_master` (`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table cactusschool_school1_mgmt.student_subject: ~0 rows (approximately)
/*!40000 ALTER TABLE `student_subject` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_subject` ENABLE KEYS */;

-- Dumping structure for table cactusschool_school1_mgmt.subject_master
DROP TABLE IF EXISTS `subject_master`;
CREATE TABLE IF NOT EXISTS `subject_master` (
  `subject_id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(50) DEFAULT NULL,
  `subject_description` varchar(50) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  `subject_startdate` date DEFAULT NULL,
  `subject_enddate` date DEFAULT NULL,
  `delete_ind` varchar(2) DEFAULT NULL,
  `delete_reason` varchar(50) DEFAULT NULL,
  `create_user` varchar(50) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_user` varchar(50) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`subject_id`),
  KEY `FK_subject_master_class_master` (`class_id`),
  CONSTRAINT `FK_subject_master_class_master` FOREIGN KEY (`class_id`) REFERENCES `class_master` (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table cactusschool_school1_mgmt.subject_master: ~0 rows (approximately)
/*!40000 ALTER TABLE `subject_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `subject_master` ENABLE KEYS */;

-- Dumping structure for table cactusschool_school1_mgmt.teacher_master
DROP TABLE IF EXISTS `teacher_master`;
CREATE TABLE IF NOT EXISTS `teacher_master` (
  `teacher_id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_firstname` varchar(50) DEFAULT NULL,
  `teacher_middlename` varchar(50) DEFAULT NULL,
  `teacher_lastname` varchar(50) DEFAULT NULL,
  `teacher_designation` varchar(100) DEFAULT NULL,
  `teacher_description` varchar(100) DEFAULT NULL,
  `teacher_qualification` varchar(100) DEFAULT NULL,
  `teacher_joining_date` date DEFAULT NULL,
  `teacher_retired_date` date DEFAULT NULL,
  `delete_ind` varchar(2) DEFAULT NULL,
  `delete_reason` varchar(100) DEFAULT NULL,
  `create_user` varchar(50) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_user` varchar(50) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table cactusschool_school1_mgmt.teacher_master: ~0 rows (approximately)
/*!40000 ALTER TABLE `teacher_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher_master` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

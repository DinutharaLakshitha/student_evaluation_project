-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 17, 2017 at 05:35 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbsgradeoneschoolintake`
--

-- --------------------------------------------------------

--
-- Table structure for table `applicant`
--

CREATE TABLE `applicant` (
  `applicant_id` int(8) NOT NULL,
  `first_name` varchar(16) DEFAULT NULL,
  `last_name` varchar(16) DEFAULT NULL,
  `initials` varchar(8) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `gender` varchar(7) DEFAULT NULL,
  `religion` varchar(16) DEFAULT NULL,
  `home_number` varchar(8) DEFAULT NULL,
  `street_name` varchar(32) DEFAULT NULL,
  `city` varchar(16) DEFAULT NULL,
  `district` varchar(16) DEFAULT NULL,
  `grama_niladari_div` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `applicant_parent`
--

CREATE TABLE `applicant_parent` (
  `applicant_id` int(8) NOT NULL,
  `NIC` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `applicant_reference_student`
--

CREATE TABLE `applicant_reference_student` (
  `applicant_id` int(8) NOT NULL,
  `student_id` int(8) NOT NULL,
  `ref_marks` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `applicant_school`
--

CREATE TABLE `applicant_school` (
  `applicant_id` int(11) NOT NULL,
  `school_id` int(11) NOT NULL,
  `distance` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `interview`
--

CREATE TABLE `interview` (
  `user_id` int(8) DEFAULT NULL,
  `applicant_id` int(8) NOT NULL,
  `school_id` int(11) NOT NULL,
  `interview_marks` int(3) DEFAULT NULL,
  `interview_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `parent`
--

CREATE TABLE `parent` (
  `NIC` varchar(10) NOT NULL,
  `first_name` varchar(16) NOT NULL,
  `last_name` varchar(16) DEFAULT NULL,
  `initials` varchar(8) DEFAULT NULL,
  `occupation` varchar(16) DEFAULT NULL,
  `gender` varchar(7) DEFAULT NULL,
  `tel_num` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `role_id` int(2) NOT NULL,
  `role_name` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `role_name`) VALUES
(1, 'admin'),
(2, 'dataEntry'),
(3, 'interviewer');

-- --------------------------------------------------------

--
-- Table structure for table `school`
--

CREATE TABLE `school` (
  `school_id` int(8) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `division` varchar(30) DEFAULT NULL,
  `district` varchar(16) DEFAULT NULL,
  `provision` varchar(16) DEFAULT NULL,
  `eligible_count` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `student_id` int(8) NOT NULL,
  `first_name` varchar(16) NOT NULL,
  `last_name` varchar(16) DEFAULT NULL,
  `initials` varchar(8) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `gender` varchar(7) DEFAULT NULL,
  `religion` varchar(16) DEFAULT NULL,
  `home_number` varchar(8) DEFAULT NULL,
  `street_name` varchar(32) DEFAULT NULL,
  `city` varchar(16) DEFAULT NULL,
  `district` varchar(16) DEFAULT NULL,
  `grama_niladari_div` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `student_school`
--

CREATE TABLE `student_school` (
  `student_id` int(8) NOT NULL,
  `school_id` int(8) NOT NULL,
  `grade_5` varchar(20) DEFAULT NULL,
  `ol` varchar(100) DEFAULT NULL,
  `al` varchar(100) DEFAULT NULL,
  `other` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(8) NOT NULL,
  `user_name` varchar(8) DEFAULT NULL,
  `pass` varchar(255) DEFAULT NULL,
  `telephone` varchar(11) DEFAULT NULL,
  `email` varchar(26) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `user_name`, `pass`, `telephone`, `email`) VALUES
(1, 'userAdmin', '*A4B6157319038724E3560894F7F932C8886EBFCF', '112345678', 'userAdmin@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `user_id` int(8) NOT NULL,
  `role_id` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user_school`
--

CREATE TABLE `user_school` (
  `user_id` int(8) NOT NULL,
  `school_id` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `applicant`
--
ALTER TABLE `applicant`
  ADD PRIMARY KEY (`applicant_id`);

--
-- Indexes for table `applicant_parent`
--
ALTER TABLE `applicant_parent`
  ADD PRIMARY KEY (`applicant_id`,`NIC`),
  ADD KEY `NIC` (`NIC`);

--
-- Indexes for table `applicant_reference_student`
--
ALTER TABLE `applicant_reference_student`
  ADD PRIMARY KEY (`applicant_id`,`student_id`),
  ADD KEY `student_id` (`student_id`);

--
-- Indexes for table `applicant_school`
--
ALTER TABLE `applicant_school`
  ADD PRIMARY KEY (`applicant_id`,`school_id`),
  ADD KEY `school_id_idx` (`school_id`);

--
-- Indexes for table `interview`
--
ALTER TABLE `interview`
  ADD PRIMARY KEY (`applicant_id`,`school_id`),
  ADD KEY `interview_ibfk_3_idx` (`school_id`),
  ADD KEY `2_idx` (`user_id`);

--
-- Indexes for table `parent`
--
ALTER TABLE `parent`
  ADD PRIMARY KEY (`NIC`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `school`
--
ALTER TABLE `school`
  ADD PRIMARY KEY (`school_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`student_id`);

--
-- Indexes for table `student_school`
--
ALTER TABLE `student_school`
  ADD PRIMARY KEY (`student_id`,`school_id`),
  ADD KEY `2_idx` (`school_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `role_id` (`role_id`);

--
-- Indexes for table `user_school`
--
ALTER TABLE `user_school`
  ADD PRIMARY KEY (`user_id`,`school_id`),
  ADD KEY `school_id` (`school_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `applicant`
--
ALTER TABLE `applicant`
  MODIFY `applicant_id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `role_id` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `school`
--
ALTER TABLE `school`
  MODIFY `school_id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `student_id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `applicant_parent`
--
ALTER TABLE `applicant_parent`
  ADD CONSTRAINT `applicant_parent_ibfk_1` FOREIGN KEY (`applicant_id`) REFERENCES `applicant` (`applicant_id`),
  ADD CONSTRAINT `applicant_parent_ibfk_2` FOREIGN KEY (`NIC`) REFERENCES `parent` (`NIC`);

--
-- Constraints for table `applicant_reference_student`
--
ALTER TABLE `applicant_reference_student`
  ADD CONSTRAINT `applicant_reference_student_ibfk_1` FOREIGN KEY (`applicant_id`) REFERENCES `applicant` (`applicant_id`),
  ADD CONSTRAINT `applicant_reference_student_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`);

--
-- Constraints for table `applicant_school`
--
ALTER TABLE `applicant_school`
  ADD CONSTRAINT `applicant_id` FOREIGN KEY (`applicant_id`) REFERENCES `applicant` (`applicant_id`),
  ADD CONSTRAINT `school_id` FOREIGN KEY (`school_id`) REFERENCES `school` (`school_id`);

--
-- Constraints for table `interview`
--
ALTER TABLE `interview`
  ADD CONSTRAINT `1` FOREIGN KEY (`applicant_id`) REFERENCES `applicant` (`applicant_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `3` FOREIGN KEY (`school_id`) REFERENCES `school` (`school_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `student_school`
--
ALTER TABLE `student_school`
  ADD CONSTRAINT `student_school_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`),
  ADD CONSTRAINT `student_school_ibfk_2` FOREIGN KEY (`school_id`) REFERENCES `school` (`school_id`);

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`);

--
-- Constraints for table `user_school`
--
ALTER TABLE `user_school`
  ADD CONSTRAINT `user_school_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `user_school_ibfk_2` FOREIGN KEY (`school_id`) REFERENCES `school` (`school_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

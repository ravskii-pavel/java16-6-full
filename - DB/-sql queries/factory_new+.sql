DROP TABLE IF EXISTS `courses`;
CREATE TABLE IF NOT EXISTS `courses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(150) NOT NULL DEFAULT '',
  `description` text NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `hours` smallint(5) NOT NULL,
  `date_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table company.courses: ~0 rows (approximately)
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` (`id`, `title`, `description`, `price`, `hours`, `date_create`) VALUES
	(1, 'Системное администрирование', '', 1500.00, 120, '2015-09-09 01:44:32'),
	(2, 'Кройки и шитья', '', 500.00, 80, '2015-09-09 01:44:59'),
	(3, 'Работа в ОС Ubuntu', '', 1099.99, 100, '2015-09-09 01:45:46');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;


-- Dumping structure for table company.departments
DROP TABLE IF EXISTS `departments`;
CREATE TABLE IF NOT EXISTS `departments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL DEFAULT '',
  `date_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table company.departments: ~0 rows (approximately)
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` (`id`, `title`, `date_create`) VALUES
	(1, 'IT', '2015-09-09 01:45:57'),
	(2, 'Юридический', '2015-09-09 01:46:16'),
	(3, 'Бухгалтерия', '2015-09-09 01:46:33'),
	(4, 'Охрана', '2015-09-09 01:48:30');
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;


-- Dumping structure for table company.employees
DROP TABLE IF EXISTS `employees`;
CREATE TABLE IF NOT EXISTS `employees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name_first` varchar(100) NOT NULL DEFAULT '',
  `name_last` varchar(100) NOT NULL DEFAULT '',
  `name_second` varchar(100) NOT NULL DEFAULT '',
  `salary` decimal(10,2) NOT NULL,
  `department_id` int(11) NOT NULL,
  `post_id` int(11) NOT NULL,
  `date_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `department_id_fk` (`department_id`),
  KEY `post_id_fk` (`post_id`),
  CONSTRAINT `employees_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`),
  CONSTRAINT `employees_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table company.employees: ~0 rows (approximately)
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` (`name_first`, `name_last`, `name_second`, `salary`, `department_id`, `post_id`, `date_create`) VALUES
	('Майк', 'Тайсон', '', 777.00, 1, 9, '2015-09-09 01:54:56'),
	('Хью', 'Лори', '', 2200.00, 2, 14, '2015-09-09 01:55:50');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;

select * from employees;

delete from employees;

-- Dumping structure for table company.employees_courses
DROP TABLE IF EXISTS `employees_courses`;
CREATE TABLE IF NOT EXISTS `employees_courses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL DEFAULT '0',
  `course_id` int(11) NOT NULL DEFAULT '0',
  `date_start` date NOT NULL,
  `date_finish` date DEFAULT NULL,
  `is_organization_paid` tinyint(1) NOT NULL DEFAULT '0',
  `date_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `employee_id` (`employee_id`),
  KEY `course_id_fk` (`course_id`),
  CONSTRAINT `employees_courses_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`),
  CONSTRAINT `employees_courses_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table company.employees_courses: ~0 rows (approximately)
/*!40000 ALTER TABLE `employees_courses` DISABLE KEYS */;
INSERT INTO `employees_courses` (`employee_id`, `course_id`, `date_start`, `date_finish`, `is_organization_paid`, `date_create`) VALUES
	(8, 2, '2015-09-09', NULL, 1, '2015-09-09 01:56:47'),
	(8, 3, '2015-07-09', '2015-09-09', 0, '2015-09-09 01:57:17'),
	(8, 1, '2015-10-09', '2015-11-09', 0, '2015-09-09 01:57:17'),
	(9, 1, '2014-09-09', '2014-10-09', 0, '2015-09-09 01:57:56'),
	(9, 2, '2014-09-09', '2014-11-09', 0, '2015-09-09 01:57:56');
/*!40000 ALTER TABLE `employees_courses` ENABLE KEYS */;

select * from employees_courses;

-- Dumping structure for table company.employees_tangibles
DROP TABLE IF EXISTS `employees_tangibles`;
CREATE TABLE IF NOT EXISTS `employees_tangibles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL,
  `tangible_id` int(11) NOT NULL,
  `uniq_number` int(11) NOT NULL,
  `date_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_number` (`uniq_number`),
  KEY `tangible_id` (`tangible_id`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `FK_tangibles_ibfk_1` FOREIGN KEY (`tangible_id`) REFERENCES `tangibles` (`id`),
  CONSTRAINT `FK_employees_ibfk_2` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL,
  `tangible_id` int(11) NOT NULL,
  `uniq_number` int(11) NOT NULL,
  `date_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_number` (`uniq_number`),
  KEY `employee_id` (`employee_id`),
  KEY `tangible_id` (`tangible_id`),
  CONSTRAINT `employees_tangibles_ibfk_2` FOREIGN KEY (`tangible_id`) REFERENCES `tangibles` (`id`),
  CONSTRAINT `employees_tangibles_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Dumping data for table company.employees_tangibles: ~0 rows (approximately)
/*!40000 ALTER TABLE `employees_tangibles` DISABLE KEYS */;
INSERT INTO `employees_tangibles` (`employee_id`, `tangible_id`, `uniq_number`, `date_create`) VALUES
	(8, 5, 1111, '2015-09-09 01:58:38'),
	(8, 7, 1112, '2015-09-09 01:58:58'),
	(8, 6, 2000, '2015-09-09 01:59:16'),
	(9, 3, 55555, '2015-09-09 01:59:37'),
	(9, 1, 12345, '2015-09-09 01:59:55'),
	(10, 7, 13245, '2015-09-09 02:00:30');
/*!40000 ALTER TABLE `employees_tangibles` ENABLE KEYS */;

select * from employees_tangibles;

-- Dumping structure for table company.posts
DROP TABLE IF EXISTS `posts`;
CREATE TABLE IF NOT EXISTS `posts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL DEFAULT '',
  `date_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Dumping data for table company.posts: ~0 rows (approximately)
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` (`title`, `date_create`) VALUES
	('Начальник департамента', '2015-09-09 01:47:07'),
	('Зам.начальника департамента', '2015-09-09 01:47:25'),
	('Юрист', '2015-09-09 01:47:32'),
	('Глава охраны', '2015-09-09 01:47:41'),
	('Охранник', '2015-09-09 01:47:49'),
	('Бухгалтер', '2015-09-09 01:48:00'),
	('Программист', '2015-09-09 01:48:09'),
	('Системный администратор', '2015-09-09 01:48:19');
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;

select * from posts;

-- Dumping structure for table company.salaries_paid
DROP TABLE IF EXISTS `salaries_paid`;
CREATE TABLE IF NOT EXISTS `salaries_paid` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL DEFAULT '0',
  `salary` decimal(10,2) NOT NULL DEFAULT '0.00',
  `date_pay` date NOT NULL DEFAULT '0000-00-00',
  `date_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `salaries_paid_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Dumping data for table company.salaries_paid: ~0 rows (approximately)
/*!40000 ALTER TABLE `salaries_paid` DISABLE KEYS */;
INSERT INTO `salaries_paid` (`employee_id`, `salary`, `date_pay`, `date_create`) VALUES
	(8, 1000.00, '2015-01-01', '2015-09-09 02:01:34'),
	(8, 1100.00, '2015-02-01', '2015-09-09 02:01:48'),
	(8, 1200.00, '2015-03-01', '2015-09-09 02:02:28'),
	(9, 1.00, '2015-08-01', '2015-09-09 02:02:57'),
	(9, 1.01, '2015-09-01', '2015-09-09 02:03:29'),
	(10, 10000.00, '2015-08-01', '2015-09-09 02:03:54');
/*!40000 ALTER TABLE `salaries_paid` ENABLE KEYS */;

select * from salaries_paid;
-- Dumping structure for table company.tangibles
DROP TABLE IF EXISTS `tangibles`;
CREATE TABLE IF NOT EXISTS `tangibles` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL DEFAULT '',
  `price` decimal(10,2) NOT NULL,
  `description` text NOT NULL,
  `date_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Dumping data for table company.tangibles: ~0 rows (approximately)
/*!40000 ALTER TABLE `tangibles` DISABLE KEYS */;
INSERT INTO `tangibles` (`id`, `title`, `price`, `description`, `date_create`) VALUES
	(1, 'Стул 1112', 550.50, '', '2015-09-09 01:49:17'),
	(2, 'Стул 223', 599.99, '', '2015-09-09 01:49:26'),
	(3, 'Стол с тубмой', 1599.00, '', '2015-09-09 01:49:43'),
	(4, 'Стол', 1199.00, '', '2015-09-09 01:50:16'),
	(5, 'Монитор 22\'\' LG', 4200.00, '', '2015-09-09 01:50:32'),
	(6, 'Клавиатура Logitech', 150.00, '', '2015-09-09 01:50:47'),
	(7, 'Системный блок /i7/8GB/2TB', 11234.00, '', '2015-09-09 01:51:28');
/*!40000 ALTER TABLE `tangibles` ENABLE KEYS */;

select * from tangibles;

-- Dumping structure for table company.working_days
DROP TABLE IF EXISTS `working_days`;
CREATE TABLE IF NOT EXISTS `working_days` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL DEFAULT '0',
  `day_start` datetime NOT NULL,
  `day_finish` datetime DEFAULT NULL,
  `date_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `working_days_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Dumping data for table company.working_days: ~0 rows (approximately)
/*!40000 ALTER TABLE `working_days` DISABLE KEYS */;
INSERT INTO `working_days` (`employee_id`, `day_start`, `day_finish`, `date_create`) VALUES
	(8, '2015-09-07 09:04:26', '2015-09-07 19:04:38', '2015-09-09 02:04:49'),
	(8, '2015-09-08 09:04:59', '2015-09-08 19:35:11', '2015-09-09 02:05:16'),
	(10, '2015-09-09 08:05:47', '2015-09-09 18:05:58', '2015-09-09 02:06:04'),
	(9, '2015-09-06 08:06:16', '2015-09-06 18:06:29', '2015-09-09 02:06:44'),
	(9, '2015-09-07 10:06:53', '2015-09-07 20:07:14', '2015-09-09 02:07:19'),
	(9, '2015-09-08 09:07:31', '2015-09-08 22:07:39', '2015-09-09 02:07:44');
    
    select * from working_days;
    select * from tangibles;
    select * from salaries_paid;
    select * from posts;
    select * from employees_tangibles;
    select * from employees_courses;
    select * from employees;
    select * from departments;
    select * from courses;
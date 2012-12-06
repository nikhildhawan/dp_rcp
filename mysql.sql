tourdetails | CREATE TABLE `tourdetails` (
  `tourdetails_id` int(11) NOT NULL AUTO_INCREMENT,
  `tourdetails_name` varchar(45) DEFAULT NULL,
  `tourdetails_from` varchar(45) DEFAULT NULL,
  `tourdetails_dest` varchar(45) DEFAULT NULL,
  `tourdetails_via` varchar(45) DEFAULT NULL,
  `tourdetails_agent` varchar(45) DEFAULT NULL,
  `tourdetails_date` date DEFAULT NULL,
  PRIMARY KEY (`tourdetails_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1
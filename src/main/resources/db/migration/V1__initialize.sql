
DROP TABLE IF EXISTS `product`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `cost` decimal (8,2) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `product` WRITE;
INSERT INTO `product` VALUES (1,'Computer','500'),(2,'Smartphone','100'),(3,'TV','400'),(4,'Milk','50'),(5,'Bread','20'),(6,'Apple','10'),(7,'Banana','20'),(8,'Coffe','15'),(9,'Whore','2000'),(10,'Disk','200'),(11,'Playstation','4000'),(12,'HeadPhones','500'),(13,'Vodka','700'),(14,'Whisky','800'),(15,'Tea','25'),(16,'Snickers','600'),(17,'Notebook','15000'),(18,'Cola','60'),(19,'Snowboard','3500'),(20,'Keyboard','1800');
UNLOCK TABLES;


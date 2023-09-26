/*
SQLyog Community v13.2.0 (64 bit)
MySQL - 5.7.30 : Database - inter_exercise
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`inter_exercise` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `inter_exercise`;

/*Table structure for table `inter_user` */

DROP TABLE IF EXISTS `inter_user`;

CREATE TABLE `inter_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增ID',
  `username` varchar(16) DEFAULT NULL COMMENT '用户名',
  `password` varchar(18) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `inter_user` */

insert  into `inter_user`(`id`,`username`,`password`) values 
(6,'admin','123456'),
(7,'phil012','123456');

/*Table structure for table `ip_record` */

DROP TABLE IF EXISTS `ip_record`;

CREATE TABLE `ip_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增ID',
  `uri` varchar(100) DEFAULT NULL COMMENT '接口名称',
  `view_num` int(11) DEFAULT NULL COMMENT '接口访问次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `ip_record` */

insert  into `ip_record`(`id`,`uri`,`view_num`) values 
(1,'/commService/userIp.do',5),
(2,'/register.do',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

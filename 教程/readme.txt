
本教程使用一下技术框架：
    SpringMVC4
    Spring4
    Hibernate5
    restful 风格
    MySQL 数据库

使用到的表结构：

CREATE TABLE `t_customer` (
  `cust_id` int(11) NOT NULL AUTO_INCREMENT,
  `cust_name` varchar(255) DEFAULT NULL,
  `cust_telephone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cust_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
            CREATE TABLE `user` (
              `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
              `username` varchar(128) DEFAULT NULL COMMENT '用户名',
              `password` VARCHAR(18) DEFAULT NULL COMMENT '密码',
              `phone` varchar(16) DEFAULT NULL COMMENT '用户手机号',
              `create_time` datetime DEFAULT NULL COMMENT '创建时间',
              `age` int(4) DEFAULT NULL COMMENT '年龄',
              PRIMARY KEY (`id`)
            ) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
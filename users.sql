CREATE TABLE users(
   uid VARCHAR(32) NOT NULL PRIMARY KEY COMMENT '用户id',
   uname VARCHAR(32) NOT NULL COMMENT '用户名',
   borndate DATETIME NOT NULL COMMENT '出生日期',
   sex INT NOT NULL COMMENT '性别, 0:男  1:女',
   STATUS INT NOT NULL  COMMENT '用户状态: 0 正常使用   1 禁用'
);

SELECT * FROM users;


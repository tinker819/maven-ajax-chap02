CREATE TABLE users(
   uid VARCHAR(32) NOT NULL PRIMARY KEY COMMENT '�û�id',
   uname VARCHAR(32) NOT NULL COMMENT '�û���',
   borndate DATETIME NOT NULL COMMENT '��������',
   sex INT NOT NULL COMMENT '�Ա�, 0:��  1:Ů',
   STATUS INT NOT NULL  COMMENT '�û�״̬: 0 ����ʹ��   1 ����'
);

SELECT * FROM users;


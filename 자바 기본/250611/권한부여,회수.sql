CREATE USER 'test_admin'@'%'
	IDENTIFIED BY '1111';
    
GRANT all PRIVILEGES on my_db.* TO 'test_admin'@'%';

REVOKE all ON my_db.* FROM 'test_admin'@'%';

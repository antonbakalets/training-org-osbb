CREATE USER 'osbb_user'@'localhost' IDENTIFIED BY 'shared';

GRANT ALL ON osbb_shared.* TO 'osbb_user'@'localhost' IDENTIFIED BY 'shared';
GRANT ALL ON osbb_test.* TO 'osbb_user'@'localhost' IDENTIFIED BY 'shared';
GRANT ALL ON osbb_another.* TO 'osbb_user'@'localhost' IDENTIFIED BY 'shared';

FLUSH PRIVILEGES;

GRANT FILE ON *.* TO 'osbb_shared'@'localhost';
GRANT FILE ON *.* TO 'osbb_test'@'localhost';
GRANT FILE ON *.* TO 'osbb_another'@'localhost';

FLUSH PRIVILEGES;

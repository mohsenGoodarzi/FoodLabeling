# nutrition.information
Developed in java

## setup sql in wsl:

 -- sudo service mysql start
 -- mysql -u root -p password
 -- CREATE USER 'test'@'localhost' IDENTIFIED BY 'test';
 -- GRANT CREATE, ALTER, DROP, INSERT, UPDATE, DELETE, SELECT, REFERENCES, RELOAD on *.* TO 'test'@'localhost' WITH GRANT OPTION;
 -- FLUSH PRIVILEGES;

 ## setup in docker container.
 please change localhost to mysql-container in application.properties, if you use alpine, otherwise it is fine with ubuntu.
CREATE USER "clever"@"localhost" IDENTIFIED BY "1234";
SELECT * FROM mysql.user;
GRANT SELECT,INSERT ON carrinho to "clever"@"localhost";
GRANT SELECT,INSERT ON produtos to "clever"@"localhost";
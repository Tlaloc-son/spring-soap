CREATE DATABASE db_pokemon;

CREATE USER 'user_pokemon'@'%' IDENTIFIED BY 'poke';
GRANT ALL PRIVILEGES ON db_pokemon.* TO 'user_pokemon';
FLUSH PRIVILEGES;
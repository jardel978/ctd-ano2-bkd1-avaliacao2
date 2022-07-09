CREATE DATABASE IF NOT EXISTS avaliacao2_movie;

USE avaliacao2_movie;

create table tb_movie (id varchar(255) not null auto_increment, genre varchar(255), name varchar(255), url_stream varchar(255), primary key (id)) engine=InnoDB;

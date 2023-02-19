create table  hibernate_sequence (
    next_val bigint
) engine=MyISAM;

insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values  ( 1 );

CREATE TABLE user (
    id BIGENT NOT NULL AUTO_INCREMENT,
    password varcher(64) not null,
    username varcher(64) not null unique,
    PRIMARY KEY (id)
) engine=MyISAM;

CREATE TABLE todo (
  id BIGENT NOT NULL AUTO_INCREMENT,
  title varcher(64) not null,
  completed BOOLEAN NOT NULL,
  PRIMARY KEY (id)
) engine=MyISAM;

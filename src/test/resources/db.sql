create database concretepageslave;
use concretepageslave;
create table articles  (
	article_id int(5) auto_increment primary key,
  title varchar(200),
  category varchar(100) 
);
insert into articles (title, category) values ("Gra o tron" , "Fantastyka");
insert into articles (title, category) values ("Wiedzmin" , "Fantastyka");
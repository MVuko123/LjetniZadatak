drop database if exists kino;
create database kino;
use kino;

create table film(
   sifra int not null primary key auto_increment,
   naziv varchar(50) not null,
   redatelj varchar(50) not null,
   godina int not null,
   ocjena decimal(18,2) not null
);

create table projekcija(
    sifra int not null primary key auto_increment,
    film int not null,
    datum datetime not null
);


create table kupac(
   sifra int not null primary key auto_increment,
   spol char(1) not null,
   dob int not null,
   ime varchar(50) not null,
   prezime varchar(50) not null
);

create table karta(
    sifra int not null primary key auto_increment,
    cijena decimal(18,2) not null,
    kupac int not null,
    projekcija int not null,
    sjedalo int not null,
    red varchar(2) not null 
);

create table hrana_pice(
    sifra int not null primary key auto_increment,
    naziv varchar(50) not null,
    cijena decimal(18,2) not null
);

create table pojeo_popio(
   sifra int not null primary key auto_increment,
   kolicina int not null,
   karta int not null,
   hrana_pice int not null
);


alter table projekcija add foreign key (film) references film(sifra);

alter table karta add foreign key (kupac) references kupac(sifra);
alter table karta add foreign key (projekcija) references projekcija(sifra);

alter table pojeo_popio add foreign key (karta) references karta(sifra);
alter table pojeo_popio add foreign key (hrana_pice) references hrana_pice(sifra);

show tables;

select * from film;

insert into film(sifra, naziv, redatelj, godina, ocjena)
values
(null, 'The Dark Knight' , 'Christopher Nolan', 2008, 9);

insert into film(sifra, naziv, redatelj, godina, ocjena)
values
(null, 'Inception' , 'Christopher Nolan', 2010, 8.8);

insert into film(sifra, naziv, redatelj, godina, ocjena)
values
(null, 'Gladiator' , 'Ridley Scott', 2000, 8.5);

insert into film(sifra, naziv, redatelj, godina, ocjena)
values
(null, 'The Lord of the Rings: The Fellowship of the Ring' , 'Peter Jackson', 2001, 8.8);

insert into film(sifra, naziv, redatelj, godina, ocjena)
values
(null, 'Django Unchained' , 'Quentin Tarantino', 2012, 8.4);

insert into film(sifra, naziv, redatelj, godina, ocjena)
values
(null, 'Inglorious Besterds' , 'Quentin Tarantino', 2009, 8.3);

insert into film(sifra, naziv, redatelj, godina, ocjena)
values
(null, 'The Wolf of Wall Street' , 'Martin Scoresese', 2013, 8.2);

insert into film(sifra, naziv, redatelj, godina, ocjena)
values
(null, 'The Dark Knight Rises' , 'Christopher Nolan', 2012, 8.4);

insert into film(sifra, naziv, redatelj, godina, ocjena)
values
(null, 'Guardian of the Galaxy' , 'James Gunn', 2014, 8);

insert into film(sifra, naziv, redatelj, godina, ocjena)
values
(null, 'The Departed' , 'Martin Scorsese', 2006, 8.5);

select * from projekcija;

insert into projekcija(sifra, film, datum)
values
(null, 1, '2020-01-22');

insert into projekcija(sifra, film, datum)
values
(null, 2, '2020-01-19');

insert into projekcija(sifra, film, datum)
values
(null, 3, '2020-01-09');

insert into projekcija(sifra, film, datum)
values
(null, 4, '2020-01-11');

insert into projekcija(sifra, film, datum)
values
(null, 5, '2020-01-24');

insert into projekcija(sifra, film, datum)
values
(null, 6, '2020-01-08');

insert into projekcija(sifra, film, datum)
values
(null, 7, '2020-02-02');

insert into projekcija(sifra, film, datum)
values
(null, 8, '2020-02-08');

insert into projekcija(sifra, film, datum)
values
(null, 9, '2020-02-12');

insert into projekcija(sifra, film, datum)
values
(null, 10, '2020-02-25');

select * from kupac;

insert into kupac(sifra , spol , dob , ime , prezime )
values
(null, 'm', 17, 'Pero', 'Peric');

insert into kupac(sifra , spol , dob , ime , prezime )
values
(null, 'z', 20, 'Suzana', 'Suzic');

insert into kupac(sifra , spol , dob , ime , prezime )
values
(null, 'm', 22, 'Mujo', 'Mujic');

insert into kupac(sifra , spol , dob , ime , prezime )
values
(null, 'z', 14, 'Ana', 'Anic');

insert into kupac(sifra , spol , dob , ime , prezime )
values
(null, 'm', 35, 'Haso', 'Hasic');

insert into kupac(sifra , spol , dob , ime , prezime )
values
(null, 'z', 40, 'Nada', 'Nadic');

insert into kupac(sifra , spol , dob , ime , prezime )
values
(null, 'm', 33, 'Marko', 'Markic');

insert into kupac(sifra , spol , dob , ime , prezime )
values
(null, 'z', 15, 'Nika', 'Nikic');

insert into kupac(sifra , spol , dob , ime , prezime )
values
(null, 'm', 38, 'Mate', 'Matic');

insert into kupac(sifra , spol , dob , ime , prezime )
values
(null, 'z', 27, 'Ljuba', 'Ljubic');

insert into kupac(sifra , spol , dob , ime , prezime )
values
(null, 'm', 13, 'Jure', 'Juric');

insert into kupac(sifra , spol , dob , ime , prezime )
values
(null, 'z', 14, 'Maja', 'Majic');

insert into kupac(sifra , spol , dob , ime , prezime )
values
(null, 'm', 22, 'Mihael', 'Mihic');

insert into kupac(sifra , spol , dob , ime , prezime )
values
(null, 'z', 25, 'Mihaela', 'Mihicic');

insert into kupac(sifra , spol , dob , ime , prezime )
values
(null, 'm', 16, 'Gabrijel', 'Gabric');

insert into kupac(sifra , spol , dob , ime , prezime )
values
(null, 'z', 29, 'Lara', 'Laric');

insert into kupac(sifra , spol , dob , ime , prezime )
values
(null, 'm', 65, 'Mato', 'Matic');

insert into kupac(sifra , spol , dob , ime , prezime )
values
(null, 'z', 22, 'Marija', 'Maric');

insert into kupac(sifra , spol , dob , ime , prezime )
values
(null, 'm', 33, 'Anto', 'Antic');

insert into kupac(sifra , spol , dob , ime , prezime )
values
(null, 'z', 38, 'Veronika', 'Veric');

select * from karta;

insert into karta(sifra, cijena, kupac, projekcija, sjedalo, red)
values
(null, 22, 1, 1, 5, 'A');

insert into karta(sifra, cijena, kupac, projekcija, sjedalo, red)
values
(null, 22, 2, 1, 8, 'C');

insert into karta(sifra, cijena, kupac, projekcija, sjedalo, red)
values
(null, 37.50, 3, 2, 1, 'F');

insert into karta(sifra, cijena, kupac, projekcija, sjedalo, red)
values
(null, 37.50, 4, 2, 13, 'D');

insert into karta(sifra, cijena, kupac, projekcija, sjedalo, red)
values
(null, 43.20, 5, 3, 22, 'H');

insert into karta(sifra, cijena, kupac, projekcija, sjedalo, red)
values
(null, 43.20, 6, 3, 6, 'G');

insert into karta(sifra, cijena, kupac, projekcija, sjedalo, red)
values
(null, 10.70, 7, 4, 8, 'I');

insert into karta(sifra, cijena, kupac, projekcija, sjedalo, red)
values
(null, 10.70, 8, 4, 19, 'J');

insert into karta(sifra, cijena, kupac, projekcija, sjedalo, red)
values
(null, 34, 9, 5, 14, 'B');

insert into karta(sifra, cijena, kupac, projekcija, sjedalo, red)
values
(null, 34, 10, 5, 5, 'K');

insert into karta(sifra, cijena, kupac, projekcija, sjedalo, red)
values
(null, 26, 11, 6, 15, 'D');

insert into karta(sifra, cijena, kupac, projekcija, sjedalo, red)
values
(null, 26, 12, 6, 3, 'A');

insert into karta(sifra, cijena, kupac, projekcija, sjedalo, red)
values
(null, 35.50, 13, 7, 9, 'G');

insert into karta(sifra, cijena, kupac, projekcija, sjedalo, red)
values
(null, 35.50, 14, 7, 16, 'C');

insert into karta(sifra, cijena, kupac, projekcija, sjedalo, red)
values
(null, 52, 15, 8, 8, 'E');

insert into karta(sifra, cijena, kupac, projekcija, sjedalo, red)
values
(null, 52, 16, 8, 16, 'F');

insert into karta(sifra, cijena, kupac, projekcija, sjedalo, red)
values
(null, 20, 17, 9, 15, 'H');

insert into karta(sifra, cijena, kupac, projekcija, sjedalo, red)
values
(null, 20, 18, 9, 7, 'D');

insert into karta(sifra, cijena, kupac, projekcija, sjedalo, red)
values
(null, 38.20, 19, 10, 6, 'A');

insert into karta(sifra, cijena, kupac, projekcija, sjedalo, red)
values
(null, 38.20, 20, 10, 20, 'G');


select * from hrana_pice;

insert into hrana_pice (sifra, naziv, cijena)
values
(null, 'Male Kokice', 13.50);

insert into hrana_pice (sifra, naziv, cijena)
values
(null, 'Srednje Kokice', 19);

insert into hrana_pice (sifra, naziv, cijena)
values
(null, 'Velike Kokice', 24);

insert into hrana_pice (sifra, naziv, cijena)
values
(null, 'Mali Nachosi', 22.70);

insert into hrana_pice (sifra, naziv, cijena)
values
(null, 'Srednji Nachosi', 30);

insert into hrana_pice (sifra, naziv, cijena)
values
(null, 'Velik Nachosi', 38.50);

insert into hrana_pice (sifra, naziv, cijena)
values
(null, 'Mali Sok', 12);

insert into hrana_pice (sifra, naziv, cijena)
values
(null, 'Srednji Sok', 17.50);

insert into hrana_pice (sifra, naziv, cijena)
values
(null, 'Veliki Sok', 23);

insert into hrana_pice (sifra, naziv, cijena)
values
(null, 'Male Kokice i Mali Sok', 23);

insert into hrana_pice (sifra, naziv, cijena)
values
(null, 'Male Kokice i Srednji Sok', 28);

insert into hrana_pice (sifra, naziv, cijena)
values
(null, 'Male Kokice i Veliki Sok', 33);

insert into hrana_pice (sifra, naziv, cijena)
values
(null, 'Srednje Kokice i Mali Sok', 29);

insert into hrana_pice (sifra, naziv, cijena)
values
(null, 'Srednje Kokice i Srednji Sok', 33.50);

insert into hrana_pice (sifra, naziv, cijena)
values
(null, 'Srednje Kokice i Veliki Sok', 39);

insert into hrana_pice (sifra, naziv, cijena)
values
(null, 'Velike Kokice i Mali Sok', 34);

insert into hrana_pice (sifra, naziv, cijena)
values
(null, 'Velike Kokice i Srednji Sok', 38.50);

insert into hrana_pice (sifra, naziv, cijena)
values
(null, 'Velike Kokice i Veliki Sok', 44);

insert into hrana_pice (sifra, naziv, cijena)
values
(null, 'Mali Nachosi i Mali Sok', 33);

insert into hrana_pice (sifra, naziv, cijena)
values
(null, 'Mali Nachosi i Srednji Sok', 37.50);

insert into hrana_pice (sifra, naziv, cijena)
values
(null, 'Mali Nachosi i Veliki Sok', 43);

insert into hrana_pice (sifra, naziv, cijena)
values
(null, 'Srednji Nachosi i Mali Sok', 40);

insert into hrana_pice (sifra, naziv, cijena)
values
(null, 'Srednji Nachosi i Srednji Sok', 44.50);

insert into hrana_pice (sifra, naziv, cijena)
values
(null, 'Srednji Nachosi i Veliki Sok', 50);

insert into hrana_pice (sifra, naziv, cijena)
values
(null, 'Veliki Nachosi i Mali Sok', 47);

insert into hrana_pice (sifra, naziv, cijena)
values
(null, 'Veliki Nachosi i Srednji Sok', 53);

insert into hrana_pice (sifra, naziv, cijena)
values
(null, 'Veliki Nachosi i Veliki Sok', 59);

select * from pojeo_popio;

insert into pojeo_popio (sifra, kolicina, karta, hrana_pice)
values
(null, 4, 1, 17);

insert into pojeo_popio (sifra, kolicina, karta, hrana_pice)
values
(null, 2, 2, 19);

insert into pojeo_popio (sifra, kolicina, karta, hrana_pice)
values
(null, 1, 3, 6);

insert into pojeo_popio (sifra, kolicina, karta, hrana_pice)
values
(null, 3, 4, 8);

insert into pojeo_popio (sifra, kolicina, karta, hrana_pice)
values
(null, 2, 5, 25);

insert into pojeo_popio (sifra, kolicina, karta, hrana_pice)
values
(null, 3, 6, 4);

insert into pojeo_popio (sifra, kolicina, karta, hrana_pice)
values
(null, 6, 7, 1);

insert into pojeo_popio (sifra, kolicina, karta, hrana_pice)
values
(null, 2, 8, 5);

insert into pojeo_popio (sifra, kolicina, karta, hrana_pice)
values
(null, 1, 9, 2);

insert into pojeo_popio (sifra, kolicina, karta, hrana_pice)
values
(null, 3, 10, 3);

insert into pojeo_popio (sifra, kolicina, karta, hrana_pice)
values
(null, 2, 11, 7);

insert into pojeo_popio (sifra, kolicina, karta, hrana_pice)
values
(null, 5, 12, 8);

insert into pojeo_popio (sifra, kolicina, karta, hrana_pice)
values
(null, 4, 13, 16);

insert into pojeo_popio (sifra, kolicina, karta, hrana_pice)
values
(null, 3, 14, 27);

insert into pojeo_popio (sifra, kolicina, karta, hrana_pice)
values
(null, 1, 15, 26);

insert into pojeo_popio (sifra, kolicina, karta, hrana_pice)
values
(null, 4, 16, 21);

insert into pojeo_popio (sifra, kolicina, karta, hrana_pice)
values
(null, 2, 17, 14);

insert into pojeo_popio (sifra, kolicina, karta, hrana_pice)
values
(null, 1, 18, 4);

insert into pojeo_popio (sifra, kolicina, karta, hrana_pice)
values
(null, 2, 19, 18);

insert into pojeo_popio (sifra, kolicina, karta, hrana_pice)
values
(null, 4, 20, 24);

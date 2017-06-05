create database caa;
	use caa;
	create table Idioma(idIdioma varchar(2) primary key,
						nombre varchar(15));
	create table EE(idEE varchar(2) primary key,
						nombre varchar(15),
						creditos varchar(2),
						idIdioma varchar(2),
						foreign key (idIdioma) references Idioma(idIdioma));
	create table ActividadCatalogo(idActividad int auto_increment primary key, 
							nombreActividad varchar(20),
							idEE varchar(2),
							tipo varchar(64),
							descripcion varchar(128),
							foreign key (idEE) references EE(idEE));
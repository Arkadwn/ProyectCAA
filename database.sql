create database caa;
	use caa;
	create table Idioma(idIdioma varchar(2) primary key,
						nombre varchar(15));
	create table EE(idEE varchar(2) primary key,
						nombre varchar(15),
						creditos varchar(2));
	create table ActividadCatalogo(idActividad varchar(3) primary key, 
							nombreActividad varchar(20), 
							idIdioma varchar(2),
							idEE varchar(2),
							tipo varchar(125),
							descripcion varchar(64),
							foreign key (idIdioma) references Idioma(idIdioma),
							foreign key (idEE) references EE(idEE));
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
							
create table Usuario(
    -> nombreUsuario varchar(40) primary key,
    -> contrasena varchar(64),
    -> tipo varchar(4));
	
create table asesor(
    -> numPersonal varchar(15) primary key,
    -> nombre varchar(50),
    -> apellidoPaterno varchar(30),
    -> apellidoMaterno varchar(30),
    -> correo varchar(50),
    -> idAviso varchar(10),
    -> nombreUsuario varchar(40),
    -> telefono varchar(20),
    -> foreign key (nombreUsuario) references Usuario(nombreUsuario),
    -> idiomaIngles boolean,
    -> idiomaFrances boolean);
	
insert into usuario values('Leonardo',sha2('acdc619mljj',256),'ASE');
insert into usuario values('Adrian',sha2('arkadwn1234',256),'COOR');
insert into usuario values('Roberto',sha2('alfa28',256),'COOR');

insert into asesor values('1443','Miguel Leonardo','Jimenez','Jimenez','acdc.ml.999@gmail.com','Aviso1','Leonardo','2281152023',true,true);

create table Salon(
	idSalon varchar(10) primary key,
	cupo int,
	nombreSalon varchar(50));

create table actividadProgramada(
	horaIni varchar(20),
	horaFin varchar(20),
	fechaIni date,
	fechaFin date,
	idActividad int,
	foreign key (idActividad) references ActividadCatalogo(idActividad),
	idSalon varchar(10),
	foreign key (idSalon) references Salon(idSalon),
	idActividadProgram varchar(10) primary key,
	idRervacion varchar(10),
	estado boolean,
	cupo int);

create table usuarioAutonomo(
	matricula varchar(9) primary key,
	nombre varchar(50),
    apellidoPaterno varchar(30),
    apellidoMaterno varchar(30),
    correo varchar(50),
    idAviso varchar(10),
    nombreUsuario varchar(40),
    telefono varchar(20),
    foreign key (nombreUsuario) references Usuario(nombreUsuario));
	
create table listaAsistencia(
	idActividadProgram varchar(10),
	foreign key (idActividadProgram) references actividadProgramada(idActividadProgram),
	fechaModificacion date,
	matricula varchar(9),
	foreign key (matricula) references usuarioAutonomo(matricula));
drop table if exists ejercicio;
drop table if exists entrenador;

create table ejercicio (
    id int primary key auto_increment,
    nombre varchar(200) not null,
    imagen_url varchar(500),
    zona_muscular varchar(200) not null,
    zona_muscular2 varchar(200)
);

insert into ejercicio
(id, nombre, imagen_url, zona_muscular, zona_muscular2) values
(1, 'Press banca', 'img/imgTemplate.jpg', 'trenSuperior', 'pecho'),
(2, 'Sentadilla', 'img/imgTemplate.jpg', 'trenInferior', 'cuadriceps'),
(3, 'Peso muerto', 'img/imgTemplate.jpg', 'trenInferior', 'espalda'),
(4, 'Dominadas', 'img/imgTemplate.jpg', 'trenSuperior', 'espalda'),
(5, 'Curl de biceps', 'img/imgTemplate.jpg', 'trenSuperior', 'brazos'),
(6, 'Press militar', 'img/imgTemplate.jpg', 'trenSuperior', 'hombro'),
(7, 'Hip trust', 'img/imgTemplate.jpg', 'trenInferior', 'gluteos'),
(8, 'Extension de cuádriceps', 'img/imgTemplate.jpg', 'trenInferior', 'cuadriceps'),
(9, 'Extensión de gemelos', 'img/imgTemplate.jpg', 'trenInferior', 'gemelos'),
(10, 'Extensión de triceps', 'img/imgTemplate.jpg', 'trenSuperior', 'brazos'),
(11, 'Zancada', 'img/imgTemplate.jpg', 'trenInferior', 'gluteos'),
(12, 'Elevación frontal', 'img/imgTemplate.jpg', 'trenSuperior', 'hombro'),
(13, 'Elevación lateral', 'img/imgTemplate.jpg', 'trenSuperior', 'hombro');


create table entrenador (
    id int primary key auto_increment,
    nombre varchar(200) not null,
    sitio_web varchar(500)
);

insert into entrenador
(id, nombre, sitio_web) values
(1, 'Oriol Pedro','https://www.oriolartes.com'),
(2, 'Rx mountain','https://www.rx.com'),
(3, 'Edu Crai','https://www.educortes.com'),
(4, 'Alex Opla','https://www.aleix.com'),
(5, 'Nuria Esmeralda','https://www.nuria.com');


alter table ejercicio
add column entrenador_id int,
add foreign key (entrenador_id) references entrenador(id);

update ejercicio set entrenador_id = 1 where id in (1, 4, 6);
update ejercicio set entrenador_id = 2 where id in (3, 5, 8, 9);
update ejercicio set entrenador_id = 3 where id in (2, 11);
update ejercicio set entrenador_id = 4 where id in (12, 13);
update ejercicio set entrenador_id = 5 where id in (7, 10);

alter table ejercicio
modify entrenador_id int not null;
drop table if exists ejercicio;

create table ejercicio (
    id int primary key auto_increment,
    nombre varchar(200) not null,
    imagen_url varchar(500),
    zona_muscular varchar(200) not null,
    zona_muscular2 varchar(200)
);

insert into ejercicio
(nombre, imagen_url, zona_muscular, zona_muscular2) values
('Press banca', 'img/imgTemplate.jpg', 'trenSuperior', 'pecho'),
('Sentadilla', 'img/imgTemplate.jpg', 'trenInferior', 'cuadriceps'),
('Peso muerto', 'img/imgTemplate.jpg', 'trenInferior', 'espalda'),
('Dominadas', 'img/imgTemplate.jpg', 'trenSuperior', 'espalda'),
('Curl de biceps', 'img/imgTemplate.jpg', 'trenSuperior', 'brazos'),
('Press militar', 'img/imgTemplate.jpg', 'trenSuperior', 'hombro'),
('Hip trust', 'img/imgTemplate.jpg', 'trenInferior', 'gluteos'),
('Extension de cuádriceps', 'img/imgTemplate.jpg', 'trenInferior', 'cuadriceps'),
('Extensión de gemelos', 'img/imgTemplate.jpg', 'trenInferior', 'gemelos'),
('Extensión de triceps', 'img/imgTemplate.jpg', 'trenSuperior', 'brazos'),
('Zancada', 'img/imgTemplate.jpg', 'trenInferior', 'gluteos'),
('Elevación frontal', 'img/imgTemplate.jpg', 'trenSuperior', 'hombro'),
('Elevación lateral', 'img/imgTemplate.jpg', 'trenSuperior', 'hombro')
;
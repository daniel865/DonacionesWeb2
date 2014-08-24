CREATE TABLE USUARIO (
nroidentificacion_usu varchar(15),
nombres_usu varchar(40),
apellido1_usu varchar(20),
apellido2_usu varchar(20),
usuario_usu  varchar(10),
correo_usu varchar(30),
contrasenia_usu varchar(15),
perfil_usu varchar(20),
estado_usu varchar(15)
);


CREATE TABLE DONANTE(
tipodocumento_don varchar(10),
nroidentificacion_don varchar(20),
nombres_don varchar(50),
apellido1_don varchar(20),
apellido2_don varchar(20),
telefono_don long,
direccion_don varchar(50),
correo_don varchar(30),
fec_nac_don date,
fec_doc_don date,
enfermedades_don varchar(100),
habitos_don  varchar(80),
nom_res_don varchar(50),
tel_res_don long,
genero_don varchar(10),
departamento_don int,
municipio_don int,
estado_don varchar(10)
);


CREATE TABLE HOSPITAL(
nit_hos varchar(10),
tipo_hos varchar(10),
razon_social_hos varchar(50),
nivel_hos varchar(10),
departamento_hos int,
municipio_hos int,
direccion_hos varchar(50),
telefono_hos long,
nombre_rep_hos  varchar(30),
tel_rep_hos long,
correo_rep_hos varchar(30),
estado_hos varchar(10)
);


CREATE TABLE JORNADA(
codigo_jor varchar(10),
descripcion_jor varchar(200),
fecha_jor varchar(15),
departamento_jor int,
municipio_jor int,
direccion_jor varchar(20),
cantidad_donantes_jor int,
sangre_a1_jor int,
sangre_a2_jor int,
sangre_ab1_jor int,
sangre_ab2_jor int,
sangre_b1_jor int,
sangre_b2_jor int,
sangre_o1_jor int,
sangre_o2_jor int,
estado_jor  varchar(10),
observaciones_jor varchar(200)
);


CREATE TABLE BOLSA(
codigo_bol varchar(10),
jornada_don_bol varchar(10),
grupo_sanguineo_bol varchar(10),
rh_bol  varchar(12),
fecha_donacion_bol  varchar(15),
fecha_venci_bol  varchar(15),
cantidad_sangre_bol  int,
estado_bol varchar(10),
observaciones_bol varchar(200)
);

CREATE TABLE DEPARTAMENTO (
id_dep int,
nombre_dep varchar(30)
);

CREATE TABLE MUNICIPIO(
id_mun int,
nombre_mun varchar(30),
departamento_id int
);


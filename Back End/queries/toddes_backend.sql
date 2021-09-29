create database db_toddes;
use db_toddes;

CREATE TABLE `tb_usuario` (
	`id_usuario` bigint NOT NULL AUTO_INCREMENT,
	`email_usuario` varchar(255) NOT NULL,
	`nome_usuario` varchar(255) NOT NULL,
	`senha_usuario` varchar(255) NOT NULL,
	PRIMARY KEY (`id_usuario`)
);

CREATE TABLE `tb_postagem` (
	`id_postagem` bigint NOT NULL AUTO_INCREMENT,
	`fk_id_usuario` bigint NOT NULL,
	`fk_id_tema` bigint NOT NULL,
	`anonimo_postagem` BOOLEAN NOT NULL,
	`texto_postagem` varchar(1000) NOT NULL,
	`data_postagem` DATETIME NOT NULL,
	`titulo_postagem` varchar(255) NOT NULL,
	PRIMARY KEY (`id_postagem`)
);

CREATE TABLE `tb_tema` (
	`id_tema` bigint NOT NULL AUTO_INCREMENT,
	`nome_tema` varchar(255) NOT NULL,
	`descricao_tema` varchar(255),
	`subtema_tema` varchar(255),
	PRIMARY KEY (`id_tema`)
);

ALTER TABLE `tb_postagem` ADD CONSTRAINT `tb_postagem_fk0` FOREIGN KEY (`fk_id_usuario`) REFERENCES `tb_usuario`(`id_usuario`);

ALTER TABLE `tb_postagem` ADD CONSTRAINT `tb_postagem_fk1` FOREIGN KEY (`fk_id_tema`) REFERENCES `tb_tema`(`id_tema`);

select * from tb_postagem;
select * from tb_tema;
select * from tb_usuario;
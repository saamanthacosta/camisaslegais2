create schema loja collate utf8_general_ci;

create table produto
(
	id int auto_increment
		primary key,
	nome varchar(100) not null,
	qtd_disp int null,
	avaliacao float not null,
	imagem varchar(50) null,
	preco float not null
);

create table item
(
	id int not null
		primary key,
	id_produto int not null,
	quantidade int not null,
	total float not null,
	constraint item_produto_fk
		foreign key (id_produto) references produto (id)
);

create table usuario
(
	id int auto_increment
		primary key,
	nome varchar(255) not null,
	email varchar(255) not null,
	senha varchar(255) not null,
	admin tinyint(1) default 0 not null,
	logradouro varchar(100) null,
	complemento varchar(50) null,
	bairro varchar(100) null,
	cidade varchar(100) null,
	uf varchar(2) null,
	cep varchar(8) null,
	constraint usuario_email_uindex
		unique (email)
);

create table avaliacao_usuario
(
	id int not null
		primary key,
	id_usuario int not null,
	id_produto int not null,
	avaliacao int not null,
	constraint avaliacao_usuario_produto_fk
		foreign key (id_produto) references produto (id),
	constraint avaliacao_usuario_usuario_fk
		foreign key (id_usuario) references usuario (id)
);

create table favoritos_usuario
(
	id_usuario int not null,
	id_produto int not null,
	primary key (id_produto, id_usuario),
	constraint favoritos_usuario_fk
		foreign key (id_usuario) references usuario (id),
	constraint favoritos_usuario_produto_fk
		foreign key (id_produto) references produto (id)
);

create table pedido
(
	id int auto_increment
		primary key,
	id_usuario int not null,
	valor_total decimal(10,2) not null,
	data timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
	constraint pedido_usuario_id_fk
		foreign key (id_usuario) references usuario (id)
);

create table item_pedido
(
	id int not null
		primary key,
	id_pedido int not null,
	id_item int not null,
	constraint item_pedido_item_fk
		foreign key (id_item) references item (id),
	constraint item_pedido_pedido_fk
		foreign key (id_pedido) references pedido (id)
);


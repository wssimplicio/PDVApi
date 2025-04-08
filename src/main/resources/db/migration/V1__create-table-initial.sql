create table classificacao (
id serial primary key not null,
descricao varchar(60) not null,
nivel int not null,
idPai int
);

create table marca (
id serial primary key not null,
descricao varchar(60) not null
);

create table produto (
id serial primary key not null,
descricao varchar(150) not null,
descricaoreduzida varchar(60),
embalagem char(4) not null,
qtd_embalagem numeric(10,4) not null,
id_marca int,
id_classificacao int not null,
ncm_codigo varchar(20),
ncm_descricao varchar(255),
cest_codigo int,
cest_descricao varchar(255),
data_criacao timestamp not null,
data_alteracao timestamp,
constraint fk_id_marca foreign key (id_marca) references marca(id),
constraint fk_id_classificacao foreign key (id_classificacao) references classificacao(id)
);

create table produto_ean (
id serial primary key not null,
id_produto int not null,
ean bigint,
embalagem char(4),
qtd_embalagem numeric(10,4),
constraint fk_id_produto foreign key (id_produto) references produto(id)
);

create table produto_preco (
id serial primary key not null,
id_produto int not null,
precovenda numeric(10,4),
custo numeric(10,4),
margem numeric(10,4),
data_criacao timestamp not null,
data_alteracao timestamp,
constraint fk_id_produto foreign key (id_produto) references produto(id)
);

create table produto_estoque (
id serial primary key not null,
id_produto int not null,
estoque numeric(10,4),
estoque_minimo numeric(10,4),
estoque_maximo numeric(10,4),
constraint fk_id_produto foreign key (id_produto) references produto(id)
);


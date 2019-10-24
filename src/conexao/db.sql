create table pessoa (
  id serial primary key,
  nome varchar(50),
  cpf char(11),
  idade integer,
  cidade varchar(50)
);

create table conta (
  id serial primary key,
  pessoa integer references pessoa(id),
  numero integer,
  banco varchar(50),
  saldo float8
);
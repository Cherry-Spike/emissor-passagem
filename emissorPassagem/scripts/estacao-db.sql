create database Estacao
go

use Estacao
go

create table Horario
(
    Id int primary key,
    Hora time not null
)
go

create table Cidade
(
    Id int primary key identity(1,1),
    Nome varchar(100) not null
)
go

create table CidadeHorario
(
    Id int primary key identity(1,1),
    IdCidade  int foreign key references Cidade(Id),
    IdHorario int foreign key references Horario(Id)
)
go

create table Itinerario
(
    Id int primary key identity(1,1),
    IdCidadeEmbarque  int foreign key references Cidade(Id),
    IdCidadeDesembarque  int foreign key references Cidade(Id),
    QtdPassagem int not null
)
go

create table Passagem
(
    Id int primary key identity(1,1),
    IdItinerario int foreign key references Itinerario(Id),
    Qrcode varchar(200),
    Logo varchar(200),
    Numero bigint
)
go

create table Trem
(
    Id int primary key identity(1,1),
    TotalAssento int not null,
    AssentoDisponivel int,
    IdCidadeInicial  int foreign key references Cidade(Id),
    IdCidadeFinal  int foreign key references Cidade(Id),
)
go
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

create table Estacao
(
    Id int primary key identity(1,1),
    Nome varchar(100) not null
)
go

create table EstacaoHorario
(
    Id int primary key identity(1,1),
    IdEstacao  int foreign key references Estacao(Id),
    IdHorario int foreign key references Horario(Id)
)
go

create table Itinerario
(
    Id int primary key identity(1,1),
    IdEstacaoEmbarque  int foreign key references Estacao(Id),
    IdHorarioEmbarque int foreign key references Horario(Id),
    IdEstacaoDesembarque  int foreign key references Estacao(Id),
    IdHorarioDesembarque int foreign key references Horario(Id),
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
    IdEstacaoInicial  int foreign key references Estacao(Id),
    IdEstacaoFinal  int foreign key references Estacao(Id),
)
go
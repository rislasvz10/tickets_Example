DROP TABLE IF EXISTS Ticket;

CREATE TABLE `Ticket` (
  `ItineraryID` int(11) NOT NULL AUTO_INCREMENT,
  `FechaSalida` date NOT NULL,
  `FechaLlegada` date NOT NULL,
  `ORIGEN` varchar(200) NOT NULL,
  `DESTINO` varchar(200) NOT NULL,
  `NOMBRE` varchar(200) NOT NULL,
  `EDAD` int(11) NOT NULL,
  `EQUIPAJE` char(1) NOT NULL,
  `PRECIO` decimal(18,2) NOT NULL,
  `HORASALIDA` time NOT NULL,
  `HORALLEGADA` time NOT NULL,
  PRIMARY KEY (`ItineraryID`)
);

CREATE TABLE `ErrorCatalog` (
  `id_error` int(11) not null AUTO_INCREMENT,
  `prefijo` varchar(5) not null,
  `modulo` varchar(5) not null,
  `mns_org` int(6) not null,
  `med_ent` int(3) not null,
  `idioma` int(1) not null,
  `descmns` varchar(100) not null,
  PRIMARY KEY (`id_error`)
);
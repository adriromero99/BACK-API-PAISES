
CREATE TABLE Paises (
                        Id int PRIMARY KEY,
                        Nombre varchar(255),
                        CantidadHabitantes int,
                        Tamanio int
);

INSERT INTO Paises (Id, Nombre, CantidadHabitantes, Tamanio) VALUES (1, 'Argentina', 42000000,300000);
INSERT INTO Paises (Id, Nombre, CantidadHabitantes, Tamanio) VALUES (2, 'Brasil', 100000000, 600000);
INSERT INTO Paises (Id, Nombre, CantidadHabitantes, Tamanio) VALUES (3, 'USA',  150000000, 800000);
INSERT INTO Paises (Id, Nombre, CantidadHabitantes, Tamanio) VALUES (4, 'Uruguay', 3000000, 5000);

CREATE TABLE Provincias (
                         Id int PRIMARY KEY,
                         Nombre varchar(255),
                         PaisId int,
                         FOREIGN KEY (PaisId) references Paises(Id)
);

INSERT INTO Provincias (Id, Nombre, PaisId) VALUES (1, 'Buenos Aires', 1);
INSERT INTO Provincias (Id, Nombre, PaisId) VALUES (2, 'Cordoba', 1);
INSERT INTO Provincias (Id, Nombre, PaisId) VALUES (3, 'Rio Negro', 1);
INSERT INTO Provincias (Id, Nombre, PaisId) VALUES (4, 'Santa Cruz', 1);
INSERT INTO Provincias (Id, Nombre, PaisId) VALUES (5, 'Tucuman', 1);
INSERT INTO Provincias (Id, Nombre, PaisId) VALUES (6, 'Misiones', 1);

INSERT INTO Provincias (Id, Nombre, PaisId) VALUES (7, 'Florida', 3);
INSERT INTO Provincias (Id, Nombre, PaisId) VALUES (8, 'New York', 3);
INSERT INTO Provincias (Id, Nombre, PaisId) VALUES (9, 'New Mexico', 3);
INSERT INTO Provincias (Id, Nombre, PaisId) VALUES (10, 'Texas', 3);
INSERT INTO Provincias (Id, Nombre, PaisId) VALUES (11, 'California', 3);
INSERT INTO Provincias (Id, Nombre, PaisId) VALUES (12, 'Minnesota', 3);

INSERT INTO Provincias (Id, Nombre, PaisId) VALUES (13, 'Artigas', 4);
INSERT INTO Provincias (Id, Nombre, PaisId) VALUES (14, 'Salto', 4);
INSERT INTO Provincias (Id, Nombre, PaisId) VALUES (15, 'Colonia', 4);

CREATE TABLE Actividades (
                        Id int PRIMARY KEY,
                        Nombre varchar(255),
                        Categoria varchar(255)
);

INSERT INTO Actividades (Id, Nombre, Categoria) VALUES (1, 'Pesca', 'Producto');
INSERT INTO Actividades (Id, Nombre, Categoria) VALUES (2, 'Ganaderia', 'Producto');
INSERT INTO Actividades (Id, Nombre, Categoria) VALUES (3, 'Vinos', 'Producto');
INSERT INTO Actividades (Id, Nombre, Categoria) VALUES (4, 'Tecnologia', 'Servicio');


CREATE TABLE PaisActividadesRelaciones(
                                     PaisId varchar(255) NOT NULL,
                                     ActividadId varchar(255) NOT NULL,
                                     FOREIGN KEY (PaisID) REFERENCES Paises(Id),
                                     FOREIGN KEY (ActividadID) REFERENCES Actividades(Id),
                                     UNIQUE (PaisId, ActividadId)
);

INSERT INTO PaisActividadesRelaciones (PaisId, ActividadId) VALUES (1, 1);
INSERT INTO PaisActividadesRelaciones (PaisId, ActividadId) VALUES (1, 2);
INSERT INTO PaisActividadesRelaciones (PaisId, ActividadId) VALUES (1, 3);

INSERT INTO PaisActividadesRelaciones (PaisId, ActividadId) VALUES (2, 1);
INSERT INTO PaisActividadesRelaciones (PaisId, ActividadId) VALUES (2, 2);
INSERT INTO PaisActividadesRelaciones (PaisId, ActividadId) VALUES (2, 4);

INSERT INTO PaisActividadesRelaciones (PaisId, ActividadId) VALUES (3, 2);
INSERT INTO PaisActividadesRelaciones (PaisId, ActividadId) VALUES (3, 4);

INSERT INTO PaisActividadesRelaciones (PaisId, ActividadId) VALUES (4, 2);


//Obtener los nombres de todos los paises que realizan pesca.
//SELECT Paises.Nombre FROM PaisActividadesRelaciones JOIN Paises ON Paises.Id = PaisActividadesRelaciones.PaisId JOIN Actividades ON Actividades.Id = PaisActividadesRelaciones.ActividadId WHERE Actividades.Nombre = 'Pesca'

//Obtener los nombres de todas las actividades que realiza USA.
//SELECT Actividades.Nombre FROM PaisActividadesRelaciones JOIN Paises ON Paises.Id = PaisActividadesRelaciones.PaisId JOIN Actividades ON Actividades.Id = PaisActividadesRelaciones.ActividadId WHERE Paises.Nombre = 'USA'

//Obtener todos los nombres de las provincias de Argentina
//SELECT Provincias.Nombre FROM Provincias JOIN Paises ON Provincias.PaisId = Paises.Id WHERE Paises.Nombre = 'Argentina'

//Obtener los nombres de todos las actividades que se realizan en Argentina que son productos
//SELECT Actividades.Nombre FROM PaisActividadesRelaciones JOIN Paises ON Paises.Id = PaisActividadesRelaciones.PaisId JOIN Actividades ON Actividades.Id = PaisActividadesRelaciones.ActividadId WHERE Paises.Nombre = 'Argentina' AND Actividades.Categoria = 'Producto'

//Algunas referencias

//SELECT * FROM Provincias Pr, Paises Pa WHERE Pr.PaisId = Pa.Id
//SELECT Paises.Nombre, Actividades.Nombre FROM PaisActividadesRelaciones JOIN Paises ON Paises.Id = PaisActividadesRelaciones.PaisId JOIN Actividades ON Actividades.Id = PaisActividadesRelaciones.ActividadId
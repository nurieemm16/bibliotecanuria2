CREATE DATABASE bibliotecanuria;
USE bibliotecanuria;
CREATE TABLE Usuario (
	id_Usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre_Usuario VARCHAR(250) NOT NULL,
    rol VARCHAR (50) NOT NULL
);

CREATE TABLE MiembroPremium (
	id_MP INT AUTO_INCREMENT PRIMARY KEY,
    nombre_MP VARCHAR(250) NOT NULL,
    rol VARCHAR (50) NOT NULL
);
CREATE TABLE Autor (
	id_Autor INT AUTO_INCREMENT PRIMARY KEY,
    nombre_Autor VARCHAR(250) NOT NULL,
    anoNacimiento INT NOT NULL,
    anoMuerte INT
);
CREATE TABLE Libro (
	id_Libro INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(250) NOT NULL,
    autor VARCHAR(250) NOT NULL,
    disponibilidad BOOLEAN NOT NULL DEFAULT TRUE
);
CREATE TABLE Autor_Libro ( -- AUTOR HAS LIBROS
	id_Autor INT,
    nombre_Autor VARCHAR(250),
    id_Libro INT,
    titulo VARCHAR(250),
    PRIMARY KEY (id_Autor, id_Libro),
    FOREIGN KEY (id_Autor) REFERENCES Autor(id_Autor),
    FOREIGN KEY (id_Libro) REFERENCES Libro(id_Libro)
);
CREATE TABLE Usuario_LibrosPrestados ( -- USUARIO HAS LIBROS PRESTADOS
	id_Usuario INT,
    nombre_Usuario VARCHAR(250),
    id_Libro INT,
    titulo VARCHAR(250),
    PRIMARY KEY (id_Usuario, id_Libro),
    FOREIGN KEY (id_Usuario) REFERENCES Usuario(id_Usuario),
    FOREIGN KEY (id_Libro) REFERENCES Libro(id_Libro)
);
CREATE TABLE MP_LibrosPrestados ( -- MIEMBRO PREMIUM HAS LIBROS PRESTADOS
	id_MP INT,
    nombre_MP VARCHAR(250),
    id_Libro INT,
    titulo VARCHAR(250),
    PRIMARY KEY (id_MP, id_Libro),
    FOREIGN KEY (id_MP) REFERENCES MiembroPremium(id_MP),
    FOREIGN KEY (id_Libro) REFERENCES Libro(id_Libro)
);
CREATE TABLE MP_LibrosReservados ( -- MIEMBRO PREMIUM HAS LIBROS RESERVADOS
	id_MP INT,
    nombre_MP VARCHAR(250),
    id_Libro INT,
    titulo VARCHAR(250),
    PRIMARY KEY (id_MP, id_Libro),
    FOREIGN KEY (id_MP) REFERENCES MiembroPremium(id_MP),
    FOREIGN KEY (id_Libro) REFERENCES Libro(id_Libro)
);
COMMIT;

INSERT INTO Usuario (nombre_Usuario, rol)
VALUES
('Núria Marzo', 'usuario'),
('Maya Moliner', 'usuario');

INSERT INTO MiembroPremium (nombre_MP, rol)
VALUES
('Àlex Ramos', 'miembro premium'),
('Toni Usón', 'miembro premium'),
('Dolors Lluen','miembro premium');
INSERT INTO Autor (nombre_Autor, anoNacimiento, anoMuerte)
VALUES
('Santiago Posteguillo', 1967, NULL),
('Brandon Sanderson', 1975, NULL),
('Carlos Ruiz Zafón', 1964, 2020),
('Ken Follett', 1949, NULL);
INSERT INTO Libro (titulo, autor, disponibilidad)
VALUES
('Yo, Julia', 'Santiago Posteguillo', TRUE),
('Roma soy yo', 'Santiago Posteguillo', TRUE),
('El aliento de los Dioses', 'Brandon Sanderson', TRUE),
('Elantris', 'Brandon Sanderson', TRUE),
('La sombra del viento', 'Carlos Ruiz Zafón', TRUE),
('Marina', 'Carlos Ruiz Zafón', TRUE),
('Los Pilares de la tierra', 'Ken Follett', TRUE),
('La Caída de los Gigantes', 'Ken Follett', TRUE);



-- CONSULTAR TABLAS --
	-- Consultar todos los elementos de cada tabla --
		SELECT * FROM Usuario;
		SELECT * FROM MiembroPremium;
        SELECT * FROM Autor;
		SELECT * FROM Libro;
	-- Lista libros prestados por usuarios(usuarios normales) --
        SELECT * FROM Usuario_LibrosPrestados;
	-- Lista libros prestados por miembros premium --
        SELECT * FROM MP_LibrosPrestados;
	-- Libros Reservados por MP Miembros Premium --
		SELECT * FROM MP_LibrosReservados;
	
    -- Lista de libros por autor
		SELECT a.id_autor, l.autor, l.id_libro, l.titulo
        FROM Libro l
        INNER JOIN Autor a ON l.autor = a.nombre_autor
        ORDER BY a.id_Autor ASC;
		-- Santiago Posteguillo --
		SELECT a.id_Autor, a.nombre_Autor AS autor, l.id_Libro, l.titulo
        FROM Autor a
        INNER JOIN Libro l ON a.nombre_Autor = l.autor
        WHERE a.nombre_Autor LIKE 'Santiago Posteguillo';
        SELECT l.id_Libro, l.titulo, l.disponibilidad FROM Libro l
        INNER JOIN Autor a ON l.autor = a.nombre_Autor
        WHERE a.nombre_Autor LIKE 'Santiago Posteguillo';
		
        -- Brandon Sanderson--
        SELECT a.id_Autor, a.nombre_Autor AS autor, l.id_Libro, l.titulo
        FROM Autor a
        INNER JOIN Libro l ON a.nombre_Autor = l.autor
        WHERE a.nombre_Autor LIKE 'Brandon Sanderson';
        -- Carlos Ruiz Zafón--
        SELECT a.id_Autor, a.nombre_Autor AS autor, l.id_Libro, l.titulo
        FROM Autor a
        INNER JOIN Libro l ON a.nombre_Autor = l.autor
        WHERE a.nombre_Autor LIKE 'Carlos Ruiz Zafón';
        -- Ken Follett--
        SELECT a.id_Autor, a.nombre_Autor AS autor, l.id_Libro, l.titulo
        FROM Autor a
        INNER JOIN Libro l ON a.nombre_Autor = l.autor
        WHERE a.nombre_Autor LIKE 'Ken Follett';
	-- Mercè Rodoreda
    
        SELECT a.id_Autor, a.nombre_Autor AS autor, l.id_Libro, l.titulo
        FROM Autor a
        INNER JOIN Libro l ON a.nombre_Autor = l.autor
        WHERE a.nombre_Autor LIKE 'Mercè Rodoreda';
	

        -- Tabla libros prestados por usuario si existen el libro y el usuario en cuestión

        INSERT INTO Usuario_LibrosPrestados (id_Usuario, nombre_Usuario, id_Libro, titulo)
	    SELECT u.id_Usuario, u.nombre_Usuario, l.id_Libro, l.titulo
        FROM Usuario u , Libro l
        WHERE u.nombre_Usuario= "Marc Guasch" and l.titulo = "Marina" and EXISTS(
        SELECT 1
        FROM Usuario u , Libro l
        WHERE u.nombre_Usuario = "Marc Guasch"  and l.titulo = "Marina");
        
        -- Tabla libros prestados por usuario 
        
        INSERT INTO Usuario_LibrosPrestados (id_Usuario, nombre_Usuario, id_Libro, titulo) 
        SELECT u.id_Usuario, u.nombre_Usuario, l.id_Libro, l.titulo 
        FROM Usuario u, Libro l 
        WHERE u.nombre_Usuario = "Marc Guasch" and l.titulo = "Elantris";
	
    
   -- Tabla LIBROS PRESTADOS
SELECT l.titulo, l.disponibilidad
FROM Libro l
INNER JOIN Usuario_LibrosPrestados ulp ON l.titulo = ulp.titulo
WHERE ulp.titulo IS NOT NULL;
	
COMMIT;

        SELECT 1
        FROM Usuario u , Libro l
        WHERE u.nombre_Usuario = "wowowo"  and l.titulo = "provas");
        select * from Usuario_LibrosPrestados;
        select * from libro;
        SELECT nombre_usuario from usuario;
        INSERT INTO Usuario_LibrosPrestados (id_Usuario, nombre_Usuario, id_Libro, titulo)
        SELECT u.id_Usuario, u.nombre_Usuario, l.id_Libro, l.titulo
        FROM Usuario u, Libro l
        WHERE u.nombre_Usuario = "Maria Ferrer"  and l.titulo = "Harry Potter";
        commit;
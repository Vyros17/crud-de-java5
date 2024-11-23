-- Crear Base de Datos por nombre: "Conssesionaire".
-- Modificar la contraseña de "application.properties", de ser necesario.
-- Para las tablas Usar el siguiente query, de ser necesario.

CREATE TABLE IF NOT EXISTS Colors(
ID_Color SERIAL PRIMARY KEY,
Color VARCHAR(15) NOT NULL
);
CREATE TABLE IF NOT EXISTS Cars(
ID_Car SERIAL PRIMARY KEY,
Plate VARCHAR(30),
ID_Color INT,
CONSTRAINT FK_Color
	FOREIGN KEY(ID_Color)
	REFERENCES Colors(ID_Color),
Brand VARCHAR(30),
Model VARCHAR(30),
Speed DECIMAL
);
CREATE TABLE IF NOT EXISTS Services(
ID_Service SERIAL PRIMARY KEY,
Service_Type VARCHAR(30)
);
CREATE TABLE IF NOT EXISTS Cars_Services(
ID_Car_Service SERIAL PRIMARY KEY,
ID_Car INT,
ID_Service INT,
CONSTRAINT FK_Car
	FOREIGN KEY(ID_Car)
	REFERENCES Cars(ID_Car),
CONSTRAINT FK_Service
	FOREIGN KEY(ID_Service)
	REFERENCES Services(ID_Service)
);
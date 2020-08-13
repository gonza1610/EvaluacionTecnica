
INSERT INTO Producto (nombre,precio) VALUES('Fideos', 45);
INSERT INTO Producto (nombre,precio) VALUES('Manteca', 30);
INSERT INTO Producto (nombre,precio) VALUES('Asado', 450);
INSERT INTO Producto (nombre,precio) VALUES('Torta', 120);
INSERT INTO Producto (nombre,precio) VALUES('Caramelos', 50);
INSERT INTO Producto (nombre,precio) VALUES('Ravioles', 300);
INSERT INTO Producto (nombre,precio) VALUES('Ñoquis', 200);
INSERT INTO Producto (nombre,precio) VALUES('Queso', 350);
INSERT INTO Producto (nombre,precio) VALUES('Panqueques', 130);
INSERT INTO Producto (nombre,precio) VALUES('Mayonesa', 60);

INSERT INTO Usuario (nombre,password,dni,tipo_usuario) VALUES('Nicolas','Negro', 45250369,true);
INSERT INTO Usuario (nombre,password,dni,tipo_usuario) VALUES('Gabriel','Gimenez', 46859969,false);
INSERT INTO Usuario (nombre,password,dni,tipo_usuario) VALUES('Florencia','Gomez', 20589658,false);

INSERT INTO Carrito (tipo,dni_usuario) VALUES('VIP', 45250369);
INSERT INTO Carrito (tipo,dni_usuario) VALUES('COMUN', 46859969);
INSERT INTO Carrito (tipo,dni_usuario) VALUES('COMUN', 46859969);
INSERT INTO Carrito (tipo,dni_usuario) VALUES('ESPECIAL', 20589658);

INSERT INTO carrito_productos (productos_id,carrito_id) VALUES(2, 1);
INSERT INTO carrito_productos (productos_id,carrito_id) VALUES(3, 1);
INSERT INTO carrito_productos (productos_id,carrito_id) VALUES(6, 1);
INSERT INTO carrito_productos (productos_id,carrito_id) VALUES(7, 1);
INSERT INTO carrito_productos (productos_id,carrito_id) VALUES(8, 1);

INSERT INTO carrito_productos (productos_id,carrito_id) VALUES(2, 2);
INSERT INTO carrito_productos (productos_id,carrito_id) VALUES(3, 2);
INSERT INTO carrito_productos (productos_id,carrito_id) VALUES(6, 2);
INSERT INTO carrito_productos (productos_id,carrito_id) VALUES(7, 2);
INSERT INTO carrito_productos (productos_id,carrito_id) VALUES(5, 2);

INSERT INTO carrito_productos (productos_id,carrito_id) VALUES(1, 3);
INSERT INTO carrito_productos (productos_id,carrito_id) VALUES(1, 3);
INSERT INTO carrito_productos (productos_id,carrito_id) VALUES(1, 3);
INSERT INTO carrito_productos (productos_id,carrito_id) VALUES(4, 3);
INSERT INTO carrito_productos (productos_id,carrito_id) VALUES(4, 3);
INSERT INTO carrito_productos (productos_id,carrito_id) VALUES(2, 3);
INSERT INTO carrito_productos (productos_id,carrito_id) VALUES(9, 3);
INSERT INTO carrito_productos (productos_id,carrito_id) VALUES(7, 3);
INSERT INTO carrito_productos (productos_id,carrito_id) VALUES(8, 3);
INSERT INTO carrito_productos (productos_id,carrito_id) VALUES(10, 3);

INSERT INTO carrito_productos (productos_id,carrito_id) VALUES(2, 4);
INSERT INTO carrito_productos (productos_id,carrito_id) VALUES(3, 4);
INSERT INTO carrito_productos (productos_id,carrito_id) VALUES(6, 4);
INSERT INTO carrito_productos (productos_id,carrito_id) VALUES(7, 4);
INSERT INTO carrito_productos (productos_id,carrito_id) VALUES(8, 4);
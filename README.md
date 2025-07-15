# SalesControl

## Probá la aplicación en Postman
Asegurate de que tu backend esté corriendo en localhost:8080

📌 ## Tip
Todos los cuerpos para POST y PUT ya están preparados en la colección.
Podés duplicar requests para probar con distintos datos.

Usá los endpoints según el módulo que quieras testear:

## Productos (/products)
POST
/create -> crea un nuevo producto.

GET
/ -> lista todos los productos.

GET
/{id} -> busca un producto por ID.

PUT
/update -> actualiza un producto existente.

DELETE
/delete/{id} -> elimina un producto.

## Clientes (/customers)
POST
/create: crea un nuevo cliente.

GET
/ -> lista todos los clientes.

GET
/{id} -> busca un cliente por ID.

PUT
/update -> actualiza un cliente existente.

DELETE
/delete/{id} -> elimina un cliente.

## Vendedores (/sellers)
POST
/create: crea un nuevo vendedor.

GET
/ -> lista todos los vendedores.

GET
/{id} -> busca un vendedor por ID.

PUT
/update -> actualiza un vendedor existente.

DELETE
/delete/{id} -> elimina un vendedor.

## Ventas (/sales)
POST /create -> registra una venta.

GET / -> lista todas.

GET /{id} -> obtiene una venta puntual.

PUT /update -> modifica una venta.

DELETE /delete/{id} -> elimina una.

GET /products/{id} -> muestra los productos de una venta.

GET /date/{yyyy-MM-dd} -> filtra ventas por fecha.

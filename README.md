# Gestion_Prestamo
Servicio API REST para la Gestión de Préstamos.

Metodos configurados:
DELETE: http://localhost:8080/api/getPrestamo/delete/{#a eliminar}

GET: http://localhost:8080/api/getPrestamo/all\

POST (crea un prestamo de acuerdo a un id de cliente): http://localhost:8080/api/getPrestamo/create/3
Cuerpo del Body: 
{
    "monto_Prestamo": 25200,
    "fecha": "2024-10-05",
    "estado_Prestamo": "En Revision, Aprobado o Rechazado"
}

PUT (Actualiza un prestamo enviando el body): http://localhost:8080/api/getPrestamo/prestamoUpdate 
Body:
{
    "id_Cliente": 3,
    "id_Prestamo": 9,
    "monto_Prestamo": "25200",
    "fecha": "2024-10-04",
    "estado_Prestamo": "Aprobado"
}

PATCH (Actualiza un dato parcial, utilizando un id de prestamo): http://localhost:8080/api/getPrestamo/anUpdate/6
Body: 
{
    "estado_Prestamo": "Rechazado"
}

const apiUrlPrestamo = "http://localhost:8080/api/getPrestamo";
const apiUrlCliente = "http://localhost:8080/api/getCliente";

document.addEventListener("DOMContentLoaded", () => {
    cargarClientes();
    cargarPrestamos();
});

document.getElementById("clientForm").addEventListener("submit", function(event) {
    event.preventDefault();
    crearCliente();
});


document.getElementById("loanForm").addEventListener("submit", function(event) {
    event.preventDefault();
    crearPrestamo();
});


function cargarClientes() {
    fetch(`${apiUrlCliente}/all`)
        .then(response => response.json())
        .then(clientes => {
            const clienteSelect = document.getElementById("clienteId");
            clienteSelect.innerHTML = clientes.map(cliente =>
                `<option value="${cliente.id_Cliente}">${cliente.nombre_Cliente}</option>`
            ).join('');
        })
        .catch(error => console.error("Error al cargar clientes:", error));
}

function cargarPrestamos() {
    fetch(`${apiUrlPrestamo}/all`)
        .then(response => response.json())
        .then(data => {
            const prestamosTableBody = document.querySelector('table tbody');
            prestamosTableBody.innerHTML = '';
            data.forEach(prestamo => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${prestamo.id_Prestamo}</td>
                    <td>${prestamo.cliente.nombre_Cliente}</td>
                    <td>${prestamo.monto_Prestamo}</td>
                    <td>${prestamo.estatus}</td>
                    <td>${prestamo.fecha}</td>
                    <td>
                        <button class="btn btn-danger btn-sm" onclick="eliminarPrestamo(${prestamo.id_Prestamo})">Eliminar</button>
                    </td>
                `;
                prestamosTableBody.appendChild(row);
            });
        })
        .catch(error => console.error("Error al cargar préstamos:", error));
}

function crearCliente() {
    const nombreCliente = document.getElementById("nombreCliente").value;
    fetch(`${apiUrlCliente}/create`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ nombre_Cliente: nombreCliente })
    })
    .then(response => response.json())
    .then(data => {
        alert("Cliente creado con éxito!");
        cargarClientes();
    })
    .catch(error => console.error("Error al crear cliente:", error));
}


function crearPrestamo() {
    const clienteId = document.getElementById("clienteId").value;
    const monto = document.getElementById("monto").value;
    const estatus = document.getElementById("estatus").value;
    const fecha = document.getElementById("fecha").value;

    fetch(`${apiUrlPrestamo}/create/${clienteId}`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ monto_Prestamo: monto, estatus: estatus, fecha: fecha })
    })
    .then(response => response.json())
    .then(data => {
        alert("Préstamo creado con éxito!");
        cargarPrestamos();
    })
    .catch(error => console.error("Error al crear préstamo:", error));
}

function eliminarPrestamo(id_Prestamo) {
    fetch(`${apiUrlPrestamo}/delete/${id_Prestamo}`, {
        method: "DELETE"
    })
    .then(response => {
        if (response.ok) {
            alert("Préstamo eliminado con éxito!");
            cargarPrestamos();
        } else {
            return response.text().then(text => {
                throw new Error(text || "Error desconocido al eliminar préstamo");
            });
        }
    })
    .catch(error => {
        console.error("Error al eliminar préstamo:", error);
        alert("Hubo un problema al eliminar el préstamo.");
    });
}

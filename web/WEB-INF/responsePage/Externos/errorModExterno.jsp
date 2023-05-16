<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="js/main.js"></script>

        <link rel="icon" href="image/icon.jpg">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <title>Externos</title>
    </head>
    <body id="body-pd">
        <header class="header" id="header">
            <div class="header_toggle"> <i class='bx bx-menu text-light' id="header-toggle"></i> </div>
            <div class="d-flex justify-content-around m-0 p-0">
                <a href="notificacionesController?action=home" class="btn text-light fs-6 position-relative bg-transparent p-0">
                    <i class="fas fa-bell animacion fs-5"></i>
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                        ${notification}
                    </span>
                </a>
                <div class="d-flex justify-content-center text-light ms-3"><c:forEach var="c" items="${user}"><i class="fas fa-user me-2 fs-5"></i>${c.nombre_user} ${c.apellido_user}</c:forEach></div>                
                </div>
            </header>
            <div class="l-navbar" id="nav-bar">
                <nav class="nav fw-bold">
                    <div> <a href="#" class="nav_logo text-secondary "><img src="image/logo.png" class="img-fluid icon_hov" alt=""><span class="nav_logo-name">Menu</span> </a>
                        <div class="nav_list"> <a href="inicioController?action=home" class="nav_link active"> <i class='bx bx-grid-alt nav_icon icon_hov'></i> <span class="nav_name">Inicio</span> </a> 
                            <a href="internosController?action=home" class="nav_link"> <i class='bx bx-user nav_icon icon_hov'></i> <span class="nav_name">Internos</span></a>
                            <a href="externosController?action=home" class="nav_link"><i class="far fa-user icon_hov"></i><span class="nav_name">Externos</span></a>
                            <a href="usuarioController?action=home" class="nav_link"> <i class="fas fa-user-friends icon_hov"></i><span class="nav_name">Usuarios</span></a>
                            <a href="#" class="nav_link"><i class="fas fa-book icon_hov"></i><span class="nav_name">Manuales</span> </a> 
                            <a href="jefesController?action=home" class="nav_link"> <i class="far fa-address-card icon_hov"></i><span class="nav_name">Contactos</span> </a>
                            <a href="contactoController?action=home" class="nav_link"> <i class="fas fa-tablet-alt icon_hov"></i><span class="nav_name">Más Aplicaciones</span> </a>
                            <a href="representantesController?action=home" class="nav_link"> <i class="fas fa-users icon_hov"></i><span class="nav_name">Representantes</span> </a>
                            <a href="alliedController?action=home" class="nav_link"><img src="image/icon_global.jpeg" width="20" height="20" alt="alt" class="icon_hov rounded-2"/>Allied Global</a>
                        </div>
                    </div> 
                    <a href="#" class="nav_link" id="logout"> <i class='bx bx-log-out nav_icon icon_hov'></i> <span class="nav_name">Cerrar Sesión</span> </a>
                </nav>
            </div>

            <div class="container-fluid p-5">
                <div class="d-flex justify-content-center">
                    <span class="fs-1 mt-5 border-bottom border-2 mb-3">Externos</span>
                </div>
                <div class="container-fluid text-center">
                    <svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
                    <symbol id="check-circle-fill" fill="currentColor" viewBox="0 0 16 16">
                        <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                    </symbol>
                    <symbol id="info-fill" fill="currentColor" viewBox="0 0 16 16">
                        <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
                    </symbol>
                    <symbol id="exclamation-triangle-fill" fill="currentColor" viewBox="0 0 16 16">
                        <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
                    </symbol>
                    </svg>
                    <div class="alert alert-danger d-flex align-items-center" role="alert" id="alert">
                        <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Danger:"><use xlink:href="#exclamation-triangle-fill"/></svg>
                        <div>
                            No se pudo modificar porque el codigo del distribuidor no existe, intente nuevamente.
                        </div>
                    </div>
                </div>
                <div class="d-flex justify-content-start">
                    <!-- Button trigger modal -->
                    <button type="button" class="btn me-2 text-light" data-bs-toggle="modal" data-bs-target="#staticBackdrop" style="background-color:rgb(185, 17, 0); ">
                        Nuevo Externo<i class="fas fa-plus ms-1"></i>
                    </button>  
                    <!-- Modal -->
                    <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-scrollable">
                            <div class="modal-content">
                                <div class="modal-header text-light" style="background-color: rgb(185, 17, 0) !important;">
                                    <h5 class="modal-title" id="staticBackdropLabel">Agregar Externo</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <div class="container-fluid">
                                        <form action="externosController?action=insert" method="post" class="needs-validation font" novalidate>
                                            <div class="container m-0 p-0 mb-3">
                                                <div class="alert alert-warning" role="alert">
                                                    <figure class="d-flex justify-content-center">
                                                        <img src="image/warning.gif" width="40" height="40" class="me-2 text-center"/>
                                                    </figure>
                                                    IMPORTANTE: Antes de registrar un externo tiene que existir el distribuidor del mismo.
                                                </div>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input type="text" class="form-control" id="floatingInput" placeholder="name@example.com" name="cod" required>
                                                <label for="floatingInput">Codigo de empleado</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input type="text" class="form-control" id="floatingInput" placeholder="name@example.com" name="nombre"required>
                                                <label for="floatingInput">Nombre</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input type="text" class="form-control" id="floatingInput" placeholder="name@example.com" name="apellido" required>
                                                <label for="floatingInput">Apellido</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input type="date" class="form-control" id="floatingInput" placeholder="name@example.com" name="fecha_nac">
                                                <label for="floatingInput">Fecha de Nacimiento</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input type="text" class="form-control" id="floatingInput" placeholder="name@example.com" name="diu" required>
                                                <label for="floatingInput">DUI</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com" name="email" required>
                                                <label for="floatingInput">Correo Electronico</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input type="text" class="form-control" id="floatingInput" placeholder="name@example.com" name="observaciones">
                                                <label for="floatingInput">Observaciones</label>
                                            </div>
                                            <div class="row g-xl-2">
                                                <div class="col-xl-6">
                                                    <div class="form-floating mb-3">
                                                        <input type="text" class="form-control" id="floatingInput" placeholder="name@example.com" name="cod_dis" required>
                                                        <label for="floatingInput">Codigo Distribuidor</label>
                                                    </div>
                                                </div>
                                                <div class="col-xl-6 align-self-center">
                                                    <div class="mb-3">
                                                        <select id="" class="form-select" name="idPaisDist" required>
                                                            <option selected = "true" disabled>Seleccion el Pais</option>
                                                        <c:forEach var="c" items="${p}">
                                                            <option value="${c.idPais}">${c.pais}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="mb-4">
                                            <select id="" class="form-select" name="idPais" required>
                                                <option selected = "true" disabled>Seleccion el Pais</option>
                                                <c:forEach var="c" items="${p}">
                                                    <option value="${c.idPais}">${c.pais}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <button class="btn btn-outline-danger w-100">Registrar</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="height-100">
            <div class="d-flex justify-content-center text-center">
                <span class="fs-2 font">Externos Registrados</span>
            </div>
            <div class="container-fluid m-0  p-0">
                <div class="table-responsive">
                    <table class="table table-bordered table-hover mt-1" id="myTable">
                        <thead class="text-light" style="background-color: rgb(185, 17, 0);">
                        <th>Codigo de Empleado</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Fecha de Nacimiento</th>
                        <th>DUI</th>
                        <th>Correo Electronico</th>
                        <th>Distribuidor</th>
                        <th>Encargado</th>
                        <th>Correo Encargado</th>                        
                        <th>Estado</th>
                        <th>Pais</th> 
                        <th></th>
                        </thead>
                        <tbody class="fs-6">
                            <c:forEach var="c" items="${externos}">
                                <tr>
                                    <td>${c.cod_emp}</td>
                                    <td>${c.nombre_emp}</td>                                  
                                    <td>${c.apellido_emp}</td>
                                    <td>${c.fecha_nac}</td>
                                    <td>${c.diu}</td>
                                    <td>${c.email}</td>
                                    <td>${c.distribuidor}</td>
                                    <td>${c.encargado}</td>
                                    <td>${c.correo_responsable}</td>
                                    <td class="status"><a href="externosController?action=profile&codEmp=${c.idexterno}" class="color-status btn">${c.estado}</a></td>
                                    <td>${c.pais}</td>
                                    <td class="text-center"><a href="externosController?action=modify&idexterno=${c.idexterno}" class="btn btn-success me-1"><i class="fas fa-pen"></i></a></td>
                                </tr>                                
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>                   
        <link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css"/>
        <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script>
            // Example starter JavaScript for disabling form submissions if there are invalid fields
            (function () {
                'use strict'

                // Fetch all the forms we want to apply custom Bootstrap validation styles to
                var forms = document.querySelectorAll('.needs-validation')

                // Loop over them and prevent submission
                Array.prototype.slice.call(forms)
                        .forEach(function (form) {
                            form.addEventListener('submit', function (event) {
                                if (!form.checkValidity()) {
                                    event.preventDefault()
                                    event.stopPropagation()
                                }

                                form.classList.add('was-validated')
                            }, false)
                        })
            })()
        </script>
        <script>
            $(document).ready(function () {
                $('#myTable').DataTable({
                    "language": {
                        lengthMenu: "Mostrar _MENU_ registros",
                        zeroRecords: "No se encontraron resultados",
                        info: "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
                        infoEmpty: "Mostrando registros del 0 al 0 de un total de 0 registros",
                        infoFiltered: "(Filtrando de un total de _MAX_ registros)",
                        sSearch: "Buscar:",
                        oPaginate: {
                            sFirst: "Primero",
                            sLast: "Ultimo",
                            sNext: "Siguiente",
                            sPrevious: "Anterior"
                        },
                        sProcessing: "Procesando...",

                    }
                });
                $('#myTable_2').DataTable({
                    "bPaginate": false,
                    "bFilter": false,
                    "bInfo": false,
                    "language": {
                        lengthMenu: "Mostrar _MENU_ registros",
                        zeroRecords: "No se encontraron resultados",
                        info: "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
                        infoEmpty: "Mostrando registros del 0 al 0 de un total de 0 registros",
                        infoFiltered: "(Filtrando de un total de _MAX_ registros)",
                        sSearch: "Buscar:",
                        oPaginate: {
                            sFirst: "Primero",
                            sLast: "Ultimo",
                            sNext: "Siguiente",
                            sPrevious: "Anterior"
                        },
                        sProcessing: "Procesando...",

                    }
                });
            });
        </script>
        <script>
            window.onload = function () {
                var contenido = document.getElementById('body-pd');
                var logout = document.getElementById('logout');
                logout.addEventListener('click', function () {
                    window.location.href = "out.jsp";
                })
            }
        </script>
        <script>
            window.onload = function () {
                var alert = document.getElementById('alert');
                setTimeout(function () {
                    alert.classList.add('d-none');
                }, 4000);
            };
        </script>
    </body>
</html>
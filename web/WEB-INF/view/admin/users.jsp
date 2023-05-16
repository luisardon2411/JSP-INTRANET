<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="/DataTables/css/dataTables.bootstrap5.min.css"/>
        <script type="text/javascript" src="/DataTables/js/dataTables.bootstrap5.min.js"></script> 
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="js/main.js"></script>
        <link rel="icon" href="image/icon.jpg">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <title>Usuarios</title>
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
                    <span class="fs-1 mt-5 border-bottom border-2 mb-3">Usuarios</span>
                </div>
                <div class="d-flex justify-content-start">
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-danger me-2" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                        Nuevo Usuario <i class="fas fa-plus"></i>
                    </button>  
                    <!-- Modal -->
                    <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-scrollable">
                            <div class="modal-content">
                                <div class="modal-header text-light" style="background-color: rgba(185, 17, 0) !important;">
                                    <h5 class="modal-title" id="staticBackdropLabel">Agregar Usuario</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <div class="container-fluid">
                                        <form action="usuarioController?action=insert" method="post" class="font">
                                            <div class="form-floating mb-3">
                                                <input type="text" class="form-control" id="floatingInput" placeholder="name@example.com" name="cod_emp">
                                                <label for="floatingInput">Codigo de empleado</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input type="text" class="form-control" id="floatingInput" placeholder="name@example.com" name="usuario">
                                                <label for="floatingInput">Usuario</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password">
                                                <label for="floatingPassword">Contraseña</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input type="text" class="form-control" id="floatingPassword" placeholder="Password" name="nombre_user">
                                                <label for="floatingPassword">Nombre</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input type="text" class="form-control" id="floatingInput" placeholder="name@example.com" name="apellido_user">
                                                <label for="floatingInput">Apellido</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input type="text" class="form-control" id="floatingInput" placeholder="name@example.com" name="numero_telefonico" maxlength="8" size="8" required>
                                                <label for="floatingInput">Numero de telefono</label>
                                            </div>
                                            <div class="mb-4">
                                                <select name="tipoUser" id="" class="form-select">
                                                    <option selected = "true" disabled>Tipo de usuario</option>
                                                    <option value="1">Administrador</option>
                                                    <option value="2">Usuario</option>
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
            <div class="height-100 mb-5">
                <div class="d-flex justify-content-center text-center">
                    <span class="fs-2 font">Lista de usuarios registrados</span>
                </div>
                <div class="d-flex justify-content-start">
                    <button class="switch">
                        <span><i class="fas fa-sun"></i></span>
                        <span><i class="fas fa-moon"></i></span>
                    </button>
                </div>
                <div class="container-fluid m-0 p-0 mb-5">
                    <div class="table-responsive">
                        <table class="table table-bordered table-hover" id="myTable">
                            <thead class="text-primary fw-bold small" id="title">
                            <th>Usuario</th>
                            <th>Codigo de Empleado</th>
                            <th>Nombres</th>
                            <th>Apellidos</th>
                            <th>Ultima sesion</th>
                            <th>Estado</th>
                            <th>Tipo Usuario</th>
                            <th>Opciones</th>
                            </thead>
                            <tbody class="fs-6">
                            <c:forEach var="u" items="${listUsers}">
                                <tr>
                                    <td>${u.usuario}</td>
                                    <td>${u.cod_emp}</td>
                                    <td>${u.nombre_user}</td>                                  
                                    <td>${u.apellido_user}</td>
                                    <td>${u.numero_telefonico}</td>
                                    <td>${u.ultima_session}</td>
                                    <td>${u.estado}</td>
                                    <td>${u.tipoUsuario}</td>
                                    <td><a href="usuarioController?action=modify&usuario=${u.usuario}" class="btn btn-success me-1"><i class="fas fa-pen"></i></a><a href="" class="btn btn-danger"><i class="fas fa-times"></i></a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
       <script src="jquery/jquery-3.6.0-min.js"></script>
        <link rel="stylesheet" href="DataTables/datatables.min.css"/>
        <script src="DataTables/datatables.min.js"></script>         
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>                   
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs5/dt-1.11.3/r-2.2.9/datatables.min.css"/>
        <script type="text/javascript" src="https://cdn.datatables.net/v/bs5/dt-1.11.3/r-2.2.9/datatables.min.js"></script>
        <script src="js/theme-table.js" type="text/javascript"></script>
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
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
                var logout = document.getElementById('logout');
                let timeExpiredSession = sesionRedirect();
                logout.addEventListener('click', () => {
                    location.replace("out.jsp");
                })
                function sesionRedirect() {
                    var sesionTimeExpired = <%= session.getMaxInactiveInterval()%>;
                    return sesionTimeExpired;
                }
                console.log(sesionRedirect());
                ;
                function MessageRedirect()
                {
                    Swal.fire({
                        backdrop: 'true',
                        title: 'La sesión ha caducado',
                        text: "Inicia Sesion nuevamente",
                        icon: 'warning',
                        confirmButtonColor: 'green',
                        confirmButtonText: 'entendido',
                        allowOutsideClick: false,
                        allowEscapeKey: false
                    }).then((result) => {
                        if (result.isConfirmed) {
                            Swal.fire({
                                icon: 'success',
                                title: 'Regresando al menu principal',
                                timer: '2000',
                                timerProgressBar: 'true',
                                allowOutsideClick: false,
                                allowEscapeKey: false
                            }).then((result) => {
                                if (result) {
                                    location.replace("index.jsp");
                                }
                            })
                        }
                    });
                }
                ;
                function delay(n) {
                    return new Promise(function (resolve) {
                        setTimeout(resolve, n * 1000);
                    });
                }
                async function funcionAsync() {
                    await delay(timeExpiredSession);
                    MessageRedirect();
                }
                funcionAsync();
            }
        </script>
    </body>
</html>

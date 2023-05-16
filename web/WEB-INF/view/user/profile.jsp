<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="js/main.js"></script>
        <link rel="icon" href="image/icon.jpg">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <title>Perfil</title>
    </head>
    <body id="body-pd">
        <header class="header" id="header">
            <div class="header_toggle"> <i class='bx bx-menu text-light' id="header-toggle"></i> </div>
            <div class="d-flex justify-content-center text-light"><c:forEach var="c" items="${user}"><i class="fas fa-user me-3"></i>${c.nombre_user} ${c.apellido_user}</c:forEach></div>
            </header>
            <div class="l-navbar" id="nav-bar">
                <nav class="nav fw-bold">
                    <nav class="nav fw-bold">
                        <nav class="nav fw-bold">
                            <div> <a href="#" class="nav_logo text-secondary "><img src="image/logo.png" class="img-fluid icon_hov" alt=""><span class="nav_logo-name">Menu</span> </a>
                                <div class="nav_list"> <a href="inicioController?action=inicio" class="nav_link active"> <i class='bx bx-grid-alt nav_icon icon_hov'></i> <span class="nav_name">Inicio</span> </a> 
                                    <a href="internosControlador?action=home" class="nav_link"> <i class='bx bx-user nav_icon icon_hov'></i> <span class="nav_name">Internos</span></a>
                                    <a href="externosController?action=inicio" class="nav_link"><i class="far fa-user icon_hov"></i><span class="nav_name">Externos</span></a>
                                    <a href="#" class="nav_link"><i class="fas fa-book icon_hov"></i><span class="nav_name">Manuales</span> </a> 
                                    <a href="jefesController?action=inicio" class="nav_link"> <i class="far fa-address-card icon_hov"></i><span class="nav_name">Contactos</span> </a> 
                                    <a href="representantesController?action=inicio" class="nav_link"> <i class="fas fa-users icon_hov"></i><span class="nav_name">Representantes</span> </a>
                                </div>
                            </div> 
                            <a href="#" class="nav_link" id="logout"> <i class='bx bx-log-out nav_icon icon_hov'></i> <span class="nav_name">Cerrar Sesión</span> </a>
                        </nav>
                        </div>
                        <div class="container-fluid p-5">
                            <div class="d-flex justify-content-center">
                                <span class="fs-1 mt-3 mb-1">Datos Personales</span>
                            </div>
                            <div class="container-fluid m-0">
                                <div class="container-fluid m-0">
                                    <form action="" method="post">
                                        <div class="container">
                                            <div class="row g-xl-2">
                                            <c:forEach var="c" items="${profile}">


                                                <div class="col-xl-4">
                                                    <div class="form-floating mb-3">
                                                        <input type="text" class="form-control" id="floatingInput" value="${c.cod_emp}" disabled>
                                                        <label for="floatingInput">Codigo de empleado</label>
                                                    </div>
                                                </div>
                                                <div class="col-xl-4">
                                                    <div class="form-floating mb-4">
                                                        <input type="text" class="form-control" id="floatingInput" value="${c.nombre_emp}" disabled>
                                                        <label for="floatingInput">Nombre</label>
                                                    </div>
                                                </div>
                                                <div class="col-xl-4">
                                                    <div class="form-floating mb-3">
                                                        <input type="text" class="form-control" id="floatingInput" value="${c.apellido_emp}" disabled>
                                                        <label for="floatingInput">Apellido</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row g-xl-2">
                                                <div class="col-xl-6">
                                                    <div class="form-floating mb-3">
                                                        <input type="text" class="form-control" id="floatingInput" value="${c.fecha_nac}" disabled>
                                                        <label for="floatingInput">Fecha de Nacimiento</label>
                                                    </div>
                                                </div>
                                                <div class="col-xl-6">
                                                    <div class="form-floating mb-3">
                                                        <input type="text" class="form-control" id="floatingInput" value="${c.diu}" disabled>
                                                        <label for="floatingInput">DIU</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row g-xl-3">
                                                <div class="col-xl-12">
                                                    <div class="form-floating mb-3">
                                                        <input type="text" class="form-control" id="floatingInput" value="${c.email}" disabled>
                                                        <label for="floatingInput" class="text-center">Correo Electronico</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row g-xl-2">
                                                <div class="col-xl-6">
                                                    <div class="form-floating mb-3">
                                                        <input type="text" class="form-control" id="floatingInput" value="${c.estado}" disabled>
                                                        <label for="floatingInput" class="text-center">Estado</label>
                                                    </div>
                                                </div>
                                                <div class="col-xl-6">
                                                    <div class="form-floating mb-3">
                                                        <input type="text" class="form-control" id="floatingInput" value="${c.pais}" disabled>
                                                        <label for="floatingInput" class="text-center">País</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row g-xl-2">
                                                <div class="col-xl-4">
                                                    <div class="form-floating mb-3">
                                                        <input type="text" class="form-control" id="floatingInput" value="${c.distribuidor}" disabled>
                                                        <label for="floatingInput" class="text-center">Distribuidor</label>
                                                    </div>
                                                </div>
                                                <div class="col-xl-4">
                                                    <div class="form-floating mb-3">
                                                        <input type="text" class="form-control" id="floatingInput" value="${c.encargado}" disabled>
                                                        <label for="floatingInput" class="text-center">Encargado</label>
                                                    </div>
                                                </div>
                                                <div class="col-xl-4">
                                                    <div class="form-floating mb-3">
                                                        <input type="text" class="form-control" id="floatingInput" value="${c.correo_responsable}" disabled>
                                                        <label for="floatingInput" class="text-center">Correo Electronico</label>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="container-fluid mb-5 p-0">
                            <h3 class="text-center">Usuarios asignados por aplicacion</h4>
                                <div class="table-responsive">
                                    <table class="table table-bordered table-hover" id="myTable">
                                        <thead class="text-primary fw-bold small" id="title">
                                        <th>Codigo de Empleado</th>
                                        <th>Nombre</th>
                                        <th>Apellido</th>
                                        <th>Estado Empleado</th>
                                        <th>Sistema</th>
                                        <th>Username</th>
                                        <th>Fecha Creado</th>
                                        <th>Fecha Eliminado</th>
                                        </thead>
                                        <tbody>
                                        <td>88777</td>
                                        <td>Juan Jose</td>
                                        <td>Lopez Lara</td>
                                        <td>ACTIVO</td>
                                        <td>PISA</td>
                                        <td>JL88777</td>
                                        <td>24/12/2019</td>
                                        <td></td>
                                        </tbody>
                                    </table>
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
                                });
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
                                                    history.forward(1);
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

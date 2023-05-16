
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="js/main.js"></script>
    <link rel="icon" href="image/icon.jpg">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
    <title>Representantes</title>
  </head>
    <body id="body-pd">
        <header class="header" id="header">
            <div class="header_toggle"> <i class='bx bx-menu text-light' id="header-toggle"></i> </div>
            <div class="d-flex justify-content-center text-light"><i class="fas fa-user me-3"></i>Luis Ardon</div>
        </header>
        <div class="l-navbar" id="nav-bar">
            <nav class="nav">
                <div> <a href="#" class="nav_logo text-secondary "><img src="image/logo.png" class="img-fluid icon_hov" alt=""><span class="nav_logo-name">Menu</span> </a>
                <div class="nav_list"> <a href="#" class="nav_link active"> <i class='bx bx-grid-alt nav_icon icon_hov'></i> <span class="nav_name">Inicio</span> </a> <a href="#" class="nav_link"> <i class='bx bx-user nav_icon icon_hov'></i> <span class="nav_name">Empleados</span> </a> <a href="#" class="nav_link"> <i class="fas fa-user-friends icon_hov"></i><span class="nav_name">Usuarios</span> </a> <a href="#" class="nav_link"><i class="fas fa-book icon_hov"></i><span class="nav_name">Manuales</span> </a> <a href="#" class="nav_link"> <i class="far fa-address-card icon_hov"></i><span class="nav_name">Contactos</span> </a> <a href="#" class="nav_link"> <i class="fas fa-users icon_hov"></i><span class="nav_name">Representantes</span> </a></div>
                </div> <a href="#" class="nav_link"> <i class='bx bx-log-out nav_icon icon_hov'></i> <span class="nav_name">Cerrar Sesión</span> </a>
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
                                    <div class="col-xl-4">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" id="floatingInput" value="88777" disabled>
                                            <label for="floatingInput">Codigo de empleado</label>
                                        </div>
                                    </div>
                                    <div class="col-xl-4">
                                        <div class="form-floating mb-4">
                                            <input type="text" class="form-control" id="floatingInput" value="Juan Jose" disabled>
                                            <label for="floatingInput">Nombre</label>
                                        </div>
                                    </div>
                                    <div class="col-xl-4">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" id="floatingInput" value="Lopez Lara" disabled>
                                            <label for="floatingInput">Apellido</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row g-xl-2">
                                    <div class="col-xl-6">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" id="floatingInput" value="22/08/1999" disabled>
                                            <label for="floatingInput">Fecha de Nacimiento</label>
                                        </div>
                                    </div>
                                    <div class="col-xl-6">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" id="floatingInput" value="335566877901" disabled>
                                            <label for="floatingInput">DIU</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row g-xl-3">
                                    <div class="col-xl-12">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" id="floatingInput" value="Juanjose@gmail.com" disabled>
                                            <label for="floatingInput" class="text-center">Correo Electronico</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row g-xl-2">
                                    <div class="col-xl-4">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" id="floatingInput" value="Central" disabled>
                                            <label for="floatingInput" class="text-center">Sede</label>
                                        </div>
                                    </div>
                                    <div class="col-xl-4">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" id="floatingInput" value="ACTIVO" disabled>
                                            <label for="floatingInput" class="text-center">Estado</label>
                                        </div>
                                    </div>
                                    <div class="col-xl-4">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" id="floatingInput" value="GUATEMALA" disabled>
                                            <label for="floatingInput" class="text-center">País</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row g-xl-2">
                                    <div class="col-xl-4">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" id="floatingInput" value="99887" disabled>
                                            <label for="floatingInput" class="text-center">Codigo de jefe</label>
                                        </div>
                                    </div>
                                    <div class="col-xl-4">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" id="floatingInput" value="Marcelo Estuardo" disabled>
                                            <label for="floatingInput" class="text-center">Nombre jefe</label>
                                        </div>
                                    </div>
                                    <div class="col-xl-4">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" id="floatingInput" value="marcelo@gmail.com" disabled>
                                            <label for="floatingInput" class="text-center">Correo electronico de jefe</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="container-fluid mb-5 p-0">
                    <h3 class="text-center">Usuarios asignados por aplicacion</h4>
                        <div class="table-responsive">
                            <table class="table table-hover table-bordered" id="myTable_2">
                                <thead class="text-light" style="background-color: rgb(185, 17, 0);">
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
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>                   
<link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css"/>
<script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
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

</script>  </body>
</html>

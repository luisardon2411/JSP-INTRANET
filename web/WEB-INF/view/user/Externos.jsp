<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
        <title>Externos</title>
    </head>
    <body id="body-pd">
        <header class="header" id="header">
            <div class="header_toggle"> <i class='bx bx-menu text-light' id="header-toggle"></i> </div>
            <div class="d-flex justify-content-center text-light"><c:forEach var="c" items="${user}"><i class="fas fa-user me-3"></i>${c.nombre_user} ${c.apellido_user}</c:forEach></div>
            </header>
            <div class="l-navbar" id="nav-bar">
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
                    <span class="fs-1 mt-5 border-bottom border-2 mb-3">Externos</span>
                </div>
            </div>
            <div class="height-100">
                <div class="d-flex justify-content-center text-center">
                    <span class="fs-2 font">Externos Registrados</span>
                </div>
                <div class="d-flex justify-content-start">
                    <button class="switch">
                        <span><i class="fas fa-sun"></i></span>
                        <span><i class="fas fa-moon"></i></span>
                    </button>
                </div>
                <div class="container-fluid m-0  p-0">
                    <div class="table-responsive">
                        <table class="table table-bordered table-hover" id="myTable">
                            <thead class="text-primary fw-bold small" id="title">
                            <th>Codigo de Empleado</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Fecha de Nacimiento</th>
                            <th>DIU</th>
                            <th>Correo Electronico</th>
                            <th>Distribuidor</th>
                            <th>Encargado</th>
                            <th>Correo Encargado</th>                        
                            <th>Estado</th>
                            <th>Pais</th> 
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
                                    <td class="status"><a href="externosController?action=perfil&codEmp=${c.idexterno}" class="color-status btn">${c.estado}</a></td>
                                    <td>${c.pais}</td>
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
                    sort: false,
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
                        "aria": {
                            "sortAscending": ": Activar orden de columna ascendente",
                            "sortDescending": ": Activar orden de columna desendente"
                        }

                    }

                });
                $('#myTable_2').DataTable({
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
    </body>
</html>
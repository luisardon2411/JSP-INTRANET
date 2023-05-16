<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Enumeration" %>
<!doctype html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="/DataTables/css/dataTables.bootstrap5.min.css"/>
        <script type="text/javascript" src="/DataTables/js/dataTables.bootstrap5.min.js"></script>  
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="js/main.js"></script>
        <link rel="stylesheet" href="css/tooltips.css">
        <link rel="icon" href="image/icon.jpg">
        <link rel="stylesheet" href="css/toastr.min.css"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <title>Inicio</title>
    </head>
    <body id="body-pd" class="font_3">
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
                    <div> 
                        <a href="#" class="nav_logo text-secondary "><img src="image/logo.png" class="img-fluid icon_hov" alt=""><span class="nav_logo-name">Menu</span> </a>
                        <div class="nav_list"> 
                            <a href="inicioController?action=home" class="nav_link active"> <i class='bx bx-grid-alt nav_icon icon_hov'></i> <span class="nav_name">Inicio</span> </a> 
                            <a href="internosController?action=home" class="nav_link"><i class='bx bx-user nav_icon icon_hov'></i><span class="nav_name">Internos</span></a>
                            <a href="externosController?action=home" class="nav_link"><i class="far fa-user icon_hov"></i><span class="nav_name">Externos</span></a>
                            <a href="usuarioController?action=home" class="nav_link"> <i class="fas fa-user-friends icon_hov"></i><span class="nav_name">Usuarios</span></a>
                            <a href="manuales.jsp" class="nav_link"><i class="fas fa-book icon_hov"></i><span class="nav_name">Manuales</span> </a> 
                            <a href="jefesController?action=home" class="nav_link"> <i class="far fa-address-card icon_hov"></i><span class="nav_name">Contactos</span> </a>
                            <a href="contactoController?action=home" class="nav_link"> <i class="fas fa-tablet-alt icon_hov"></i><span class="nav_name">Más Aplicaciones</span> </a>
                            <a href="representantesController?action=home" class="nav_link"> <i class="fas fa-users icon_hov"></i><span class="nav_name">Representantes</span> </a>
                            <a href="alliedController?action=home" class="nav_link"><img src="image/icon_global.jpeg" width="20" height="20" alt="alt" class="icon_hov rounded-2"/>Allied Global</a>
                        </div>
                    </div> 
                    <a href="#" class="nav_link" id="logout"> <i class='bx bx-log-out nav_icon icon_hov'></i> <span class="nav_name">Cerrar Sesión</span> </a>
                </nav>
            </div>
            <div class="container-fluid text-center w-50 p-5 mt-5 list-home">
                <div class="row " data-animation ="center">
                    <div class="col-xl-6" >
                        <a href="#" class="text-black">Inicio</a>
                    </div>
                    <div class="col-xl-6">
                        Segmento RCT
                    </div>
                </div> 
            </div>
            <div class="container-fluid p-3">
                <div class="container-fluid text-center">
                    <span class="fs-2">Plantillas</span>
                </div>
                <div class="row">
                    <div class="col-xl-6">
                        <!-- Button trigger modal -->
                        <a type="button" class="" data-bs-toggle="modal" data-bs-target="#staticBackdrop" id="a">
                            Plantillas mas usadas
                            <span></span>
                            <span></span>
                            <span></span>
                            <span></span>
                        </a>

                        <!-- Modal -->
                        <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="staticBackdropLabel">Plantillas mas usadas</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <div class="container-fluid">
                                            <span class="text-danger">Plantilla Configuraciones de ESSO </span><br>                                
                                            configuracion de sistema esso <br>
                                            ******************************<br>
                                            IP: <br>
                                            IBM: <br>
                                            Nombre: <br>
                                            usuario: <br>
                                            Sistema: <br>
                                            *******************************
                                            <div class="container p-0 m-0 border-3 border-top border-danger">
                                                <span class="text-danger small">Plantilla para cambio de contraseña (cualquier aplicativo)</span> <br>
                                                cambio de contraseña de usuario de <br>
                                                ****************************************** <br>
                                                IBM: <br>
                                                Nombre: <br>
                                                usuario: <br>
                                                Sistema: <br>
                                                ******************************************* <br>
                                                Se validaron correctamente los datos. <br>
                                                Se procede con lo solicitado. <br>
                                                ******************************************* <br>
                                                <span class="text-danger">Script de Correo </span><br>

                                                Sr(@): . Gracias por ponerse en contacto con nuestro centro de soporte. <br>
                                                Le informamos que su número de incidencia es: <br>
                                                Respecto a cambio de contraseña, ha sido solventado. <br>
                                                Aplicacion: <br>
                                                Distribuidor: <br>
                                            </div>
                                            <div class="container p-0 m-0 border-3 border-top border-danger">
                                                <span class="text-danger small">Plantilla para desbloqueo</span> <br>
                                                cambio de contraseña de usuario de <br>
                                                ****************************************** <br>
                                                IBM: <br>
                                                Nombre: <br>
                                                usuario: <br>
                                                Sistema: <br>
                                                ******************************************* <br>
                                                Se validaron correctamente los datos. <br>
                                                Se procede con lo solicitado. <br>
                                                ******************************************* <br>
                                            </div>
                                            <div class="container p-0 m-0 border-3 border-top border-danger">
                                                <span class="text-danger small">Plantilla para casos de base de datos</span> <br>
                                                */*/*/*/*/*/*/*/*/*/*/*/*/*/*//*/*/*/* <br>
                                                IBM:  <br>
                                                IP del Servidor:  <br>
                                                Puerto: <br>
                                                Nombre de la BD: <br>
                                                Usuario de la BD: <br>
                                                Nombre del usuario: <br>
                                                Contacto: <br>
                                                Correo electrónico del usuario: <br>
                                                Correo electrónico de Jefe inmediato: <br>
                                                *************************************  <br>
                                                Se validaron correctamente los datos. <br>
                                                Se procede con lo solicitado. <br>
                                                ************************************* <br>
                                            </div>
                                            <div class="container p-0 m-0 border-3 border-top border-danger">
                                                <span class="text-danger small">HOST</span> <br>

                                                172.16.79.19  		ccp-m1-pub ccp-1-gua <br>
                                                172.16.79.137   	psp-1-pmgr-pub <br>
                                                172.16.79.133   	srp-1-pub <br>
                                                192.168.136.48          cen-tlg-shp-02 <br>
                                                192.168.136.47          onbaseprod <br>
                                                172.24.0.20             rom-int-tom-0 <br>

                                                172.16.169.100		cen-tlg-exc-05		cen-tlg-exc-05.telgua.local <br>

                                                172.24.3.214		rom-pro-mail-02		rom-pro-mail-02.correo.americamovil.ca1 <br>

                                                172.24.0.20		rom-int-tom-03	201.247.158.101	 <br>

                                                172.18.252.53    ccp-pmgr-pub <br>

                                                192.168.8.250 	autodiscover.claro.com.gt <br>

                                                http://172.17.242.185:502/login <br>

                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <a type="button" class="btn btn-outline-danger" data-bs-dismiss="modal" >Cerrar</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-6">
                        <!-- Button trigger modal -->
                        <a type="button" class="" data-bs-toggle="modal" data-bs-target="#staticBackdrop1" id="a">
                            Casos Especiales
                            <span></span><span></span><span></span><span></span>
                        </a>

                        <!-- Modal -->
                        <div class="modal fade" id="staticBackdrop1" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="staticBackdropLabel">Casos Especiales</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <div class="container-fluid">
                                            <div class="container-fluid">
                                                <span class="text-danger">Plantilla para configuracion validadoras</span><br>                                
                                                CONFIGURACION DE IMPRESORA <br>
                                                ******************************* <br>
                                                IP: <br>
                                                Modelo: <br>
                                                Motivo de instalacion: <br>
                                                descripcion de lo realizado: <br>
                                                ********************************<br>
                                                <div class="container p-0 m-0 border-3 border-top border-danger">
                                                    <span class="text-danger small">Plantilla para configuracion de impresora</span> <br>
                                                    CONFIGURACION DE IMPRESORA <br>
                                                    ********************************<br>   
                                                    IP del equipo: <br>
                                                    IP de la impresora: <br>
                                                    Modelo: <br>
                                                    Motivo de instalacion: <br>
                                                    descripcion de lo realizado: <br>
                                                    ********************************<br>
                                                </div>
                                                <div class="container p-0 m-0 border-3 border-top border-danger">
                                                    <span class="text-danger small">Plantilla para caso tecnico</span> <br>
                                                    **********************************	<br>
                                                    PROBLEMA O AFECTACION: <br>

                                                    ********************************** <br>
                                                    NOMBRE DEL CONTACTO: <br>

                                                    **********************************	<br>
                                                    IP: <br>
                                                    ********************************** <br>
                                                    TELEFONOS DE CONTACTO: <br>

                                                    ********************************** <br>
                                                    LUGAR: <br>
                                                    **********************************	<br>
                                                    HORARIO PARA CONTACTAR: <br>
                                                    9AM A 6:00PM <br>
                                                    ********************************** <br>
                                                    COMENTARIOS: <br>
                                                    ********************************** <br>
                                                </div>
                                                <div class="container p-0 m-0 border-3 border-top border-danger">
                                                    <span class="text-danger small">Plantilla para Bloqueos Constantes</span> <br>
                                                    Buena Día, Solicito de su apoyo al validar el motivo por el cual el usuario: (). Se solicita un Scan de las últimas 24 horas para determinar de dónde proviene dicho bloqueo para esta cuenta, de ante mano agradezco el apoyo brindado para esta gestión. <br>

                                                    Adjunto datos: <br>

                                                    Nombre: <br>
                                                    Usuario: <br>
                                                    IBM: <br>
                                                    IP: <br>
                                                    Tel: <br>
                                                    País: <br>
                                                    Saludos. <br>
                                                    En espera de sus comentarios, de ante mano gracias por el apoyo.<br>
                                                </div>

                                            </div>
                                        </div>                                                       
                                    </div>
                                    <div class="modal-footer">
                                        <a type="button" class="btn btn-outline-danger" data-bs-dismiss="modal" >Cerrar</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="height-100">
                <div class="container-fluid">
                    <div class="container-fluid p-3">
                        <div class="row g-xl-5">
                            <div class="col-xl-6 mb-5">
                                <div class="card" id="card-content">
                                    <div class="card-body">
                                        <div class="container mt-3 p-3 text-light text-center" id="header-float"  style="background-color: rgb(185, 17, 0);">
                                            <span class="fs-4">
                                                Internos
                                            </span>
                                        </div>
                                        <div class="container text-center">
                                            <figure class="contenedor">
                                                <img src="image/internos.jpg" class="img-fluid">
                                            </figure>
                                        </div>
                                        <div class="container text-center">
                                            <a href="internosController?action=home" class="btn btn-outline-danger buttom" id="buttom">Ir</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-6">
                                <div class="card" id="card-content">
                                    <div class="card-body">
                                        <div class="container mt-3 p-3 text-light text-center" id="header-float"  style="background-color: rgb(185, 17, 0);">
                                            <span class="fs-4">
                                                Externos
                                            </span>
                                        </div>
                                        <div class="container text-center">
                                            <figure class="contenedor">
                                                <img src="image/internos.jpg" class="img-fluid">
                                            </figure>
                                        </div>
                                        <div class="container text-center">
                                            <a href="externosController?action=home" class="btn btn-outline-danger buttom" id="buttom">Ir</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row g-xl-5 mt-2 mb-3">
                            <div class="col-xl-6 mb-5">
                                <div class="card" id="card-content">
                                    <div class="card-body">
                                        <div class="container mt-3 p-3 text-light text-center" id="header-float"  style="background-color: rgb(185, 17, 0);">
                                            <span class="fs-4">
                                                Jefes Inmediatos

                                            </span>
                                        </div>
                                        <div class="container">
                                            <figure class="contenedor">
                                                <img src="image/jefe.jpg" class="img-fluid">
                                            </figure>
                                        </div>
                                        <div class="container text-center">
                                            <a href="jefesController?action=home" class="btn btn-outline-danger buttom" id="buttom">Ir</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-6 mb-5">
                                <div class="card" id="card-content">
                                    <div class="card-body">
                                        <div class="container mt-3 p-3 text-light text-center" id="header-float"  style="background-color: rgb(185, 17, 0);">
                                            <span class="fs-4">
                                                Distribuidores
                                            </span>
                                        </div>
                                        <div class="container text-center justify-content-center">
                                            <figure class="contenedor">
                                                <img src="image/distribuidor.jpg" class="img-fluid">
                                            </figure>
                                        </div>
                                        <div class="container text-center">
                                            <a href="representantesController?action=home" class="btn btn-outline-danger buttom" id="buttom">Ir</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>                  
                    </div>
                </div>
            </div>
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1440 320"><path fill="#E30000 " fill-opacity="1" d="M0,320L120,314.7C240,309,480,299,720,266.7C960,235,1200,181,1320,154.7L1440,128L1440,320L1320,320C1200,320,960,320,720,320C480,320,240,320,120,320L0,320Z"></path></svg>
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1440 320"><path fill="#E30000 " fill-opacity="1" d="M0,320L120,314.7C240,309,480,299,720,266.7C960,235,1200,181,1320,154.7L1440,128L1440,0L1320,0C1200,0,960,0,720,0C480,0,240,0,120,0L0,0Z"></path></svg>           
            <div class="container-fluid">
                <div class="container-fluid text-center mb-4">
                    <span class="fs-2">Segmentos RCT</span>
                    <div class="table table-responsive">
                        <table class="table table-bordered table-hover" id="myTable">
                            <thead class="text-primary fw-bold small" id="title">
                            <th>SITIO</th>
                            <th>DEPARTAMENTO</th>
                            <th>ID ENLACE</th>
                            <th>IP ENLACE</th>
                            </thead>
                            <tbody class="fs-6">
                            <c:forEach var="c" items="${rct}">
                                <tr>
                                    <td>${c.sitio}</td>
                                    <td>${c.departamento}</td>
                                    <td>${c.ipEnlace}</td>
                                    <td>${c.idIp}</td>
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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="js/toastr.min.js" type="text/javascript"></script>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs5/dt-1.11.3/r-2.2.9/datatables.min.css"/>
        <script type="text/javascript" src="https://cdn.datatables.net/v/bs5/dt-1.11.3/r-2.2.9/datatables.min.js"></script>
        <script src="https://unpkg.com/@popperjs/core@2"></script>
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script>
            <c:forEach var="c" items="${user}">
            toastr.options = {
                "closeButton": true,
                "debug": false,
                "newestOnTop": false,
                "progressBar": true,
                "positionClass": "toast-bottom-right",
                "preventDuplicates": false,
                "showDuration": "300",
                "hideDuration": "1000",
                "timeOut": "5000",
                "extendedTimeOut": "2000",
                "showEasing": "swing",
                "hideEasing": "linear",
                "showMethod": "fadeIn",
                "hideMethod": "fadeOut"
            };
            toastr["success"]("Bienvenido ${c.nombre_user} ${c.apellido_user}", "Te damos la bienvenida");
            </c:forEach>
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
    </body>
</html>

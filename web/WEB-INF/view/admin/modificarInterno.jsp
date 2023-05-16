<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
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
        <title>Internos</title>
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
        </div>
        <div class="container-fluid mt-5">
            <div class="d-flex justify-content-center">
                <span class="fs-1 mt-5 border-bottom border-2 mb-3">Modificar Interno</span>
            </div>
            <div class="container m-3 p-0 text-center">
                <div class="alert alert-warning" role="alert">
                    <figure class="d-flex justify-content-center">
                        <img src="image/warning.gif" width="40" height="40" class="me-2 text-center"/>
                    </figure>
                    IMPORTANTE: Para modificar un interno se tiene que saber el codigo del jefe y el país del cual se va a modificar.
                </div>
            </div>
            <div class="container-fluid p-5">
                <form action="internosController?action=update" method="post" class="needs-validation" novalidate>
                <c:forEach var="c" items="${Intern}">
                    <div class="row g-xl-2">
                        <div class="col-xl-3">
                            <div class="form-floating mb-3">
                                <input type="hidden" name="idinternos" value="${c.idinternos}">
                                <input type="text" class="form-control" id="floatingInput" value="${c.cod_emp}" disabled>
                                <label for="floatingInput">Codigo Empleado</label>
                            </div>
                        </div>
                        <div class="col-xl-3">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="floatingInput" value="${c.nombre_emp}" disabled>
                                <label for="floatingInput">Nombre</label>
                            </div>
                        </div>
                        <div class="col-xl-3">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="floatingInput" value="${c.apellido_emp}" disabled>
                                <label for="floatingInput">Apellido</label>
                            </div>
                        </div>
                        <div class="col-xl-3">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="floatingInput" value="${c.fecha_nac}" disabled>
                                <label for="floatingInput">Fecha de nacimiento</label>
                            </div>
                        </div>
                    </div>
                    <div class="row g-xl-2">
                        <div class="col-xl-6">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="floatingInput" value="${c.diu}" disabled>
                                <label for="floatingInput">DIU</label>
                            </div>
                        </div>
                        <div class="col-xl-6">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="floatingInput" value="${c.email}" disabled>
                                <label for="floatingInput">Correo Electronico</label>
                            </div>
                        </div>
                    </div>
                    <div class="row g-xl-2">
                        <div class="col-xl-12">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="floatingInput" value="${c.sede}" name="sede">
                                <label for="floatingInput">Sede</label>
                            </div>
                        </div>
                    </div>
                    <div class="row g-xl-2">
                        <div class="col-xl-3">
                            <div class="form-floating">
                                <select class="form-select" id="floatingSelect" aria-label="Floating label select example" name="estado" required="">
                                    <option value="1">ACTIVO</option>
                                    <option value="2">RETIRADO</option>
                                </select>
                                <label for="floatingSelect">Estado</label>
                            </div>
                        </div>
                        <div class="col-xl-3">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="floatingInput" value="${c.pais}" disabled>
                                <label for="floatingInput">País</label>
                            </div>
                        </div>
                        <div class="col-xl-3">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="floatingInput" placeholder="name@example.com" name="codEmp" required="">
                                <label for="floatingInput">Codigo de Jefe Inmediato</label>
                            </div>
                        </div>
                        <div class="col-xl-3">
                            <div class="form-floating">
                                <select id="" class="form-select" name="idPaisJefe" required="">
                                    <option selected = "true" disabled>Seleccion el Pais</option>
                                    <c:forEach var="b" items="${p}">
                                        <option value="${b.idPais}">${b.pais}</option>
                                    </c:forEach>
                                </select>
                                <label for="floatingSelect">País</label>
                            </div>
                        </div>
                    </div>
                    <div class="container-fluid p-0 mb-4">
                        <div class="form-floating text-center">
                            <textarea class="form-control" name="observaciones" id="floatingTextarea2" style="height: 100px"></textarea>
                            <label for="floatingTextarea2">Observaciones</label>
                        </div>
                    </div>
                    <div class="d-flex justify-content-center">
                        <button type="submit" class="btn btn-outline-danger">Modificar</button>
                    </div>               
                </c:forEach>
            </form>
        </div>
    </div>
        <script src="jquery/jquery-3.6.0-min.js"></script>
        <link rel="stylesheet" href="DataTables/datatables.min.css"/>
        <script src="DataTables/datatables.min.js"></script>   
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>                   
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css"/>
    <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
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
                                    location.replace("index.jsp");
                                }
                            })
                        }
                    });
                }
                ;
                function delay(n){
                    return new Promise(function(resolve){
                        setTimeout(resolve,n*1000);
                    });
                }
                async function funcionAsync(){
                    await delay(timeExpiredSession);
                    MessageRedirect();
                }
                funcionAsync();   
            }
    </script>
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
</body>
</html>
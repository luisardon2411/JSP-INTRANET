<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!doctype html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/animate.css">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="icon" href="image/Logo 1.png">
        <title>Restablecer contraseña</title>
    </head>
    <body class="background-gradient overflow-hidden">
        <div id="contenedor">
            <div id="preloader">

            </div>
        </div>
        <div class="w-100 p-5">
            <div class="container-fluid w-50 p-3 rounded-3 bg-white animate__animated animate__zoomInUp animate__delay-1s"id="form">
                <div class="container-fluid">
                    <form action="loginController?action=update" method="post" class="font needs-validation" id="form1" novalidate>
                        <div class="row g-1">
                            <div class="col-xl-6">
                                <figure class="d-flex justify-content-center">
                                    <img src="image/icon.jpg" alt="logo" class="rounded-2" width="150" height="150">
                                </figure>
                            </div>
                            <div class="col-xl-6">
                                <figure class="d-flex justify-content-center">
                                    <img src="image/Logo 1.png" alt="logo" class="rounded-2" width="150" height="150">
                                </figure>
                            </div>
                        </div>
                        <div class="mb-4">
                            <label for="user" class="form-label">Usuario<i class="fas fa-user-alt ms-2"></i></label>
                            <input type="text" name="user" id="" class="form-control" placeholder="Ingrese su usuario" required>
                        </div>
                        <div class="mb-4">
                            <label for="user" class="form-label">Contraseña<i class="fas fa-key ms-2"></i></label>
                            <input type="password" name="password" id="password" class="form-control" placeholder="Ingrese su contraseña" required>
                        </div>
                        <div class="mb-4">
                            <label for="user" class="form-label">Confirmar Contraseña<i class="fas fa-key ms-2"></i></label>
                            <input type="password" id="Confpass" class="form-control" placeholder="Ingrese su contraseña" required onkeyup="validate()">
                            <div class="d-none small text-danger" id="mensaje">
                                Las contraseñas no coinciden
                            </div>
                        </div>
                        <div class="d-flex justify-content-end">
                            <a href="index.jsp" class="text-danger text-decoration-none">Regresar</a>
                        </div>
                        <div class="d-flex justify-content-center mt-2 mb-2">
                            <div class="w-50 d-block text-center mb-2">
                                <button class="btn btn-outline-danger w-100"onsubmit="return spinner(this)" id="btnRestablecer">Restablecer<i class="fas fa-door-open ms-1"></i></button>                                    
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script src="js/spinner.js" type="text/javascript"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script>
                                    window.onload = function () {
                                        var contenedor = document.getElementById('contenedor');
                                        setTimeout(remove, 2000);
                                        function remove() {
                                            contenedor.style.visibility = 'hidden';
                                            contenedor.style.opacity = '0';
                                        }
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
        <script>
            function validate() {
                var pass = document.getElementById('password');
                var confpass = document.getElementById('Confpass');
                var mensaje = document.getElementById('mensaje');
                var buttom = document.getElementById('btnRestablecer');
                if (pass.value === confpass.value) {
                    mensaje.classList.add('d-none');
                    buttom.disabled = false;
                } else {
                    mensaje.classList.remove('d-none');
                    buttom.disabled = true;
                }
            }
        </script>
    </body>
</html>
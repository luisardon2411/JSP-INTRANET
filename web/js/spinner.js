function spinner() {
    var contenedor = document.getElementById('contenedor');
    contenedor.style.visibility = 'visible';
    contenedor.style.opacity = '1';
    setTimeout(removeContent, 2000);
    function removeContent() {
        contenedor.style.visibility = 'hidden';
        contenedor.style.opacity = '0';
    }
}



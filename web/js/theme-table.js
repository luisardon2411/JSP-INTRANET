const Switch = document.querySelector('.switch');
var tabla = document.querySelector('#myTable');
var titles = document.getElementById('title');
var hoverTitles = document.querySelector('th-hover');
Switch.addEventListener('click', () =>{
    tabla.style.transition = '1.2s ease-in-out';
    tabla.classList.toggle('table-dark');
    titles.classList.toggle('text-light');
    Switch.classList.toggle('active');
});



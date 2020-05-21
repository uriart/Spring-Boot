/* Con javascript tradicional */
var boton = document.querySelector("#boton");

boton.addEventListener("click", alerta);

function alerta(){
	alert("Se procede a desplegar el filtro");
}




/* Con libreria jQuery seria algo así */
/*
$("#boton").click(function(){
	alert("Se procede a desplegar el filtro. Función con jQuery");
});
*/
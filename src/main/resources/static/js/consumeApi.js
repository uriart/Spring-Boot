var boton = document.querySelector("#randomImage");
var div = document.querySelector("#imagen");

boton.addEventListener("click", obtenerImagen);

function obtenerImagen(){

	let url='https://pixabay.com/api/?key=642672-bb883db23b233371a1bf0078e&q=gim&image_type=photo';

	const api = new XMLHttpRequest();
	api.open('GET', url, true);
	api.send();

	api.onreadystatechange = function(){

        if(this.status == 200 && this.readyState == 4){

            let respuesta = JSON.parse(this.responseText);
            console.log(respuesta);
            let imagen = document.querySelector('#imagen');
            var aleatorio = numero_al_azar(0,respuesta.hits.length-1);
            let urlObtenida = respuesta.hits[aleatorio].userImageURL;

            div.innerHTML = `<img src="${urlObtenida}" alt="..."/>`;

        }
	}

}

function numero_al_azar(minimo,maximo) { return Math.floor(Math.random() * (maximo - minimo + 1) + minimo); }
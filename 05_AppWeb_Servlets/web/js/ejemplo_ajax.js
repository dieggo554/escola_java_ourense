/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.addEventListener("load", function () {
    document.getElementById("btn_peticion_ajax").onclick = function () {
        var objAjax = new XMLHttpRequest();
        objAjax.onreadystatechange = function () {
            document.getElementById("btn_peticion_ajax").innerHTML = this.responseText;
            console.log("Estado objAjax: " + this.readyState
                    + ", Estado petición http: " + this.status);
            console.log("Texto respuesta: " + this.responseText);

            if (this.readyState === 4 && this.status === 200) { // en el estado 4 ha terminado de recibir
                document.getElementById("div_datos_json").innerHTML = this.responseText;

                var respuestaObj = JSON.parse(this.responseText);
                document.getElementById("div_datos").innerHTML = `
                <br/><span style="font-weight: bold">Nombre: </span>
                    ${respuestaObj.nombre}
                <br/><span style="font-weight: bold">Edad: </span>
                    ${respuestaObj.edad}
                <br/><span style="font-weight: bold">Fibonacci: </span>
            `;

                for (var numFib of respuestaObj.fibonacci) {
                    document.getElementById("div_datos").innerHTML += " - " + numFib;
                }
            }
        };
        objAjax.open("GET", "./datosjson");
        objAjax.send();
        console.log("¡¡Petición enviada!!");
    };
});
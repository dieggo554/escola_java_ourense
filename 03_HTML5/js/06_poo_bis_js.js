var divBis = document.getElementById("contenido_bis");
divBis.style = "background-color: lightgrey";

var mostrarTodosParam = function(primerParam) {
  divBis.innerHTML += "<p>Primer parámetro: " + primerParam + "</p>";
  for (argumento of arguments) {
    divBis.innerHTML += "Argumento : " + argumento + "<br/>";
  }
  if (typeof(primerParam) === undefined)
    divBis.innerHTML += "primerParametro no está definida";
  if (primerParam == "1") {
    divBis.innerHTML += "Pues es parecido \"1\" ";
  } else {
    divBis.innerHTML += "No es parecido  \"1\" ";
  }
  if (primerParam === "1") {
    divBis.innerHTML += "Pues es idéntico a \"1\" ";
  } else {
    divBis.innerHTML += "No es idéntico a  \"1\" ";
  }
}
mostrarTodosParam("Un argumento" , 50, true, bebida);
mostrarTodosParam();
mostrarTodosParam("1"); // Le pasamos un texto con un 1
mostrarTodosParam(1);   // Valor de tipo Number, 1

var intentoConversion = parseFloat("veinte"); // Muestra NaN, Not a Number
divBis.innerHTML += "<br/>Convirtiendo. Resultado = " + (intentoConversion);
divBis.innerHTML += "<br/>El tipo de dato es " + typeof(intentoConversion);
if (isNaN(intentoConversion)) divBis.innerHTML += "<br/>No es un número";
divBis.innerHTML += "<br/>Infinito: " + 1 / 0;
// Precisión double parece
divBis.innerHTML += "<br/>Infinito: " + 1.234567890123456789;
console.log("Mensaje ok");
console.error("Mensaje error");
var varDinamica = "Ahora soy un texto";
document.write("<h1>Java Script</h1>")
document.write("<p>varDinamica = " + varDinamica + "</p></b>");
document.write("<p>No más código spagetti. En un anti-patrón de diseño</p>");
varDinamica = 999;
// Mediante el DOM, generamos un p y lo rellenamos:
var parrafo = document.createElement("p");
var textoParrafo = document.createTextNode("varDinamica = 999");
parrafo.appendChild(textoParrafo);
var body = document.getElementsByTagName("body")[0];
body.appendChild(parrafo);
var arrayParrafos = document.getElementsByTagName("p");
for (p of arrayParrafos) {
  p.setAttribute("style", "background-color: lightgrey");
  // Cogemos los <p> del DOM, que se actualiza del HTML
}
alert(body.innerHTML);
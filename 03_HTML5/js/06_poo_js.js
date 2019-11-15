var div = document.getElementById("contenido");

var bebida = new Object();
bebida.tipo = "Cerveza";
bebida.cantidad = "3 litros";

div.innerHTML += "Bebida es " + bebida.tipo + "</br>";
// En JS, los objetos son mapas (como el HashMap de Java)
div.innerHTML += "Cantidad es " + bebida["cantidad"] + "</br>";

bebida["propiedades"] = "Tiene alcohol, gas y emborracha";
div.innerHTML += "</br>Propiedades: " + bebida.propiedades;

function suma(x, y) {
  return x + y;
}

div.innerHTML += "</br>suma(5,3) = " + suma(5, 3)
div.innerHTML += "</br>suma('5','3') = " + suma('5', '3')

//Para hacer una especie de clase, sólo creamos una función constructora
function Bebida(tipo, cant, prop) {
  this.tipo = tipo;
  this.cantidad = cant;
  this.propiedades = prop;

  function funMostrar() {
    div.innerHTML += "<p>Bebida: "
      + this.tipo + ", " + this.cantidad
      + ", " + this.propiedades + "</p>"
  }

  this.mostrar = function () {
    div.innerHTML += "<p>Bebida: "
      + this.tipo + ", " + this.cantidad
      + ", " + this.propiedades + "</p>"
  }
  this.mostrar = funMostrar();
}
var zumo = new Bebida("zumo de naranja", "1L", "Vitamina C");
zumo["propiedades"] += " y es de color naraja";
zumo.mostrar;
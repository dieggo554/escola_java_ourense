// Manera EcmaScript 5
function GestorEventosES5(inputId, btnId, divId) {
  this.input = document.getElementById(inputId);
  this.boton = document.getElementById(btnId);
  this.divInfo = document.getElementById(divId);

  this.funCllbckAlPulsar = function (evento) {
    this.boton.removeEventListener("click", this.funCllbckAlPulsar);
    this.boton.value = "Puedes repetir";
    this.input.value = "Tipo evento: " + evento.type;
    this.divInfo.innerHTML = "evento.currentTarget.id = " + evento.currentTarget.id;
    this.divInfo.style = "border: blue solid; background-color: lightgray;";
  }

  this.funCllbckAlPulsar_2 = (evento) => {
    this.input.style = "background-color: lightblue;";
  }

  // .bind(this) enlazamos el "this" actual al "this" interior
  this.boton.addEventListener("click", this.funCllbckAlPulsar.bind(this));
  // con funcion lamda no cambia this, MUY RECOMENDADO
  this.boton.addEventListener("click", this.funCllbckAlPulsar_2);
}
// Manera EcmaScript 2015 ó ES6
class GestorEventosES6 {
  constructor(inputId, btnId, divId) {
    this.input = document.getElementById(inputId);
    this.boton = document.getElementById(btnId);
    this.divInfo = document.getElementById(divId);
    this.boton.addEventListener("click", this.funCllbckAlPulsar.bind(this));
    this.boton.addEventListener("click", this.funCllbckAlPulsar_2);
  }

  funCllbckAlPulsar = function (evento) {
    this.boton.removeEventListener("click", this.funCllbckAlPulsar);
    this.boton.value = "Puedes repetir";
    this.input.value = "Tipo evento: " + evento.type;
    this.divInfo.innerHTML = "evento.currentTarget.id = " + evento.currentTarget.id;
    this.divInfo.style = "border: blue solid; background-color: lightgray;";
  }

  funCllbckAlPulsar_2 = (evento) => {
    this.input.style = "background-color: lightblue;";
  }
}
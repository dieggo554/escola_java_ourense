// Notación JSON: JavaScript Object Notation
// Lo que se puede almacenar en XML se puede convertir a JSON y viceversa
// Todo se puede almacenar como JSON

var unObjeto = {}; // new Object();
var otroObj = {
  "prop_1": "Propiedad uno",
  "prop_2": "Propiedad dos",
  'prop_3': 'Propiedad tres',
  'prop_4': 'Propiedad cuatro',
  toString: function () {
    return "Propiedades: " + this.prop_1
      + "; " + this.prop_2
      + "; " + this.prop_3
      + "; " + this.prop_4
  },
  toString20: function () {
    var strProp = "Lista de propiedades: ";
    for (var i = 0; i < 20; i++) {
      if (typeof (this["prop_" + i]) !== "undefined") {
        strProp += this["prop_" + i] + "; ";
      }
    }
    return strProp;
  },
  toStringAllProp: function () {
    var strProp = "Lista de las propiedades: ";
    for (key in this) {
      if (key.indexOf("prop_") >= 0)
        strProp += this[key] + "; ";
    }
    return strProp;
  },
  toStringAllZaira: function () {
    var strProp = "Lista de propiedades modo Zaira: ";
    var largo = Object.keys(this).length;
    for (let i = 0; i < largo; i++) {
      var largoNum = Object.keys(this)[i].length;
      var numProp = Object.keys(this)[i].substring(5, largoNum);
      if (Object.keys(this)[i] == "prop_" + numProp) {
        strProp += Object.values(this)[i] + "; ";
      }
    }
    return strProp;
  },
  toStringAll: function () {
    let cadena = "Propiedades: ";
    for (const key in this) {
      if (this.hasOwnProperty(key) // Comprobamos que la propiedad NO sea HEREDADA
        && typeof (this[key]) !== "function" // typeof "function"
        && typeof (this[key]) !== "undefined" // typeof "undefined"
        && key.indexOf("prop_") >= 0) {
        cadena += key + ": " + this[key] + "\n";
      }
    }
    return cadena;
  }
}

otroObj.prop_5 = "Propiedad cinco";
otroObj.prop_19 = "Propiedad diecinueve";
var divTris = document.getElementById("contenido_tris");
divTris.innerHTML += otroObj; // .toString()
divTris.innerHTML += "<br/>toString20 " + otroObj.toString20();
divTris.innerHTML += "<p>toStringAllProp " + otroObj.toStringAllProp() + "</p>"
divTris.innerHTML += "<p>toStringAll " + otroObj.toStringAll() + "</p>"
divTris.innerHTML += "<p>toStringAllZaira " + otroObj.toStringAllZaira() + "</p>"
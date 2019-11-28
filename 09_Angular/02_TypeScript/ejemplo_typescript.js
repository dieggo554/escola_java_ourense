"use strict";
var lenguaje = "JavaScript";
var textoExtra = " con Tipado fuerte OPCIONAL";
console.log("TypeScript es " + lenguaje + textoExtra);
var UnaClase = /** @class */ (function () {
    function UnaClase(propiedad) {
        this.propiedad = propiedad;
    }
    UnaClase.prototype.getPropiedad = function () {
        return this.propiedad;
    };
    return UnaClase;
}());
var unObjeto = new UnaClase("Tiene POO");
console.log("Y " + unObjeto.getPropiedad());
textoExtra = 2000;

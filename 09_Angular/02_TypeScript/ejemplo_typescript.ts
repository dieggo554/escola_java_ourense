"use strict";
var lenguaje = "JavaScript";

let textoExtra: String = " con Tipado fuerte OPCIONAL";

console.log("TypeScript es " + lenguaje + textoExtra);

class UnaClase {
	
	constructor(private propiedad: String) {}
	
	public getPropiedad() : String {
		return this.propiedad;
	}
}
let unObjeto: UnaClase = new UnaClase("Tiene POO");
console.log("Y " + unObjeto.getPropiedad());

textoExtra = 2000;
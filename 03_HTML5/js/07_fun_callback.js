// Todo son funciones callback o de retrollamada
// Nomenclatura típica de function en variable
let suma = function(x, y) { return x + y; }
// Nomenclatura típica de function
function resta(x, y) { return x - y; }
// Nomenclatura de objeto Function
let multiplica = new Function('x', 'y', 'return x * y')
// Nomenclatura de función flecha
let divide = (x, y) => { return x / y; }

let creaPunto = (x, y) => {
  // Usando templates strings de ES6 (acento grave `, al lado de la P)
  return `( ${x}, ${y} )`;
}
function operarArrays(arrX, arrY, operaCllbk) {
  // Comprobamos que el tamaño de los arrays son el mismo
  if (arrX.length == arrY.length) {
    // Declaramos un array con la palabra "var", cuyo ambito es de FUNCIÓN.
    // A diferencia de "let" (ES6), que sí es ámbito a nivel de BLOQUE.
    var arrayResult = new Array(arrX.length); // Eficiente: no tiene que
                                              // redimensionar internamente
    for (let i = 0; i < arrX.length; i++) {
      arrayResult[i] = operaCllbk(arrX[i], arrY[i]);
    }
  }
  return arrayResult;
}
// Otros ejemplos array:
// var arrayResult = new Array(); // Una manera de crear array
var arrayResult = [];             // Otra manera con notación JSON
                                  // No indicamos el tamaño, en realidad son
                                  // parecidos a los ArrayList<Object> de Java
                                  // Incluso a un HashMap<Integer, Object>
arrayResult.push("Primer elemento")
arrayResult[10]; // Correcto
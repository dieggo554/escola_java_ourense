let array_A = [1, 2, 3, 4, 5];
let array_B = [2, 3, 4, 5, 6];

let arraySumaAB = operarArrays(array_A, array_B, suma);
arrayEnTabla(arraySumaAB);

let arrayMultAB = operarArrays(array_A, array_B, multiplica);
arrayEnTabla(arrayMultAB);

let arrayRestaAB = operarArrays(array_A, array_B, resta);
arrayEnTabla(arrayRestaAB);

// let arrayDivAB = operarArrays(array_A, array_B, divide);
// let arrayDivAB = operarArrays(array_A, array_B, (x,y) => { return x / y });
let arrayDivAB = operarArrays(array_A, array_B, (x,y) => x / y );
arrayEnTabla(arrayDivAB);

let arrayPuntos = operarArrays(array_A, array_B, creaPunto);
arrayEnTabla(arrayPuntos);

function arrayEnTabla(array, content) {
  let table = "<table border=2><tr>"; // border=2 deprecated, usar css
  for (let i = 0; i < array.length; i++) {
    const element = array[i];
    table += "<td>&nbsp; " + element + "&nbsp;</td>";
  }
  document.getElementById("contenido").innerHTML +=
    table + "</tr></table>";
}
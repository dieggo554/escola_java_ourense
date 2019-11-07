/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.poo;

/**
 *
 * @author pc
 */
public class Coche extends Vehiculo /* extends Object */ {

    /* public Coche() { 
        // constructor por defecto
    } */
    private int numRuedas;
    private String marca;
    protected boolean arrancado;

    // En el momento que creamos un contructor, el de por defecto
    // deja de ser implementado por Java
    public Coche() {
        numRuedas = 4;
        marca = "SIN MARCA";
        arrancado = false;
        setTipo(TipoVehiculo.TURISMO);
        numRuedas = 4;
    }

    public Coche(String marca) {
        this.marca = marca;
        // el valor por defecto es 0 o equivalente, pero es recomendable definirlo
        this.arrancado = false;
        setTipo(TipoVehiculo.TURISMO);
        numRuedas = 4;
    }

    public boolean arrancar() {
        arrancado = true;
        System.out.println(marca + " ha arrancado.");
        return arrancado;
    }

    // Sobrecarga de método arrancar()
    /**
     * Si la posisción de la llave es 4 el coche arranca No arranca en cualquier
     * otro caso
     *
     * @param posicionLlave puede ser un número del 1 al 4
     * @return si se ha arrancado devulve true
     */
    public boolean arrancar(int posicionLlave) { // 4 pos, la 4ª arranca
        if (posicionLlave < 1 || posicionLlave > 4) {
            throw new IllegalArgumentException("La llave ha de valer de 1 a 4");
        }
        arrancado = posicionLlave == 4 /* ? true : false*/; // Redundante
//        if (posicionLlave == 4) {
//            arrancado = true;
//        } else {
//            arrancado = false;
//        }
        System.out.println(marca
                + (arrancado ? " ha arrancado."
                        : " falló al arrancar"));
        return arrancado;
    }

    // CLEAN CODE: las funciones no deben tener más de 20 líneas de código
    // aun que no se vaya a reutilizar
    public boolean arrancar(String orden) {
//        if (orden.equals("arrancar")) {
//            arrancado = true;
//        } else {
//            arrancado = false;
//        }
//        return arrancado;
        // Mejorado:
        arrancado = "arrancar".equals(orden);
        return arrancado;
    }

    /**
     * Simplemente imprime la marca y si está arrancado
     */
    // Utilizar siempre, en la propia clase, los getter y setter: podrían
    // tener lógica
    @Override
    public void mostrarEstado() {
        System.out.println(toString());
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca)
            // Avisamo a quien invoca que podríamos lanzar esta excepción
            //            throws IllegalArgumentException 
            throws Exception {
        // Cuando existe una variable local
        // Obliga a usar this parif (marca == null || "".equals(marca))a acceder a la variable miembro
        // con el mismo nombre
        if (marca != null && !"".equals(marca)) {
            this.marca = marca;
        } else // Es común validar datos en los setters, IllegalArgumentException
        // para este caso.
        {
            throw new IllegalArgumentException("Debes asignar una marca");
        }
    }

    public int getNumRuedas() {
        return numRuedas;
    }

    public boolean isArrancado() {
        return arrancado;
    }

    @Override
    public void avanzar() {
        System.out.println("Ruedo un poco");
    }
    
    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        cadena.append(super.toString());
        cadena.append(" Marca: ");
        cadena.append( getMarca());
        cadena.append(" Num. Ruedas: ");
        cadena.append(numRuedas);
        cadena.append(" Estado: ");
        cadena.append((arrancado ? " encendido." : " apagado"));
        return cadena.toString();
    }
}

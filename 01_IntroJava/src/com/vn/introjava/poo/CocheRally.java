/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.poo;

/**
 * Clase CocheRally para controlar otras características específicas de los
 * rallies.
 *
 * @author pc
 */
public class CocheRally extends Coche {

    private float rozamiento;

    public CocheRally() {
        super();
        rozamiento = 5f; // Inicializamos los valores (buena práctica)
        setTipo(TipoVehiculo.RALLY);
    }
    
    /** Constructor con parámetros
     * Al implmentar un constructor, el de por defecto
     * deja de ser implementado por Java
     * @param marca 
     */
    public CocheRally(String marca) {
        super(marca); // Constuctor padre
        rozamiento = 5f; // Inicializamos los valores (buena práctica)
        setTipo(TipoVehiculo.RALLY);
    }

    public CocheRally(float rozamiento, String marca) {
        super(marca);
        this.rozamiento = rozamiento;
        setTipo(TipoVehiculo.RALLY);
    }
    
    

    @Override
    public boolean arrancar(String orden) {
        if (super.arrancar(orden)) {
        } else if ("arrancar".equalsIgnoreCase(orden)) {
            return super.arrancar();
        } else {
            this.arrancado = "encender".equals(orden.toLowerCase()); // super o this no es necesario
        }
        return arrancado;
    }

    public boolean arrancar(String orden, int posLlave) {
        if (super.arrancar(orden) && super.arrancar(posLlave)) {
            super.arrancar();
        } else {
            super.arrancar("NO arranca");
        }
        return isArrancado();
    }

    /**
     * Obtener valor de rozamiento
     *
     * @return el valor de rozamiento
     */
    public float getRozamiento() {
        return rozamiento;
    }

    /**
     * Establecer valor de rozamiento
     *
     * @param rozamiento nuevo valor de rozamiento
     */
    public void setRozamiento(float rozamiento) {
        this.rozamiento = rozamiento;
    }

    // Ejercicio: Sobreescribir el método mostrarEstado() para que
    // también muestre el rozamiento
    // @Override ya no es override al cambiar el nombre
    public void mostrarEstadoAntiguo() {
        super.mostrarEstado();
        System.out.println(" - Rozamiento " + rozamiento);
    }

    // 2º, que indique que es "Coche de rally: <marca>, rozamiento, arrancado"
    @Override
    public void mostrarEstado() {
        System.out.println("-Tipo: " + getTipo() + " - Marca - " + getMarca()
                + ", rozamiento: " + rozamiento
                + (isArrancado() ? ", arrancado" : ", apagado"));
    }
}

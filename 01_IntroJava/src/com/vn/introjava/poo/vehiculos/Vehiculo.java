/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.poo.vehiculos;

import com.vn.introjava.poo.interfaces.Desplazable;
import java.io.Serializable;

/** Clase abstracta que no puede ser instaciada
 * Por falta de sentido
 *
 * @author pc
 */
public abstract class Vehiculo
        extends Object
        implements Desplazable, Serializable {
    
    protected TipoVehiculo tipo;

    public TipoVehiculo getTipo() {
        return tipo;
    }

    /**
     * Método declarado e implementado
     * @param tipo 
     */
    public void setTipo(TipoVehiculo tipo) { // Declaración
        this.tipo = tipo;                    // Implementación
    }
    
    /**
     * Método declarado pero NO implementado (aquí)
     */
    public abstract void avanzar();         // Declaración

    public void mostrarEstado() {
        System.out.println(toString());
    }
    
    @Override
    public String toString() {
        return "Tipo: " + tipo;
    }
    
    
}

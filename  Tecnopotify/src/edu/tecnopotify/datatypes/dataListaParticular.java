package edu.tecnopotify.datatypes;

import edu.tecnopotify.entidades.*;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;


public class dataListaParticular extends ListaReproduccion {
    
 
    private boolean esPrivada;
    private Cliente cliente;

    public dataListaParticular(boolean esPrivada, Cliente cliente, 
            dataListaReproduccion listaRep) {
        super(listaRep);
        this.esPrivada = esPrivada;
        this.cliente = cliente;
    }
/*
    public dataListaParticular(boolean esPrivada, Cliente cliente, 
            String nombre, String imagen) {
        super(nombre, imagen);
        this.esPrivada = esPrivada;
        this.cliente = cliente;
    }

    public dataListaParticular(String nombre, String imagen) {
        super(nombre, imagen);
        esPrivada = false;
    }*/

    public boolean isEsPrivada() {
        return esPrivada;
    }

    public void setEsPrivada(boolean esPrivada) {
        this.esPrivada = esPrivada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    

    
    
}
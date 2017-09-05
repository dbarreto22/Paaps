package edu.tecnopotify.entidades;

import edu.tecnopotify.datatypes.dataListaReproduccion;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ListaParticular extends ListaReproduccion implements Serializable{
    
    @Column
    private boolean esPrivada;
    @Column
    private Cliente cliente;

    public ListaParticular(boolean esPrivada, Cliente cliente, 
            dataListaReproduccion listaRep) {
        super(listaRep);
        this.esPrivada = esPrivada;
        this.cliente = cliente;
    }

    public ListaParticular(dataListaReproduccion listaRep) {
        super(listaRep);
    }

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
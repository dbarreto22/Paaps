package edu.tecnopotify.entidades;

import edu.tecnopotify.datatypes.dataCliente;
import edu.tecnopotify.datatypes.dataUsuario;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends Usuario implements Serializable{
    @OneToMany
    public List<ListaParticular> listasReprParticular ;
    @OneToMany
    public List<Usuario> seguidos;

    public Cliente(dataUsuario usuario) {
        super(usuario);
    }

    public Cliente() {
        super();
    }

    public List<ListaParticular> getListasReprParticular() {
        return listasReprParticular;
    }

    public void setListasReprParticular(List<ListaParticular> listasReprParticular) {
        this.listasReprParticular = listasReprParticular;
    }

    public List<Usuario> getSeguidos() {
        return seguidos;
    }

    public void setSeguidos(List<Usuario> seguidos) {
        this.seguidos = seguidos;
    }

    public void add(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void remove(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

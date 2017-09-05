package edu.tecnopotify.entidades;

import edu.tecnopotify.datatypes.dataCliente;
import edu.tecnopotify.datatypes.dataUsuario;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends Usuario implements Serializable{
    @OneToMany
    public Map<String, ListaParticular> listasReprParticular = new HashMap<String, ListaParticular>();
    @OneToMany
    public Map<String, Usuario> seguidos = new HashMap<String, Usuario>();

    public Cliente(dataUsuario usuario) {
        super(usuario);
    }

    public Cliente() {
        super();
    }
    
    public Map<String, ListaParticular> getLista() {
        return listasReprParticular;
    }
    

    public Map<String, ListaParticular> getListasReprParticular() {
        return listasReprParticular;
    }

    public void setListasReprParticular(Map<String, ListaParticular> listasReprParticular) {
        this.listasReprParticular = listasReprParticular;
    }

    public Map<String, Usuario> getSeguidos() {
        return seguidos;
    }

    public void setSeguidos(Map<String, Usuario> seguidos) {
        this.seguidos = seguidos;
    }
}

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
import javax.persistence.OneToOne;

@Entity
public class Cliente extends Usuario implements Serializable{
    @OneToMany
    public List<ListaParticular> listasReprParticular ;
    @OneToMany
    public List<Usuario> seguidos;
    
    @OneToOne
    private Favoritos fav;

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

    public Favoritos getFav() {
        return fav;
    }

    public void setFav(Favoritos fav) {
        this.fav = fav;
    }

}

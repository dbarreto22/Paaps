package edu.tecnopotify.entidades;


import java.awt.Image;
import java.io.Serializable;
import java.util.Date;
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


    public Cliente(String nickname, String nombre, String apellido, String mail, Date f_nac, String imagen) {
        super(nickname, nombre, apellido, mail, f_nac, imagen);
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

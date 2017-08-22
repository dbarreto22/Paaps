package edu.tecnopotify.entidades;


import java.awt.Image;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Cliente extends Usuario implements Serializable{
    
    public Map<String, ListaParticular> listasReprParticular = new HashMap<String, ListaParticular>();
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
/*
    public void setLista(ListaParticular lista) {
        this.lista = lista;
    }
*/
}

package edu.tecnopotify.datatypes;


import edu.tecnopotify.entidades.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



public class dataCliente extends dataUsuario{
    
    public Map<String, ListaParticular> listasReprParticular = new HashMap<String, ListaParticular>();
    public Map<String, Usuario> seguidos = new HashMap<String, Usuario>();

    public dataCliente(String nickname, String nombre, String apellido, 
            String mail, dataFecha f_nac, String imagen) {
        super(nickname, nombre, apellido, mail, f_nac, imagen);
    }

    public dataCliente() {
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

package edu.tecnopotify.datatypes;

import edu.tecnopotify.entidades.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dataCliente extends dataUsuario {

    public Collection<ListaParticular> listasReprParticular;
    public Collection<Usuario> seguidos;

    public dataCliente(String nickname, String nombre, String apellido, String mail, dataFecha f_nac, String imagen,
            Collection<Usuario> lseguidores, Collection<Usuario> lseguidos) {
        super(nickname, nombre, apellido, mail, f_nac, imagen, lseguidores, lseguidos);
    }
    
    public dataCliente(String nickname, String nombre, String apellido, String mail, dataFecha f_nac, String imagen
            ) {
        super(nickname, nombre, apellido, mail, f_nac, imagen);
    }

    public dataCliente() {
        super();
    }

    public Collection<ListaParticular> getLista() {
        return listasReprParticular;
    }

    public Collection<ListaParticular> getListasReprParticular() {
        return listasReprParticular;
    }

    public void setListasReprParticular(Collection<ListaParticular> listasReprParticular) {
        this.listasReprParticular = listasReprParticular;
    }

    public Collection<Usuario> getSeguidos() {
        return seguidos;
    }

    public void setSeguidos(Collection<Usuario> seguidos) {
        this.seguidos = seguidos;
    }
}

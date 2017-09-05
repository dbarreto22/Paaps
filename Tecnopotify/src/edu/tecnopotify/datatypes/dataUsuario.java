package edu.tecnopotify.datatypes;

import edu.tecnopotify.entidades.Usuario;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class dataUsuario implements Serializable {

    private String nickname;
    private String nombre;
    private String apellido;
    private String mail;
    private dataFecha f_nac;
    private String imagen;
    private Collection<Usuario> lstSeguidos;
    private Collection<Usuario> lstSeguidores;

    public dataUsuario(String nickname, String nombre, String apellido, String mail, dataFecha f_nac, String imagen,
            Collection<Usuario> lseguidores, Collection<Usuario> lseguidos) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.f_nac = f_nac;
        this.imagen = imagen;
        this.lstSeguidores = lseguidores;
        this.lstSeguidos = lseguidos;
    }

    public dataUsuario(String nickname, String nombre, String apellido, String mail, dataFecha f_nac, String imagen
            ) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.f_nac = f_nac;
        this.imagen = imagen;
        
    }

    public dataUsuario() {
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public dataFecha getF_nac() {
        return f_nac;
    }

    public void setF_nac(dataFecha f_nac) {
        this.f_nac = f_nac;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Collection<Usuario> getLstSeguidos() {
        return lstSeguidos;
    }

    public void setLstSeguidos(Collection<Usuario> lstSeguidos) {
        this.lstSeguidos = lstSeguidos;
    }

    public Collection<Usuario> getLstSeguidores() {
        return lstSeguidores;
    }

    public void setLstSeguidores(Collection<Usuario> lstSeguidores) {
        this.lstSeguidores = lstSeguidores;
    }

}
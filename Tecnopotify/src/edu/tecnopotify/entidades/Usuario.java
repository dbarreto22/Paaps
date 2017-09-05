package edu.tecnopotify.entidades;

import edu.tecnopotify.datatypes.dataUsuario;
import edu.tecnopotify.datatypes.dataFecha;

import java.awt.Image;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Usuario implements Serializable {

    @Id
    private String nickname;  
    private String nombre;  
    private String apellido;
    private String mail;
    private dataFecha f_nac;
    private String imagen;
    @OneToMany
    private Collection<Usuario> lstSeguidos;

    private Collection<Usuario> lstSeguidores;

    public Usuario(dataUsuario usuario) {
        this.nickname = usuario.getNickname();
        this.nombre = usuario.getNombre();
        this.apellido = usuario.getApellido();
        this.mail = usuario.getMail();
        this.f_nac = usuario.getF_nac();
        this.imagen = usuario.getImagen();
        this.lstSeguidores = usuario.getLstSeguidores();
        this.lstSeguidos = usuario.getLstSeguidos();
    }

    public Usuario() {
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
    
        public void addToSeguidos(Usuario usr){
        this.lstSeguidos.add(usr);
    }
    
    public void removeFromSeguidos(Usuario usr){
        this.lstSeguidos.remove(usr);
    }
    
    public void addToSeguidores(Usuario usr){
        this.lstSeguidores.add(usr);
    }
    
    public void removeFromSeguidores(Usuario usr){
        this.lstSeguidores.remove(usr);
    }

   
}
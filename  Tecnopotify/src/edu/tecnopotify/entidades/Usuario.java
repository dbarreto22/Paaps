package edu.tecnopotify.entidades;
import edu.tecnopotify.datatypes.dataUsuario;
import edu.tecnopotify.datatypes.dataFecha;

import java.awt.Image;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public  class Usuario implements Serializable{
    
        @Id
	private String nickname;
        @Column
	private String nombre;
        @Column
	private String apellido;
        @Column
	private String mail;
        @Column
	private dataFecha f_nac;
        @Column
	private String imagen;

    public Usuario(dataUsuario usuario) {
        this.nickname = usuario.getNickname();
        this.nombre = usuario.getNombre();
        this.apellido = usuario.getApellido();
        this.mail = usuario.getMail();
        this.f_nac = usuario.getF_nac();
        this.imagen = usuario.getImagen();
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

}

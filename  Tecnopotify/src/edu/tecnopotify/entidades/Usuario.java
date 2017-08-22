package edu.tecnopotify.entidades;

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
	private Date f_nac;
        @Column
	private String imagen;

    public Usuario(String nickname, String nombre, String apellido, String mail, Date f_nac, String imagen) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.f_nac = f_nac;
        this.imagen = imagen;
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

	public Date getF_nac() {
		return f_nac;
	}

	public void setF_nac(Date f_nac) {
		this.f_nac = f_nac;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

}

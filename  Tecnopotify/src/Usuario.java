import java.awt.Image;
import java.util.Date;


public abstract class Usuario {

	private String nickname;
	private String nombre;
	private String apellido;
	private String mail;
	private Date f_nac;
	private Image imagen;
	
	
	public Usuario() {
		// TODO Apéndice de constructor generado automáticamente
	}

	/**
	 * @param args
	 */

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

	public Image getImagen() {
		return imagen;
	}

	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}

}

package edu.tecnopotify.entidades;


import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ListaReproduccion implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    @Column
    String nombre;
    @Column
    String imagen;
    @OneToMany
    public Map<String, Temas> listaTemas = new HashMap<String,Temas>();

    
    public ListaReproduccion(String nombre, String imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getStringn() {
        return imagen;
    }

    public void setStringn(String imagen) {
        this.imagen = imagen;
    }
    
    
}

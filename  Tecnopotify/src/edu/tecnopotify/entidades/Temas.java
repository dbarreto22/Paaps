package edu.tecnopotify.entidades;

import edu.tecnopotify.datatypes.dataTemas;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Temas implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    @Column
    private String nombre;
    @Column
    private String duracion;
    @Column
    private int posicion;

    public Temas() {
    }

    public Temas(dataTemas tema) {
        this.nombre = tema.getNombre();
        this.duracion = tema.getDuracion();
        this.posicion = tema.getPosicion();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
}

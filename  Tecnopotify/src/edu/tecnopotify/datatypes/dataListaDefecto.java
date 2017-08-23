package edu.tecnopotify.datatypes;

import edu.tecnopotify.entidades.*;



public class dataListaDefecto extends ListaReproduccion{
    
    private Genero genero;
    
    public dataListaDefecto(String nombre, String imagen, Genero genero) {
        super(nombre, imagen);
    }

    public dataListaDefecto(Genero genero, String nombre, String imagen) {
        super(nombre, imagen);
        this.genero = genero;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    
}

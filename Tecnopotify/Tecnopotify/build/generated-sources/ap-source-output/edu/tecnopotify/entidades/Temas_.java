package edu.tecnopotify.entidades;

import edu.tecnopotify.entidades.ListaReproduccion;
import javax.annotation.Generated;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-04T21:04:56")
@StaticMetamodel(Temas.class)
public class Temas_ { 

    public static volatile SingularAttribute<Temas, Integer> posicion;
    public static volatile MapAttribute<Temas, String, ListaReproduccion> listaR;
    public static volatile SingularAttribute<Temas, String> duracion;
    public static volatile SingularAttribute<Temas, String> nombre;

}
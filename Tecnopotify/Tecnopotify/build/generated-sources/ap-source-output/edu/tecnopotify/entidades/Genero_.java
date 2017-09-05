package edu.tecnopotify.entidades;

import edu.tecnopotify.entidades.Album;
import edu.tecnopotify.entidades.ListaDefecto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-04T21:04:56")
@StaticMetamodel(Genero.class)
public class Genero_ { 

    public static volatile SingularAttribute<Genero, String> padre;
    public static volatile MapAttribute<Genero, String, ListaDefecto> listasReprGenero;
    public static volatile SingularAttribute<Genero, String> nombre;
    public static volatile ListAttribute<Genero, Album> listAlbum;

}
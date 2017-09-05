package edu.tecnopotify.entidades;

import edu.tecnopotify.entidades.Genero;
import edu.tecnopotify.entidades.Temas;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-04T21:04:56")
@StaticMetamodel(Album.class)
public class Album_ { 

    public static volatile ListAttribute<Album, Genero> listGenero;
    public static volatile SingularAttribute<Album, String> imagenAlbum;
    public static volatile ListAttribute<Album, Temas> listTemas;
    public static volatile SingularAttribute<Album, Integer> anioCreado;
    public static volatile SingularAttribute<Album, String> nombre;

}
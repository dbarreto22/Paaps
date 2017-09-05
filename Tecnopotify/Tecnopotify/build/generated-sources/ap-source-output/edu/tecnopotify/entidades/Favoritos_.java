package edu.tecnopotify.entidades;

import edu.tecnopotify.entidades.Album;
import edu.tecnopotify.entidades.Cliente;
import edu.tecnopotify.entidades.ListaReproduccion;
import edu.tecnopotify.entidades.Temas;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-04T21:04:56")
@StaticMetamodel(Favoritos.class)
public class Favoritos_ { 

    public static volatile SingularAttribute<Favoritos, Cliente> cliente;
    public static volatile ListAttribute<Favoritos, ListaReproduccion> listRep;
    public static volatile ListAttribute<Favoritos, Temas> listTemas;
    public static volatile SingularAttribute<Favoritos, Long> id;
    public static volatile ListAttribute<Favoritos, Album> listAlbum;

}
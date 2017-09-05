package edu.tecnopotify.entidades;

import edu.tecnopotify.entidades.ListaParticular;
import edu.tecnopotify.entidades.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-04T21:04:56")
@StaticMetamodel(Cliente.class)
public class Cliente_ extends Usuario_ {

    public static volatile CollectionAttribute<Cliente, ListaParticular> listasReprParticular;
    public static volatile CollectionAttribute<Cliente, Usuario> seguidos;

}
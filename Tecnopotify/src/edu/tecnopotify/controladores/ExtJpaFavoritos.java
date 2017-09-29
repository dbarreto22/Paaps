/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tecnopotify.controladores;

import edu.tecnopotify.controladores.exceptions.PreexistingEntityException;
import edu.tecnopotify.entidades.Album;
import edu.tecnopotify.entidades.Cliente;
import edu.tecnopotify.entidades.Favoritos;
import edu.tecnopotify.entidades.ListaReproduccion;
import edu.tecnopotify.entidades.Temas;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Carlox
 */
public class ExtJpaFavoritos extends FavoritosJpaController {
    
    public ExtJpaFavoritos(EntityManagerFactory emf) {
        super(emf);
    }
    
    public void agregarTemaFav(Temas objeto, Cliente oCliente) throws PreexistingEntityException
    {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Favoritos oFavorito = oCliente.getFav();
            if(oFavorito==null)
                oFavorito=new Favoritos();
            List<Temas> attachedFavoritos = oFavorito.getListTemas();
            attachedFavoritos.add(objeto);
            oFavorito.setListTemas(attachedFavoritos);
            oCliente.setFav(oFavorito);
            em.merge(oCliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PreexistingEntityException("Cliente " + oCliente.toString() + " da error no se cual.", e);
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
        public void agregarAlbumFav(Album objeto, Cliente oCliente) throws PreexistingEntityException
    {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Favoritos oFavorito = oCliente.getFav();
            if(oFavorito==null)
                oFavorito=new Favoritos();
            List<Album> attachedFavoritos = oFavorito.getListAlbum();
            attachedFavoritos.add(objeto);
            oFavorito.setListAlbum(attachedFavoritos);
            oCliente.setFav(oFavorito);
            em.merge(oCliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PreexistingEntityException("Cliente " + oCliente.toString() + " da error no se cual.", e);
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }
        
    public void agregarListaFav(ListaReproduccion objeto, Cliente oCliente) throws PreexistingEntityException
    {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Favoritos oFavorito = oCliente.getFav();
            if(oFavorito==null)
                oFavorito=new Favoritos();
            List<ListaReproduccion> attachedFavoritos = oFavorito.getListRep();
            attachedFavoritos.add(objeto);
            oFavorito.setListRep(attachedFavoritos);
            oCliente.setFav(oFavorito);
            em.merge(oCliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PreexistingEntityException("Cliente " + oCliente.toString() + " da error no se cual.", e);
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
}

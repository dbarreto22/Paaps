/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tecnopotify.controladores;

import edu.tecnopotify.controladores.exceptions.NonexistentEntityException;
import edu.tecnopotify.controladores.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import edu.tecnopotify.entidades.Album;
import edu.tecnopotify.entidades.Genero;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author diego-lucia
 */
public class GeneroJpaController implements Serializable {

    public GeneroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Genero genero) throws PreexistingEntityException, Exception {
        if (genero.getListAlbum() == null) {
            genero.setListAlbum(new ArrayList<Album>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Album> attachedListAlbum = new ArrayList<Album>();
            for (Album listAlbumAlbumToAttach : genero.getListAlbum()) {
                listAlbumAlbumToAttach = em.getReference(listAlbumAlbumToAttach.getClass(), listAlbumAlbumToAttach.getNombre());
                attachedListAlbum.add(listAlbumAlbumToAttach);
            }
            genero.setListAlbum(attachedListAlbum);
            em.persist(genero);
            for (Album listAlbumAlbum : genero.getListAlbum()) {
                listAlbumAlbum.getListGenero().add(genero);
                listAlbumAlbum = em.merge(listAlbumAlbum);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findGenero(genero.getNombre()) != null) {
                throw new PreexistingEntityException("Genero " + genero + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Genero genero) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Genero persistentGenero = em.find(Genero.class, genero.getNombre());
            List<Album> listAlbumOld = persistentGenero.getListAlbum();
            List<Album> listAlbumNew = genero.getListAlbum();
            List<Album> attachedListAlbumNew = new ArrayList<Album>();
            for (Album listAlbumNewAlbumToAttach : listAlbumNew) {
                listAlbumNewAlbumToAttach = em.getReference(listAlbumNewAlbumToAttach.getClass(), listAlbumNewAlbumToAttach.getNombre());
                attachedListAlbumNew.add(listAlbumNewAlbumToAttach);
            }
            listAlbumNew = attachedListAlbumNew;
            genero.setListAlbum(listAlbumNew);
            genero = em.merge(genero);
            for (Album listAlbumOldAlbum : listAlbumOld) {
                if (!listAlbumNew.contains(listAlbumOldAlbum)) {
                    listAlbumOldAlbum.getListGenero().remove(genero);
                    listAlbumOldAlbum = em.merge(listAlbumOldAlbum);
                }
            }
            for (Album listAlbumNewAlbum : listAlbumNew) {
                if (!listAlbumOld.contains(listAlbumNewAlbum)) {
                    listAlbumNewAlbum.getListGenero().add(genero);
                    listAlbumNewAlbum = em.merge(listAlbumNewAlbum);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = genero.getNombre();
                if (findGenero(id) == null) {
                    throw new NonexistentEntityException("The genero with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Genero genero;
            try {
                genero = em.getReference(Genero.class, id);
                genero.getNombre();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The genero with id " + id + " no longer exists.", enfe);
            }
            List<Album> listAlbum = genero.getListAlbum();
            for (Album listAlbumAlbum : listAlbum) {
                listAlbumAlbum.getListGenero().remove(genero);
                listAlbumAlbum = em.merge(listAlbumAlbum);
            }
            em.remove(genero);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Genero> findGeneroEntities() {
        return findGeneroEntities(true, -1, -1);
    }

    public List<Genero> findGeneroEntities(int maxResults, int firstResult) {
        return findGeneroEntities(false, maxResults, firstResult);
    }

    private List<Genero> findGeneroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Genero as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Genero findGenero(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Genero.class, id);
        } finally {
            em.close();
        }
    }

    public int getGeneroCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Genero as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tecnopotify.controladores;

import edu.tecnopotify.controladores.exceptions.NonexistentEntityException;
import edu.tecnopotify.controladores.exceptions.PreexistingEntityException;
import edu.tecnopotify.entidades.ListaReproduccion;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author diego-lucia
 */
public class ListaReproduccionJpaController implements Serializable {

    public ListaReproduccionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ListaReproduccion listaReproduccion) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(listaReproduccion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findListaReproduccion(listaReproduccion.getNombre()) != null) {
                throw new PreexistingEntityException("ListaReproduccion " + listaReproduccion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ListaReproduccion listaReproduccion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            listaReproduccion = em.merge(listaReproduccion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = listaReproduccion.getNombre();
                if (findListaReproduccion(id) == null) {
                    throw new NonexistentEntityException("The listaReproduccion with id " + id + " no longer exists.");
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
            ListaReproduccion listaReproduccion;
            try {
                listaReproduccion = em.getReference(ListaReproduccion.class, id);
                listaReproduccion.getNombre();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The listaReproduccion with id " + id + " no longer exists.", enfe);
            }
            em.remove(listaReproduccion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ListaReproduccion> findListaReproduccionEntities() {
        return findListaReproduccionEntities(true, -1, -1);
    }

    public List<ListaReproduccion> findListaReproduccionEntities(int maxResults, int firstResult) {
        return findListaReproduccionEntities(false, maxResults, firstResult);
    }

    private List<ListaReproduccion> findListaReproduccionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from ListaReproduccion as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public ListaReproduccion findListaReproduccion(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ListaReproduccion.class, id);
        } finally {
            em.close();
        }
    }

    public int getListaReproduccionCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from ListaReproduccion as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

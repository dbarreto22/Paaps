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
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import edu.tecnopotify.entidades.Usuario;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author diego-lucia
 */
public class UsuarioJpaController implements Serializable {

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) throws PreexistingEntityException, Exception {
        if (usuario.getLstSeguidores() == null) {
            usuario.setLstSeguidores(new ArrayList<Usuario>());
        }
        if (usuario.getLstSeguidos() == null) {
            usuario.setLstSeguidos(new ArrayList<Usuario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Usuario> attachedLstSeguidores = new ArrayList<Usuario>();
            for (Usuario lstSeguidoresUsuarioToAttach : usuario.getLstSeguidores()) {
                lstSeguidoresUsuarioToAttach = em.getReference(lstSeguidoresUsuarioToAttach.getClass(), lstSeguidoresUsuarioToAttach.getNickname());
                attachedLstSeguidores.add(lstSeguidoresUsuarioToAttach);
            }
            usuario.setLstSeguidores(attachedLstSeguidores);
            List<Usuario> attachedLstSeguidos = new ArrayList<Usuario>();
            for (Usuario lstSeguidosUsuarioToAttach : usuario.getLstSeguidos()) {
                lstSeguidosUsuarioToAttach = em.getReference(lstSeguidosUsuarioToAttach.getClass(), lstSeguidosUsuarioToAttach.getNickname());
                attachedLstSeguidos.add(lstSeguidosUsuarioToAttach);
            }
            usuario.setLstSeguidos(attachedLstSeguidos);
            em.persist(usuario);
            for (Usuario lstSeguidoresUsuario : usuario.getLstSeguidores()) {
                lstSeguidoresUsuario.getLstSeguidos().add(usuario);
                lstSeguidoresUsuario = em.merge(lstSeguidoresUsuario);
            }
            for (Usuario lstSeguidosUsuario : usuario.getLstSeguidos()) {
                lstSeguidosUsuario.getLstSeguidos().add(usuario);
                lstSeguidosUsuario = em.merge(lstSeguidosUsuario);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUsuario(usuario.getNickname()) != null) {
                throw new PreexistingEntityException("Usuario " + usuario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getNickname());
            List<Usuario> lstSeguidoresOld = persistentUsuario.getLstSeguidores();
            List<Usuario> lstSeguidoresNew = usuario.getLstSeguidores();
            List<Usuario> lstSeguidosOld = persistentUsuario.getLstSeguidos();
            List<Usuario> lstSeguidosNew = usuario.getLstSeguidos();
            List<Usuario> attachedLstSeguidoresNew = new ArrayList<Usuario>();
            for (Usuario lstSeguidoresNewUsuarioToAttach : lstSeguidoresNew) {
                lstSeguidoresNewUsuarioToAttach = em.getReference(lstSeguidoresNewUsuarioToAttach.getClass(), lstSeguidoresNewUsuarioToAttach.getNickname());
                attachedLstSeguidoresNew.add(lstSeguidoresNewUsuarioToAttach);
            }
            lstSeguidoresNew = attachedLstSeguidoresNew;
            usuario.setLstSeguidores(lstSeguidoresNew);
            List<Usuario> attachedLstSeguidosNew = new ArrayList<Usuario>();
            for (Usuario lstSeguidosNewUsuarioToAttach : lstSeguidosNew) {
                lstSeguidosNewUsuarioToAttach = em.getReference(lstSeguidosNewUsuarioToAttach.getClass(), lstSeguidosNewUsuarioToAttach.getNickname());
                attachedLstSeguidosNew.add(lstSeguidosNewUsuarioToAttach);
            }
            lstSeguidosNew = attachedLstSeguidosNew;
            usuario.setLstSeguidos(lstSeguidosNew);
            usuario = em.merge(usuario);
            for (Usuario lstSeguidoresOldUsuario : lstSeguidoresOld) {
                if (!lstSeguidoresNew.contains(lstSeguidoresOldUsuario)) {
                    lstSeguidoresOldUsuario.getLstSeguidos().remove(usuario);
                    lstSeguidoresOldUsuario = em.merge(lstSeguidoresOldUsuario);
                }
            }
            for (Usuario lstSeguidoresNewUsuario : lstSeguidoresNew) {
                if (!lstSeguidoresOld.contains(lstSeguidoresNewUsuario)) {
                    lstSeguidoresNewUsuario.getLstSeguidos().add(usuario);
                    lstSeguidoresNewUsuario = em.merge(lstSeguidoresNewUsuario);
                }
            }
            for (Usuario lstSeguidosOldUsuario : lstSeguidosOld) {
                if (!lstSeguidosNew.contains(lstSeguidosOldUsuario)) {
                    lstSeguidosOldUsuario.getLstSeguidos().remove(usuario);
                    lstSeguidosOldUsuario = em.merge(lstSeguidosOldUsuario);
                }
            }
            for (Usuario lstSeguidosNewUsuario : lstSeguidosNew) {
                if (!lstSeguidosOld.contains(lstSeguidosNewUsuario)) {
                    lstSeguidosNewUsuario.getLstSeguidos().add(usuario);
                    lstSeguidosNewUsuario = em.merge(lstSeguidosNewUsuario);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = usuario.getNickname();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
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
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getNickname();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            Collection<Usuario> lstSeguidores = usuario.getLstSeguidores();
            for (Usuario lstSeguidoresUsuario : lstSeguidores) {
                lstSeguidoresUsuario.getLstSeguidos().remove(usuario);
                lstSeguidoresUsuario = em.merge(lstSeguidoresUsuario);
            }
            Collection<Usuario> lstSeguidos = usuario.getLstSeguidos();
            for (Usuario lstSeguidosUsuario : lstSeguidos) {
                lstSeguidosUsuario.getLstSeguidos().remove(usuario);
                lstSeguidosUsuario = em.merge(lstSeguidosUsuario);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Usuario findUsuario(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tecnopotify.controladores;

import edu.tecnopotify.controladores.exceptions.NonexistentEntityException;
import edu.tecnopotify.controladores.exceptions.PreexistingEntityException;
import edu.tecnopotify.entidades.Cliente;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import edu.tecnopotify.entidades.Usuario;
import java.util.ArrayList;
import java.util.Collection;
import edu.tecnopotify.entidades.ListaParticular;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author diego-lucia
 */
public class ClienteJpaController implements Serializable {

    public ClienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cliente cliente) throws PreexistingEntityException, Exception {
        if (cliente.getLstSeguidores() == null) {
            cliente.setLstSeguidores(new ArrayList<Usuario>());
        }
        if (cliente.getListasReprParticular() == null) {
            cliente.setListasReprParticular(new ArrayList<ListaParticular>());
        }
        if (cliente.getLstSeguidos() == null) {
            cliente.setLstSeguidos(new ArrayList<Usuario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Usuario> attachedLstSeguidores = new ArrayList<Usuario>();
            for (Usuario lstSeguidoresUsuarioToAttach : cliente.getLstSeguidores()) {
                lstSeguidoresUsuarioToAttach = em.getReference(lstSeguidoresUsuarioToAttach.getClass(), lstSeguidoresUsuarioToAttach.getNickname());
                attachedLstSeguidores.add(lstSeguidoresUsuarioToAttach);
            }
            cliente.setLstSeguidores(attachedLstSeguidores);
            Collection<ListaParticular> attachedListasReprParticular = new ArrayList<ListaParticular>();
            for (ListaParticular listasReprParticularListaParticularToAttach : cliente.getListasReprParticular()) {
                listasReprParticularListaParticularToAttach = em.getReference(listasReprParticularListaParticularToAttach.getClass(), listasReprParticularListaParticularToAttach.getNombre());
                attachedListasReprParticular.add(listasReprParticularListaParticularToAttach);
            }
            cliente.setListasReprParticular(attachedListasReprParticular);
            Collection<Usuario> attachedLstSeguidos = new ArrayList<Usuario>();
            for (Usuario lstSeguidosUsuarioToAttach : cliente.getLstSeguidos()) {
                lstSeguidosUsuarioToAttach = em.getReference(lstSeguidosUsuarioToAttach.getClass(), lstSeguidosUsuarioToAttach.getNickname());
                attachedLstSeguidos.add(lstSeguidosUsuarioToAttach);
            }
            cliente.setLstSeguidos(attachedLstSeguidos);
            em.persist(cliente);
            for (Usuario lstSeguidoresUsuario : cliente.getLstSeguidores()) {
                lstSeguidoresUsuario.getLstSeguidos().add(cliente);
                lstSeguidoresUsuario = em.merge(lstSeguidoresUsuario);
            }
            for (ListaParticular listasReprParticularListaParticular : cliente.getListasReprParticular()) {
                listasReprParticularListaParticular.getCliente().add(cliente);
                listasReprParticularListaParticular = em.merge(listasReprParticularListaParticular);
            }
            for (Usuario lstSeguidosUsuario : cliente.getLstSeguidos()) {
                lstSeguidosUsuario.getLstSeguidos().add(cliente);
                lstSeguidosUsuario = em.merge(lstSeguidosUsuario);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCliente(cliente.getNickname()) != null) {
                throw new PreexistingEntityException("Cliente " + cliente + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cliente cliente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente persistentCliente = em.find(Cliente.class, cliente.getNickname());
            Collection<Usuario> lstSeguidoresOld = persistentCliente.getLstSeguidores();
            Collection<Usuario> lstSeguidoresNew = cliente.getLstSeguidores();
            Collection<ListaParticular> listasReprParticularOld = persistentCliente.getListasReprParticular();
            Collection<ListaParticular> listasReprParticularNew = cliente.getListasReprParticular();
            Collection<Usuario> lstSeguidosOld = persistentCliente.getLstSeguidos();
            Collection<Usuario> lstSeguidosNew = cliente.getLstSeguidos();
            Collection<Usuario> attachedLstSeguidoresNew = new ArrayList<Usuario>();
            for (Usuario lstSeguidoresNewUsuarioToAttach : lstSeguidoresNew) {
                lstSeguidoresNewUsuarioToAttach = em.getReference(lstSeguidoresNewUsuarioToAttach.getClass(), lstSeguidoresNewUsuarioToAttach.getNickname());
                attachedLstSeguidoresNew.add(lstSeguidoresNewUsuarioToAttach);
            }
            lstSeguidoresNew = attachedLstSeguidoresNew;
            cliente.setLstSeguidores(lstSeguidoresNew);
            Collection<ListaParticular> attachedListasReprParticularNew = new ArrayList<ListaParticular>();
            for (ListaParticular listasReprParticularNewListaParticularToAttach : listasReprParticularNew) {
                listasReprParticularNewListaParticularToAttach = em.getReference(listasReprParticularNewListaParticularToAttach.getClass(), listasReprParticularNewListaParticularToAttach.getNombre());
                attachedListasReprParticularNew.add(listasReprParticularNewListaParticularToAttach);
            }
            listasReprParticularNew = attachedListasReprParticularNew;
            cliente.setListasReprParticular(listasReprParticularNew);
            Collection<Usuario> attachedLstSeguidosNew = new ArrayList<Usuario>();
            for (Usuario lstSeguidosNewUsuarioToAttach : lstSeguidosNew) {
                lstSeguidosNewUsuarioToAttach = em.getReference(lstSeguidosNewUsuarioToAttach.getClass(), lstSeguidosNewUsuarioToAttach.getNickname());
                attachedLstSeguidosNew.add(lstSeguidosNewUsuarioToAttach);
            }
            lstSeguidosNew = attachedLstSeguidosNew;
            cliente.setLstSeguidos(lstSeguidosNew);
            cliente = em.merge(cliente);
            for (Usuario lstSeguidoresOldUsuario : lstSeguidoresOld) {
                if (!lstSeguidoresNew.contains(lstSeguidoresOldUsuario)) {
                    lstSeguidoresOldUsuario.getLstSeguidos().remove(cliente);
                    lstSeguidoresOldUsuario = em.merge(lstSeguidoresOldUsuario);
                }
            }
            for (Usuario lstSeguidoresNewUsuario : lstSeguidoresNew) {
                if (!lstSeguidoresOld.contains(lstSeguidoresNewUsuario)) {
                    lstSeguidoresNewUsuario.getLstSeguidos().add(cliente);
                    lstSeguidoresNewUsuario = em.merge(lstSeguidoresNewUsuario);
                }
            }
            for (ListaParticular listasReprParticularOldListaParticular : listasReprParticularOld) {
                if (!listasReprParticularNew.contains(listasReprParticularOldListaParticular)) {
                    listasReprParticularOldListaParticular.getCliente().remove(cliente);
                    listasReprParticularOldListaParticular = em.merge(listasReprParticularOldListaParticular);
                }
            }
            for (ListaParticular listasReprParticularNewListaParticular : listasReprParticularNew) {
                if (!listasReprParticularOld.contains(listasReprParticularNewListaParticular)) {
                    listasReprParticularNewListaParticular.getCliente().add(cliente);
                    listasReprParticularNewListaParticular = em.merge(listasReprParticularNewListaParticular);
                }
            }
            for (Usuario lstSeguidosOldUsuario : lstSeguidosOld) {
                if (!lstSeguidosNew.contains(lstSeguidosOldUsuario)) {
                    lstSeguidosOldUsuario.getLstSeguidos().remove(cliente);
                    lstSeguidosOldUsuario = em.merge(lstSeguidosOldUsuario);
                }
            }
            for (Usuario lstSeguidosNewUsuario : lstSeguidosNew) {
                if (!lstSeguidosOld.contains(lstSeguidosNewUsuario)) {
                    lstSeguidosNewUsuario.getLstSeguidos().add(cliente);
                    lstSeguidosNewUsuario = em.merge(lstSeguidosNewUsuario);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = cliente.getNickname();
                if (findCliente(id) == null) {
                    throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.");
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
            Cliente cliente;
            try {
                cliente = em.getReference(Cliente.class, id);
                cliente.getNickname();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.", enfe);
            }
            Collection<Usuario> lstSeguidores = cliente.getLstSeguidores();
            for (Usuario lstSeguidoresUsuario : lstSeguidores) {
                lstSeguidoresUsuario.getLstSeguidos().remove(cliente);
                lstSeguidoresUsuario = em.merge(lstSeguidoresUsuario);
            }
            Collection<ListaParticular> listasReprParticular = cliente.getListasReprParticular();
            for (ListaParticular listasReprParticularListaParticular : listasReprParticular) {
                listasReprParticularListaParticular.getCliente().remove(cliente);
                listasReprParticularListaParticular = em.merge(listasReprParticularListaParticular);
            }
            Collection<Usuario> lstSeguidos = cliente.getLstSeguidos();
            for (Usuario lstSeguidosUsuario : lstSeguidos) {
                lstSeguidosUsuario.getLstSeguidos().remove(cliente);
                lstSeguidosUsuario = em.merge(lstSeguidosUsuario);
            }
            em.remove(cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cliente> findClienteEntities() {
        return findClienteEntities(true, -1, -1);
    }

    public List<Cliente> findClienteEntities(int maxResults, int firstResult) {
        return findClienteEntities(false, maxResults, firstResult);
    }

    private List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliente.class));
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

    public Cliente findCliente(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

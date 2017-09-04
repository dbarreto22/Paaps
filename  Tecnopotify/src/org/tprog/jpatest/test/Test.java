/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tprog.jpatest.test;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.tprog.jpatest.persistencia.Articulo;
import org.tprog.jpatest.persistencia.Factura;
import org.tprog.jpatest.persistencia.LineaFactura;

/**
 *
 * @author pabs
 */
public class Test {

    private void inicializarArticulos(EntityManager em) {
        List articulos = em.createQuery("SELECT a FROM Articulo a").
                getResultList();
        if (articulos.isEmpty()) {
            System.out.println("## Creando articulos.");
            Articulo art1 = new Articulo(),
                    art2 = new Articulo(), art3 = new Articulo();
            art1.setNombre("Cable fibra optica");
            art1.setPrecio(150);
            art2.setNombre("Cable trenzado");
            art2.setPrecio(50);
            art3.setNombre("Cable coaxil");
            art3.setPrecio(100.5);
            em.getTransaction().begin();
            em.persist(art1);
            em.persist(art2);
            em.persist(art3);
            em.getTransaction().commit();
        }else{
            System.out.println("## Recuperando artisculos.");
            for (Object object : articulos) {           
                System.out.println("Articulo: " + object);
            }
        }
        System.out.println("## Fin de inicializo articulos.");
    }

    public void test() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "EjemploJPAPU");
        EntityManager em = emf.createEntityManager();
        try {
            //Se inicializan si es necesario los articulos.
            inicializarArticulos(em);

            //Se solicita una transaccion al entity manager
            em.getTransaction().begin();
            Factura fct = new Factura();
            Articulo ar = null, ar2 = null;

            //obtengo un articulo a traves de una query por nombre
            Query q = em.createQuery("SELECT a FROM Articulo a WHERE a.nombre = ?1");
            q.setParameter(1, "Cable coaxil");
            //Cuidado! si hay mas de un resultado retorna error.
            ar = (Articulo)q.getSingleResult();

            LineaFactura lin1 = new LineaFactura(), lin2 = new LineaFactura();

            fct.setIva(22);

            lin1.setDetalle("Compra 1");
            lin1.setArticulo(ar);
            lin1.setCantidadArticulo(2);

            ar2 = new Articulo();
            ar2.setNombre("Cable comun");
            ar2.setPrecio(20);

            lin2.setDetalle("Compra 2");
            lin2.setArticulo(ar2);
            lin2.setCantidadArticulo(5);

            ArrayList<LineaFactura> lineas = new ArrayList<LineaFactura>();
            lineas.add(lin1);
            lineas.add(lin2);
            fct.setLineas(lineas);

            //Se persisten los objetos que no estan en la base aún.
            em.persist(fct);
            em.flush();

            em.getTransaction().commit();

            //Se consultan todas las facturas.
            for (Object obj : em.createQuery("Select f from Factura f").getResultList()){
                Factura f = (Factura) obj;
                System.out.println("************factura obtenida con una query: " + f);
            }
            
            //Cambiar el id en caso de conocerlo.
            Factura fct1 = em.find(Factura.class,4L);
            System.out.println("*************factura encontrada usando find: " + fct1);
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tprog.jpatest.persistencia;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author pabs *
 */
@Entity
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double iva;
    @OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
    private Collection<LineaFactura> lineas;

    public double getImporte() {
        double importe = 0;

        for (LineaFactura lineaFactura : lineas) {
            importe += lineaFactura.getImporte();
        }
        return importe * iva;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public Collection<LineaFactura> getLineas() {
        return lineas;
    }

    public void setLineas(Collection<LineaFactura> lineas) {
        this.lineas = lineas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Factura[id=" + id + "," +
                getImporte() + "," +
                iva + "," +
                lineas + "]";
    }
}

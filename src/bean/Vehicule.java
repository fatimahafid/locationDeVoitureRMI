/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author fatima
 */
@Entity
public class Vehicule implements Serializable {

    

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String numImm;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateMiseEncirculation;
    private double kilometrage;
    private double prix;
    private boolean pris;//etat z3ma
    private String carburant;
    @ManyToOne
    private Modele modele;
    @OneToMany(mappedBy = "Vehicule")
    private List<Location> locations;

    public String getNumImm() {
        return numImm;
    }

    public void setNumImm(String numImm) {
        this.numImm = numImm;
    }

    public Date getDateMiseEncirculation() {
        return dateMiseEncirculation;
    }

    public void setDateMiseEncirculation(Date dateMiseEncirculation) {
        this.dateMiseEncirculation = dateMiseEncirculation;
    }

    public double getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(double kilometrage) {
        this.kilometrage = kilometrage;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vehicule(Long id, String numImm, Date dateMiseEncirculation, double kilometrage, double prix) {
        this.id = id;
        this.numImm = numImm;
        this.dateMiseEncirculation = dateMiseEncirculation;
        this.kilometrage = kilometrage;
        this.prix = prix;
    }

    public Vehicule(Long id) {
        this.id = id;
    }

    public Vehicule() {
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
        if (!(object instanceof Vehicule)) {
            return false;
        }
        Vehicule other = (Vehicule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.V\u00e9hicule[ id=" + id + " ]";
    }
    
}

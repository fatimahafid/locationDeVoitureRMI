/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author fatima
 */
@Entity
public class Modele implements Serializable {

    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String marquenom;
    private String typenom;
    @OneToOne
    private Marque marque;
    @OneToOne
    private Type type;
    @OneToMany(mappedBy = "modele")
    private List<Vehicule> véhicules;
    @OneToMany(mappedBy = "modele")
    private List<Location> locations;

    public Marque getMarque() {
        return marque;
    }
    

    public String getMarquenom() {
        return marquenom;
    }

    public void setMarquenom() {
        this.marquenom = this.getMarque().getLibelle();
    }

    public String getTypenom() {
        return typenom;
    }

    public void setTypenom() {
        this.typenom = this.getType().getLibelle();
    }

    
    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    

    public List<Vehicule> getVéhicules() {
        return véhicules;
    }

    public void setVéhicules(List<Vehicule> véhicules) {
        this.véhicules = véhicules;
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

    public Modele(Marque marque, Type type) {
        this.marque = marque;
        this.type = type;
         this.marquenom = this.getMarque().getLibelle();
       this.typenom = this.getType().getLibelle();
    }

    public Modele(Long id, Marque marque, Type type) {
        this.id = id;
        this.marque = marque;
        this.type = type;
        
    }

    public Modele( String marquenom, String typenom, Marque marque, Type type) {
        
        this.marque = marque;
        this.type = type;
        this.marquenom = marquenom;
        this.typenom = typenom;
       this.marquenom = this.getMarque().getLibelle();
       this.typenom = this.getType().getLibelle();


    }
    

    public Modele(Long id) {
        this.id = id;
    }

    public Modele() {
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
        if (!(object instanceof Modele)) {
            return false;
        }
        Modele other = (Modele) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Mod\u00e8le[ id=" + id + " ]";
    }
    
}

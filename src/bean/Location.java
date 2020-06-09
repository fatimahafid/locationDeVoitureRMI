/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author fatima
 */
@Entity
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateReservation;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebutLoc;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFinLoc;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebutReelLoc;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFinReelLoc;
    private double mtnLoc;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datePaiementPrevu;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datePaiementEffectif;
    @ManyToOne
    private Modele modele;
    @ManyToOne
    private Vehicule Vehicule;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Agence agence;

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public Date getDateDebutLoc() {
        return dateDebutLoc;
    }

    public void setDateDebutLoc(Date dateDebutLoc) {
        this.dateDebutLoc = dateDebutLoc;
    }

    public Date getDateFinLoc() {
        return dateFinLoc;
    }

    public void setDateFinLoc(Date dateFinLoc) {
        this.dateFinLoc = dateFinLoc;
    }

    public Date getDateDebutReelLoc() {
        return dateDebutReelLoc;
    }

    public void setDateDebutReelLoc(Date dateDebutReelLoc) {
        this.dateDebutReelLoc = dateDebutReelLoc;
    }

    public Date getDateFinReelLoc() {
        return dateFinReelLoc;
    }

    public void setDateFinReelLoc(Date dateFinReelLoc) {
        this.dateFinReelLoc = dateFinReelLoc;
    }

    public double getMtnLoc() {
        return mtnLoc;
    }

    public void setMtnLoc(double mtnLoc) {
        this.mtnLoc = mtnLoc;
    }

    public Date getDatePaiementPrevu() {
        return datePaiementPrevu;
    }

    public void setDatePaiementPrevu(Date datePaiementPrevu) {
        this.datePaiementPrevu = datePaiementPrevu;
    }

    public Date getDatePaiementEffectif() {
        return datePaiementEffectif;
    }

    public void setDatePaiementEffectif(Date datePaiementEffectif) {
        this.datePaiementEffectif = datePaiementEffectif;
    }

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }

    public Vehicule getVehicule() {
        return Vehicule;
    }

    public void setVehicule(Vehicule Vehicule) {
        this.Vehicule = Vehicule;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }
    
    
    
   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Location(Long id, Date dateReservation, Date dateDebutLoc, Date dateFinLoc, Date dateDebutReelLoc, Date dateFinReelLoc, double mtnLoc, Date datePaiementPrevu, Date datePaiementEffectif) {
        this.id = id;
        this.dateReservation = dateReservation;
        this.dateDebutLoc = dateDebutLoc;
        this.dateFinLoc = dateFinLoc;
        this.dateDebutReelLoc = dateDebutReelLoc;
        this.dateFinReelLoc = dateFinReelLoc;
        this.mtnLoc = mtnLoc;
        this.datePaiementPrevu = datePaiementPrevu;
        this.datePaiementEffectif = datePaiementEffectif;
    }

    public Location(Long id) {
        this.id = id;
    }

    public Location() {
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
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Location[ id=" + id + " ]";
    }
    
}

package com.exemple.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;


/**
 * Entité représentant une réservation de l'application.
 * 
 * Cette classe contient les informations suivante :
 * l'id générer automatiquement, la date de début location,
 * la date de début de location, la date de fin de location,
 * le statut de la réservation, l'utilisateur associé et 
 * la borne associée.
 * 
 * @author Vincent
 * @version 1.0
 */

@Entity
@Table(name = "reservation")
public class Reservation {
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDate dateDebut;
    
    @NotNull
    private LocalDate dateFin;
    
    @NotNull
    private StatutReservation statut;

    @ManyToOne
    @JoinColumn(name="utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name="borne_id")
    private BorneRecharge borne;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public StatutReservation getStatut() {
        return statut;
    }

    public void setStatut(StatutReservation statut) {
        this.statut = statut;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public BorneRecharge getBorne() {
        return borne;
    }

    public void setBorne(BorneRecharge borne) {
        this.borne = borne;
    }

    public Reservation() {
    }

    public Reservation(LocalDate dateDebut, LocalDate dateFin, StatutReservation statut, Utilisateur utilisateur, BorneRecharge borne) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.statut = statut;
        this.utilisateur = utilisateur;
        this.borne = borne;
    }

    @Override
    public String toString() {
        return "Reservation [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", statut=" + statut
                + ", utilisateur=" + utilisateur + ", borne=" + borne + "]";
    }

}

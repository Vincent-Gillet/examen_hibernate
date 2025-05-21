package com.exemple.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

 /**
 * Entité représentant une borne de recharge de l'application.
 * 
 * Cette classe contient les informations suivante :
 * l'id générer automatiquement, son état, son tarif,
 * et la liste des réservations associées.
 * 
 * @author Vincent
 * @version 1.0
 */

@Entity
@Table(name = "borne")
public class BorneRecharge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private EtatBorne etat;

    @NotNull
    private double tarifHoraire;

    @ManyToOne
    @JoinColumn(name="lieu_id")
    private LieuRecharge lieu;

    @OneToMany(mappedBy = "borne", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservation = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EtatBorne getEtat() {
        return etat;
    }

    public void setEtat(EtatBorne etat) {
        this.etat = etat;
    }

    public double getTarifHoraire() {
        return tarifHoraire;
    }

    public void setTarifHoraire(double tarifHoraire) {
        this.tarifHoraire = tarifHoraire;
    }

    public BorneRecharge(double tarifHoraire) {
        this.etat = EtatBorne.DISPONIBLE;
        this.tarifHoraire = tarifHoraire;
    }

    public BorneRecharge(Long id) {
        this.tarifHoraire = tarifHoraire;
    }

    public BorneRecharge() {
    }

    public BorneRecharge(EtatBorne etat, double tarifHoraire, LieuRecharge lieu) {
        this.etat = etat;
        this.tarifHoraire = tarifHoraire;
        this.lieu = lieu;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BorneRecharge{");
        sb.append("id=").append(id);
        sb.append(", etat=").append(etat);
        sb.append(", tarifHoraire=").append(tarifHoraire);
        sb.append('}');
        return sb.toString();
    }



}

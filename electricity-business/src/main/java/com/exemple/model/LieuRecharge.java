package com.exemple.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

/**
 * Entité représentant un lieu de recharge de l'application.
 * 
 * Cette classe contient les informations suivante :
 * l'id générer automatiquement, son nom,
 * son adresse et la liste des bornes de recharge associées.
 * 
 * @author Vincent
 * @version 1.0
 */

@Entity
@Table(name = "lieu")
public class LieuRecharge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nom;

    @NotNull
    private String adresse;

    @OneToMany(mappedBy = "lieu", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BorneRecharge> bornes = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<BorneRecharge> getBornes() {
        return bornes;
    }

    public void setBornes(List<BorneRecharge> bornes) {
        this.bornes = bornes;
    }

    public LieuRecharge() {
    }

    public LieuRecharge(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LieuRecharge{");
        sb.append("id=").append(id);
        sb.append(", nom=").append(nom);
        sb.append(", adresse=").append(adresse);
        sb.append('}');
        return sb.toString();
    }



}

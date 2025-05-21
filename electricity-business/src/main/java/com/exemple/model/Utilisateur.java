package com.exemple.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

/**
 * Entité représentant un utilisateur de l'application.
 * 
 * Cette classe contient les informations suivante :
 * l'id généré automatiquement à la création, l'email, le mot de passe,
 * un code de validation généré automatiquement à la création,
 * un indicateur de validation du compte, et la liste des réservations associées.
 * 
 * @author Vincent
 * @version 1.0
 */

@Entity
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotNull
    private String email;

    @NotNull
    private String motDePasse;

    @NotNull
    private String codeValidation = UUID.randomUUID().toString().substring(0, 6);
    
    @NotNull
    private boolean valide;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservation = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getCodeValidation() {
        return codeValidation;
    }

    public void setCodeValidation(String codeValidation) {
        this.codeValidation = codeValidation;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    public Utilisateur() {
    }

    public Utilisateur(String email, String motDePasse, boolean estValide) {
        this.email = email;
        this.motDePasse = motDePasse;
        this.valide = estValide;
    }

    @Override
    public String toString() {
        return "Information utilisateur :\r\n" +
                "Id : " + this.id + "\r\n" +
                "email : " + this.email + "\r\n" +
                "Mot de passe : " + this.motDePasse + "\r\n" +
                "Code de validation : " + this.codeValidation + "\r\n" +
                "Utilisateur valide : " + this.valide + "\r\n";
    }
    
}

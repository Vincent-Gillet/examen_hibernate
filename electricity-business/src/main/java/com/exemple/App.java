package com.exemple;

import java.time.LocalDate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.exemple.dao.BorneRechargeDao;
import com.exemple.dao.LieuRechargeDao;
import com.exemple.dao.ReservationDao;
import com.exemple.dao.UtilisateurDao;
import com.exemple.model.BorneRecharge;
import com.exemple.model.EtatBorne;
import com.exemple.model.LieuRecharge;
import com.exemple.model.Reservation;
import com.exemple.model.StatutReservation;
import com.exemple.model.Utilisateur;

public class App {
    public static void main(String[] args) {
        System.out.println("Démarrage de l'application");
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure()
            .build();
        Metadata metadata = new MetadataSources(registry).buildMetadata();
        SessionFactory sessionFactory = metadata.buildSessionFactory();
        System.out.println("Connexion réussie !");

        UtilisateurDao utilisateurDao = new UtilisateurDao(sessionFactory);

        Utilisateur utilisateur1 = new Utilisateur("bob@bob.com", "azerty", false);
        Utilisateur utilisateur2 = new Utilisateur("john@john.com", "azerty", false);
        Utilisateur utilisateur3 = new Utilisateur("jean@jean.com", "azerty", false);

        utilisateur1 = new Utilisateur("martin@martin.com", "azerty", false);
        utilisateurDao.creer(utilisateur1);
        utilisateurDao.creer(utilisateur2);
        utilisateurDao.creer(utilisateur3);
        utilisateurDao.lire(utilisateur1.getId());
        utilisateurDao.tout();
        utilisateurDao.mettreAJour(utilisateur1);

        LieuRechargeDao lieuDao = new LieuRechargeDao(sessionFactory);
        LieuRecharge lieu1 = new LieuRecharge("Lieu 1", "Adresse 1");
        LieuRecharge lieu2 = new LieuRecharge("Lieu 2", "Adresse 2");
        LieuRecharge lieu3 = new LieuRecharge("Lieu 3", "Adresse 3");

        lieu1 = new LieuRecharge("Nouveau Lieu 1", "Adresse 1");
        lieuDao.creer(lieu1);
        lieuDao.creer(lieu2);
        lieuDao.creer(lieu3);
        lieuDao.lire(lieu1.getId());
        lieuDao.tout();
        lieuDao.mettreAJour(lieu1);

        BorneRechargeDao borneDao = new BorneRechargeDao(sessionFactory); 
        BorneRecharge borneRecharge1 = new BorneRecharge(EtatBorne.DISPONIBLE, 1.00, lieu1);
        BorneRecharge borneRecharge2 = new BorneRecharge(EtatBorne.DISPONIBLE, 2.00, lieu1);
        BorneRecharge borneRecharge3 = new BorneRecharge(EtatBorne.MAINTENANCE, 3.00, lieu1);
        BorneRecharge borneRecharge4 = new BorneRecharge(EtatBorne.DISPONIBLE, 2.00, lieu2);
        BorneRecharge borneRecharge5 = new BorneRecharge(EtatBorne.DISPONIBLE, 1.00, lieu2);
        BorneRecharge borneRecharge6 = new BorneRecharge(EtatBorne.DISPONIBLE, 2.00, lieu3);
        BorneRecharge borneRecharge7 = new BorneRecharge(EtatBorne.DISPONIBLE, 1.00, lieu3);
        BorneRecharge borneRecharge8 = new BorneRecharge(EtatBorne.MAINTENANCE, 2.00, lieu3);
        BorneRecharge borneRecharge9 = new BorneRecharge(EtatBorne.DISPONIBLE, 2.00, lieu3);
        
        borneDao.creer(borneRecharge1);
        borneDao.creer(borneRecharge2);
        borneDao.creer(borneRecharge3);
        borneDao.creer(borneRecharge4);
        borneDao.creer(borneRecharge5);
        borneDao.creer(borneRecharge6);
        borneDao.creer(borneRecharge7);
        borneDao.creer(borneRecharge8);
        borneDao.creer(borneRecharge9);
        borneDao.lire(lieu1.getId());
        borneDao.tout();
        borneDao.mettreAJour(borneRecharge3);


        ReservationDao reservationDao = new ReservationDao(sessionFactory); 
        Reservation reservation1 = new Reservation(LocalDate.parse("2025-10-10"), LocalDate.parse("2025-10-11"), StatutReservation.EN_ATTENTE, utilisateur1, borneRecharge1);
        Reservation reservation2 = new Reservation(LocalDate.parse("2025-08-10"), LocalDate.parse("2025-08-10"), StatutReservation.REFUSE, utilisateur1, borneRecharge4);
        Reservation reservation3 = new Reservation(LocalDate.parse("2026-10-10"), LocalDate.parse("2026-10-10"), StatutReservation.ACCEPTE, utilisateur1, borneRecharge5);
        Reservation reservation4 = new Reservation(LocalDate.parse("2024-10-10"), LocalDate.parse("2024-10-10"), StatutReservation.EN_ATTENTE, utilisateur3, borneRecharge9);

        reservationDao.creer(reservation1);
        reservationDao.creer(reservation2);
        reservationDao.creer(reservation3);
        reservationDao.creer(reservation4);
        reservationDao.lire(reservation1.getId());
        reservationDao.tout();
        reservationDao.mettreAJour(reservation1);




        // reservationDao.supprimer(reservation1.getId());
        // borneDao.supprimer(borneRecharge3.getId());
        // lieuDao.supprimer(lieu2.getId());
        // utilisateurDao.supprimer(utilisateur2.getId());


        // 2. 📅 Lister toutes les réservations faites par un utilisateur donné, triées par date.
        System.out.println("Reservation tirer de l'utilisateur 1 : " + reservationDao.triParDate(1L));

        // 4. 🧾 Rechercher les bornes dont le tarif horaire dépasse une certaine valeur.
        System.out.println("Bornes dont le tarif horaire dépasse 1€ : " + borneDao.tarifSperieurA(1.00));

        // 5. 🛠️ Trouver les bornes actuellement en maintenance ou inactives (filtrage sur l'état).
        System.out.println("Bornes tirer par état : " + borneDao.triParEtat(EtatBorne.MAINTENANCE));

    }
}

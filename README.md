# Rendu Examen Hibernate - Gestion de bornes de recharge électrique

## Description

Ce projet est une application Java utilisant Hibernate pour gérer :
- Les **utilisateurs**
- Les **bornes de recharge**
- Les **réservations**

Chaque entité est persistée en base de données via une architecture ORM, avec des DAO génériques et spécifiques.

---

## Architecture

- **Base de données** : MySQL (via Docker)
- **ORM** : Hibernate avec annotations JPA
- **Java** : version 17
- **Structure DAO** : 
  - Interface `GenericDao<T, ID>` pour les opérations CRUD génériques
  - Classe abstraite `GenericDaoImpl<T, ID>` qui implémente les opérations génériques
  - DAO spécifiques (comme `BorneRechargeDao`) avec des méthodes personnalisées

---

## Choix techniques

- **Java 17**
- **Docker** pour faire fonctionner mon application et ma bdd
- **Hibernate / JPA** pour l’ORM
- **MySQL** pour la base de données
- **DAO générique (`GenericDao<T, ID>`)** pour centraliser les opérations CRUD

---

## Lancement du projet

1. Exécuter le container docker à partir du dossier contenant tout le projet : ```bash docker compose up --build app```
2. Accéder aux tables à partir du project maven : ```bash docker exec -it mysql-electricity-business mysql -uroot -p```
3. Entrez le mot de passe : ```bash root``

---

## Bonus réalisés

### Dans ReservationDao.java
- 2. 📅 **Lister toutes les réservations** faites par un utilisateur donné, triées par date.

### Dans BorneRechargeDao.java
- 4. 🧾 **Rechercher les bornes** dont le tarif horaire dépasse une certaine valeur.
- 5. 🛠️ **Trouver les bornes actuellement en maintenance** ou inactives (filtrage sur l'état).

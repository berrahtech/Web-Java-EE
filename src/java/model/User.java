package model;

// Classe représentant un utilisateur avec nom et email
public class User {
    private String nom;
    private String email;

    // Constructeur avec paramètres
    public User(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }

    // Getter pour le nom
    public String getNom() {
        return nom;
    }

    // Setter pour le nom
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter pour l'email
    public String getEmail() {
        return email;
    }

    // Setter pour l'email
    public void setEmail(String email) {
        this.email = email;
    }

    // Méthode toString pour un affichage clair
    @Override
    public String toString() {
        return "User{nom='" + nom + "', email='" + email + "'}";
    }
}
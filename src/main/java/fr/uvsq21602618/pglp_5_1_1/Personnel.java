package fr.uvsq21602618.pglp_5_1_1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 * Classe d'un personnel.
 * Possède un nom et prénom,
 * une fonction, une date de naissance
 * et une liste de numéros de téléphone.
 * @author Nathalie
 */
public final class Personnel implements Composant, Serializable {
    /**
     * SerialVersion.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Méthode de hachage.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((dateNaissance == null) ? 0 : dateNaissance.hashCode());
        result = prime * result
                + ((fonction == null) ? 0 : fonction.hashCode());
        result = prime * result
                + ((nom == null) ? 0 : nom.hashCode());
        result = prime * result
                + ((numTelephones == null) ? 0 : numTelephones.hashCode());
        result = prime * result
                + ((prenom == null) ? 0 : prenom.hashCode());
        return result;
    }
    /**
     * Méthode de comparaison.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Personnel other = (Personnel) obj;
        if (dateNaissance == null) {
            if (other.dateNaissance != null) {
                return false;
            }
        } else if (!dateNaissance.equals(other.dateNaissance)) {
            return false;
        }
        if (fonction == null) {
            if (other.fonction != null) {
                return false;
            }
        } else if (!fonction.equals(other.fonction)) {
            return false;
        }
        if (nom == null) {
            if (other.nom != null) {
                return false;
            }
        } else if (!nom.equals(other.nom)) {
            return false;
        }
        if (numTelephones == null) {
            if (other.numTelephones != null) {
                return false;
            }
        } else if (!numTelephones.equals(other.numTelephones)) {
            return false;
        }
        if (prenom == null) {
            if (other.prenom != null) {
                return false;
            }
        } else if (!prenom.equals(other.prenom)) {
            return false;
        }
        return true;
    }
    /**
     * Nom du personnel.
     */
    private String nom;
    /**
     * Prenom du personnel.
     */
    private String prenom;
    /**
     * Fonction du personnel.
     */
    private String fonction;
    /**
     * Date de naissance du personnel.
     */
    private LocalDate dateNaissance;
    /**
     * Liste de numéros de téléphones avec descriptif.
     */
    private final ArrayList<NumeroTelephone> numTelephones;
    /**
     * L'id.
     */
    private final int id;
    /**
     * Builder qui permet la construction d'un personnel.
     * @author natha
     *
     */
    public static class Builder {
        /**
         * nom.
         */
        private final String nom;
        /**
         * prenom.
         */
        private final String prenom;
        /**
         * fonction.
         */
        private final String fonction;
        /**
         * date de naissance.
         */
        private final LocalDate dateNaissance;
        /**
         * Id de l'instance.
         */
        private final int id;
        /**
         * Liste de numéros avec descriptif.
         */
        private final ArrayList<NumeroTelephone> numTelephones;
        /**
         * Constructeur. Utilisation du Builder pour Personnel.
         * @param nom2 le nom
         * @param prm le prenom
         * @param fonc la fonction
         * @param date la date de naissance
         * @param id2 l'id
         */
        public Builder(final String nom2, final String prm,
                final String fonc,
                final LocalDate date, final int id2) {
            this.nom = nom2;
            this.prenom = prm;
            this.fonction = fonc;
            this.dateNaissance = date;
            this.numTelephones = new ArrayList<NumeroTelephone>();
            this.id = id2;
        }
        /**
         * Ajoute un numéro de téléphone.
         * @param num le numéro et descriptif
         * @return Builder du Personnel
         */
        public Builder numTelephones(final NumeroTelephone num) {
            this.numTelephones.add(num);
            return this;
        }
        /**
         * Retourne le personnel créé à partir du Builder.
         * @return Personnel
         */
        public Personnel build() {
            return new Personnel(this);
        }
    }
    /**
     * Le constructeur créé un Personnel à partir des informations du builder.
     * @param builder Builder du Personnel
     */
    private Personnel(final Builder builder) {
        nom = builder.nom;
        prenom = builder.prenom;
        fonction = builder.fonction;
        dateNaissance = builder.dateNaissance;
        numTelephones = builder.numTelephones;
        id = builder.id;
    }
    /**
     * Méthode retourne le nom du personnel.
     * @return nom
     */
    public String getNom() {
        return nom;
    }
    /**
     * Méthode retourne le prénom du personnel.
     * @return prenom
     */
    public String getPrenom() {
        return prenom;
    }
    /**
     * Méthode retourne la fonction du personnel.
     * @return fonction
     */
    public String getFonction() {
        return fonction;
    }
    /**
     * Méthode retourne la date de naissance.
     * @return date de naissance
     */
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }
    /**
     * retourne la liste des numéros.
     * @return liste de numéros
     */
    public ArrayList<NumeroTelephone> getNumTelephones() {
        return numTelephones;
    }
    /**
     * Retourne l'id de l'instance.
     * @return l'id
     */
    public int getId() {
        return id;
    }
    /**
     * Méthode affiche les informations du personnel.
     */
    public void print() {
        System.out.println(this.nom + " " + this.prenom + ": \nfonction: "
                + this.fonction + "\ndate de naissance: "
                + this.dateNaissance + "\n");
    }
    /**
     * Methode pour definir le nom du personnel.
     * @param nom2 le nom
     */
    public void setNom(final String nom2) {
        this.nom = nom2;
    }
    /**
     * Methode pour definir le prenom du personnel.
     * @param prenom2 le prenom
     */
    public void setPrenom(final String prenom2) {
        this.prenom = prenom2;
    }
    /**
     * Methode pour definir la fonction du personnel.
     * @param fonction2 la fonction
     */
    public void setFonction(final String fonction2) {
        this.fonction = fonction2;
    }
    /**
     * Methode pour definir la date de naissance de personnel.
     * @param date2 la date de naissance
     */
    public void setNaissance(final LocalDate date2) {
        this.dateNaissance = date2;
    }
    /**
     * Méthode pour retourner les infos sous forme de String.
     * @return les infos de personnel
     */
    public String toString() { 
        return (this.nom + " " + this.prenom + ": \nfonction: "
                + this.fonction + "\ndate de naissance: "
                + this.dateNaissance + "\n");
    }
}

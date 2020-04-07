package fr.uvsq21602618.pglp_5_1_1;

import java.io.Serializable;

/**
 * Classe qui représente le numéro de téléphone.
 * @author natha
 *
 */
public class NumeroTelephone implements Serializable {
    /**
     * SerialVersion
     */
    private static final long serialVersionUID = 1L;
    /**
     * Méthode de hachage.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((descriptif == null) ? 0 : descriptif.hashCode());
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
        return result;
    }
    /**
     * Méthode de comparaison.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NumeroTelephone other = (NumeroTelephone) obj;
        if (descriptif == null) {
            if (other.descriptif != null)
                return false;
        } else if (!descriptif.equals(other.descriptif))
            return false;
        if (numero == null) {
            if (other.numero != null)
                return false;
        } else if (!numero.equals(other.numero))
            return false;
        return true;
    }
    /**
     * Le type de numéro (fixe, portable...).
     */
    private final String descriptif;
    /**
     * Le numéro en lui-même avec des chiffres.
     */
    private final String numero;
    /**
     * Le constructeur du numéro de téléphone.
     * @param desc la description du numéro (fixe, portable ...)
     * @param num le numéro de téléphones
     */
    public NumeroTelephone(final String desc, final String num) {
        this.descriptif = desc;
        this.numero = num;
    }
    /**
     * Méthode pour récupérer le descriptif du numéro.
     * @return string le descriptif
     */
    public String getDescriptif() {
        return descriptif;
    }
    /**
     * Méthode pour récupérer le numéro de téléphone.
     * @return string le numéro
     */
    public String getNumero() {
        return numero;
    }
    /**
     * Méthode pour recuperer le descriptif ainsi que le numero.
     * @return le descriptif et le numero
     */
    public String toString() {
        return this.getDescriptif() + ": " + this.getNumero();
    }
}

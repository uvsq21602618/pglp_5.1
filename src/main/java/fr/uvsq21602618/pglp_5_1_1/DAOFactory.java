package fr.uvsq21602618.pglp_5_1_1;
/**
 * Classe de la fabrique DAO.
 * @author Nathalie
 */
public class DAOFactory {
    /**
     * Méthode pour récuperer le DAO de NumeroTelephone.
     * @return le DAO correspondant
     */
    public static DAO<NumeroTelephone> getNumeroTelephoneDAO() {
        return new NumeroTelephoneDAO();
    }
    /**
     * Méthode pour récuperer le DAO de Personnel.
     * @return le DAO correspondant
     */
    public static DAO<Personnel> getPersonnelDAO() {
        return new PersonnelDAO();
    }
    /**
     * Méthode pour récuperer le DAO de GroupePersonnels.
     * @return le DAO correspondant
     */
    public static DAO<GroupePersonnels> getGroupePersonnels() {
        return new GroupePersonnelsDAO();
    }
}


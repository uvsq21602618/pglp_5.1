package fr.uvsq21602618.pglp_5_1_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.Scanner;

/**
 * Classe NumerotTelephoneDAO.
 * @author Nathalie
 *
 */
public class NumeroTelephoneDAO extends DAO<NumeroTelephone> {
    /**
     * Constructeur de NumeroTelephoneDAO.
     * @param id du fichier
     * @throws IOException Exceptions liees aux entrees/sorties 
     */
    public NumeroTelephoneDAO(int id) throws IOException {
        super(id);
    }
    /**
     * Méthode de création.
     * @param obj L'objet à créer
     * @return obj l'objet qui vient d'etre creer
     * @throws IOException Exceptions liees aux entrees/sorties 
     */
    @Override
    public NumeroTelephone create(NumeroTelephone obj) throws IOException {
        objOut.writeObject(obj);
        return obj;
    }
    /**
     * Méthode pour effacer.
     * @param obj L'objet à effacer
     */
    public void delete(NumeroTelephone obj) {
        f.delete();
    }
    /**
     * Méthode de mise à jour.
     * @param obj L'objet à mettre à jour
     * @throws IOException 
     */
    public NumeroTelephone update(NumeroTelephone obj) throws IOException { 
        f.delete();
        this.create(obj);
        return obj;
    }
    /**
     * Méthode de recherche des informations.
     * @param id de l'information 
     * @return num du fichier Exception si la classe n'existe pas
     * @throws IOException Exception liee aux entreés/sorties
     * @throws ClassNotFoundException 
     */
    public NumeroTelephone find(int id) throws IOException, ClassNotFoundException {
        File search = new File(id + ".txt");
        Object deserialized = null;
        if (search.exists()) {
            byte[] fileContent = Files.readAllBytes(search.toPath());
            /*Scanner myReader = new Scanner(search);
            while (myReader.hasNextLine()) {
                data = data + myReader.nextLine();
                //System.out.println(data);
            }*/
            deserialized = deserialize(fileContent);
        }
        NumeroTelephone num = (NumeroTelephone) deserialized;
        System.out.println(num.toString());
        return num;
    }
}

package fr.uvsq21602618.pglp_5_1_1;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.uvsq21602618.pglp_5_1_1.Personnel.Builder;
/**
 * Classe de tests pour la classe Personnel.
 * @author Nathalie
 *
 */
public class PersonnelTest {
    /**
     * Instances de Personnel.
     */
    Personnel secretaire;
    /**
     * Initialisation des instances pour les tests.
     */
    @Before
    public void setUp() {
        NumeroTelephone portable =
                new NumeroTelephone("portable", "0651624519");
        Builder b = new Builder("SMITH", "John", "secrétaire",
                LocalDate.of(1964, 8, 25));
        b.numTelephones(portable);
        Personnel p = b.build();
        secretaire = p;
    }
    /**
     * Teste le constructeur de Personnel utilisant
     * le pattern Builder.
     */
    @Test
    public void constructeurTest() {
        String expDesc = "portable";
        String expNum = "0651624519";
        String expNom = "SMITH";
        String expPrenom = "John";
        String expFonction = "secrétaire";
        LocalDate expDate = LocalDate.of(1964, 8, 25);

        assertEquals(expDesc,
                secretaire.getNumTelephones().get(0).getDescriptif());
        assertEquals(expNum, secretaire.getNumTelephones().get(0).getNumero());
        assertEquals(expNom, secretaire.getNom());
        assertEquals(expPrenom, secretaire.getPrenom());
        assertEquals(expFonction, secretaire.getFonction());
        assertEquals(expDate, secretaire.getDateNaissance());

    }
    /**
     * Méthode de désérialisation.
     * @param bytes le tableau d'octets à transformer en objet.
     * @return L'objet obtenu.
     * @throws ClassNotFoundException Exception si la classe n'existe pas.
     * @throws IOException Exception liee aux entreés/sorties
     */
    private Object deserialize(final byte[] bytes) throws ClassNotFoundException, IOException {
        ByteArrayInputStream b = new ByteArrayInputStream(bytes);
        ObjectInputStream o = new ObjectInputStream(b);
        return o.readObject();
    }
    /**
     * Méthode de sérialisation.
     * @param obj L'objet à transformer en flux d'octets.
     * @return flux d'octets de l'objet.
     * @throws IOException Exception liee aux entreés/sorties
     */
    private byte[] serialize(final Object obj) throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(b);
        o.writeObject(obj);
        return b.toByteArray();
    }
    /**
     * Tests sur la transformation dans les deux sens.
     * @throws IOException Exception liee aux entreés/sorties
     * @throws ClassNotFoundException Exception si la classe n'existe pas
     */
    @Test
    public void ConsistencyTest() throws IOException, ClassNotFoundException {
        Personnel p = secretaire;
        byte[] serialized1 = serialize(p);
        byte[] serialized2 = serialize(p);

        Object deserialized1 = deserialize(serialized1);
        Object deserialized2 = deserialize(serialized2);
        Assert.assertEquals(deserialized1, deserialized2);
        Assert.assertEquals(p, deserialized1);
        Assert.assertEquals(p, deserialized2);
    }
}

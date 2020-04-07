package fr.uvsq21602618.pglp_5_1_1;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * Classe de tests pour la classe NumeroTelephone.
 * @author Nathalie
 *
 */
public class NumeroTelephoneTest {
    /**
     * Instances de NumeroTelephone.
     */
    NumeroTelephone tel;
    /**
     * Initialisation des instances pour les tests.
     */
    @Before
    public void setUp() {
        tel = new NumeroTelephone("fixe", "0167874973");
    }
    /**
     * Teste le méthode getDescriptif.
     */
    @Test
    public void getDescriptifTest() {
        String expected = "fixe";
        assertEquals(expected, tel.getDescriptif());
    }
    /**
     * Teste la méthode getNumeroTest.
     */
    @Test
    public void getNumeroTest() {
        NumeroTelephone tel = new NumeroTelephone("fixe", "0167874973");
        String expected = "0167874973";
        assertEquals(expected, tel.getNumero());
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
        byte[] serialized1 = serialize(tel);
        byte[] serialized2 = serialize(tel);

        Object deserialized1 = deserialize(serialized1);
        Object deserialized2 = deserialize(serialized2);
        Assert.assertEquals(deserialized1, deserialized2);
        Assert.assertEquals(tel, deserialized1);
        Assert.assertEquals(tel, deserialized2);
    }
}

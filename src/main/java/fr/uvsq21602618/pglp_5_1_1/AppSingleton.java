package fr.uvsq21602618.pglp_5_1_1;

//import java.time.LocalDate;

//import fr.uvsq21602618.pglp_5_1_1.Personnel.Builder;
/**
 * Singleton contenant le main.
 * @author Nathalie
 */
public enum AppSingleton {
    /**
     * L'enum qui contient le code du main.
     */
    ENVIRONNEMENT;
    /**
     * Execution du programme.
     */
    public void run() {
        /*NumeroTelephone portable =
                new NumeroTelephone("portable", "0651624519", 1);
        Builder b = new Builder("SMITH", "John", "secrétaire",
                LocalDate.of(1964, 8, 25), 1);
        b.numTelephones(portable);
        Personnel secretaire = b.build();
        NumeroTelephone portable2 =
                new NumeroTelephone("portable", "0651424519", 2);
        Builder b2 = new Builder("WHITE", "Jim", "chef de service",
                LocalDate.of(1964, 8, 25), 2);
        b2.numTelephones(portable2);
        Personnel chefDeService = b2.build();
        NumeroTelephone portable3 =
                new NumeroTelephone("portable", "0631624519", 3);
        Builder b3 = new Builder("BLACK", "Leah", "employe",
                LocalDate.of(1964, 8, 15), 3);
        b3.numTelephones(portable3);
        Personnel employe = b3.build();

        NumeroTelephone portable4 =
                new NumeroTelephone("portable", "0699624519", 4);
        Builder b4 = new Builder("CASTEL", "Joe", "employe",
                LocalDate.of(1964, 3, 15), 4);
        b4.numTelephones(portable4);
        Personnel employe2 = b4.build();

        NumeroTelephone portable5 =
                new NumeroTelephone("portable", "0611624519", 5);
        Builder b5 = new Builder("MARTIN", "Jack",
                "chef du departement",
                LocalDate.of(1954, 8, 25), 5);
        b5.numTelephones(portable5);
        Personnel chefDepartement =  b5.build();

        NumeroTelephone portable6 =
                new NumeroTelephone("portable", "0611624919", 5);
        Builder b6 = new Builder("LOGAN", "Max", "chef d'équipe",
                LocalDate.of(1954, 8, 25), 6);
        b6.numTelephones(portable6);
        Personnel chefEquipe = b6.build();

        GroupePersonnels departement =
                new GroupePersonnels("Departement", 1);
        GroupePersonnels service2 =
                new GroupePersonnels("Service2", 2);
        GroupePersonnels service =
                new GroupePersonnels("Service", 3);
        GroupePersonnels equipe1 =
                new GroupePersonnels("Equipe1", 4);
        GroupePersonnels equipe2 =
                new GroupePersonnels("Equipe2", 5);
        GroupePersonnels equipe3 =
                new GroupePersonnels("Equipe3", 6);

        service2.add(equipe3);

        equipe1.add(chefEquipe);
        equipe1.add(employe);
        equipe2.add(employe2);

        service.add(chefDeService);
        service.add(chefEquipe);
        service.add(employe);
        service.add(employe2);
        service.add(equipe1);
        service.add(equipe2);

        departement.add(chefDeService);
        departement.add(secretaire);
        departement.add(employe);
        departement.add(employe2);
        departement.add(chefDepartement);
        departement.add(chefEquipe);
        departement.add(service);
        departement.add(service2);

        //Departement.print();

        departement.hierarchie();*/

    }
    /**
     * Main.
     * @param args pour le main
     */
    public static void main(final String[] args) {
        ENVIRONNEMENT.run();
    }
}

package fr.sdv.composite;

public class TestComposite {

    public static void main(String[] args) {

        // employes
        //DSIN
        Employe e1 = new Employe("RASPEY", "Céline", 10000);
        Employe e2 = new Employe("BECHKAR", "Bilel", 8000);

        // Java Dev
        Employe e3 = new Employe("GUINEAU", "Kevin", 7500);
        Employe e4 = new Employe("MARTIN", "Paul", 3500);

        // Big Data
        Employe e5 = new Employe("RANMEY", "Jb", 7500);
        Employe e6 = new Employe("DOE", "Jane", 3500);

        // services
        Service dsin = new Service("DSIN");
        Service javaDev = new Service("Java Dev");
        Service bigData = new Service("Big Data");

        // affectation des employés
        dsin.ajouter(e1);
        dsin.ajouter(e2);

        javaDev.ajouter(e3);
        javaDev.ajouter(e4);

        bigData.ajouter(e5);
        bigData.ajouter(e6);

        Service systemeInformation = new Service("Système d'Information");

        systemeInformation.ajouter(dsin);
        systemeInformation.ajouter(javaDev);
        systemeInformation.ajouter(bigData);

        // calcul salaire
        System.out.println("Salaire DSIN : " + dsin.calculerSalaire());
        System.out.println("Salaire Java Dev : " + javaDev.calculerSalaire());
        System.out.println("Salaire Big Data : " + bigData.calculerSalaire());
        System.out.println("Salaire SI global : " + systemeInformation.calculerSalaire());
    }
}

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Catalogue catalogue = new Catalogue();

        System.out.println("------CREATION DES PRODUITS -------");

        Produit p1 = new ProduitElectronique("PROD1", "iPhone", 4000, 2);
        Produit p2 = new ProduitElectronique("PROD2", "MacBook", 2000, 1);
        Produit p3 = new ProduitElectronique("PROD3", "Apple Watch", 1500, 3);
        Produit p4 = new ProduitElectronique("PROD4", "Tablette", 600, 2);
        Produit p5 = new ProduitElectronique("PROD5", "Appareil Photo", 1500, 4);
        Produit p6 = new ProduitElectronique("PROD6", "Clavier", 150, 1);

        Produit p7 = new ProduitAlimentaire("PROD7", "Lait Delice", 1.5, "2026-05-26");
        Produit p8 = new ProduitAlimentaire("PROD8", "Chocolat", 5, "2026-06-22");
        Produit p9 = new ProduitAlimentaire("PROD9", "Jus de fruit", 25, "2026-12-12");
        Produit p10 = new ProduitAlimentaire("PROD10", "Creme Fraiche", 15, "2027-01-10");
        Produit p11 = new ProduitAlimentaire("PROD11", "Fromage", 18, "2027-08-25");
        Produit p12 = new ProduitAlimentaire("PROD12", "Yaourt", 12, "2027-03-05");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
        System.out.println(p6);
        System.out.println(p7);
        System.out.println(p8);
        System.out.println(p9);
        System.out.println(p10);
        System.out.println(p11);
        System.out.println(p12);



        System.out.println("\n  ---- CREATION DES CLIENTS -----");

        Client c1 = new Client(1, "Samaila Maika Hayate");
        Client c2 = new Client(2, "Samaila Maika Khairath");
        Client c3 = new Client(3, "Samaila Maika Ahmed");

          //commande client1
        Commande cmd1 = new CommandeExpress(1);
        cmd1.ajouterProduit(p1);
        cmd1.ajouterProduit(p7);
        cmd1.ajouterProduit(p9);



    // commande client2
        Commande cmd2 = new CommandeNormale(2);
        cmd2.ajouterProduit(p2);


        //commande client3

        Commande cmd3 = new CommandeNormale(3);
        cmd3.ajouterProduit(p6);
        cmd3.ajouterProduit(p4);


      //liste des commandes

        c1.ajouterCommande(cmd1);
        c2.ajouterCommande(cmd2);
        c3.ajouterCommande(cmd3);



   // affichage des commandes C1

        System.out.println("\n--- CLIENT : " + c1 + " ---");
        System.out.println("Type de commande: EXPRESS");
        System.out.println("Nombre de produits : 3");

        System.out.println("-" + p1.getNom() + " : " + p1.calculerPrixFinal() + " DT");
        System.out.println("- " + p7.getNom() + " : " + p7.calculerPrixFinal() + " DT");
        System.out.println("- " + p9.getNom() + " : " + p9.calculerPrixFinal() + " DT");


        System.out.println("PRIX FINAL : " + cmd1.calculerTotal() + " DT");

    //CLIENT 2

        System.out.println("\n--- CLIENT  : " + c2 + " ---");
        System.out.println("Type : Express");
        System.out.println("Nombre de produits : 1");
        System.out.println("- " + p2.getNom() + " : " + p2.calculerPrixFinal() + " DT");
        System.out.println("PRIX FINAL : " + cmd2.calculerTotal() + " DT");


        // CLIENT 3
        System.out.println("\n--- CLIENT 3 : " + c3 + " ---");
        System.out.println("Type de commande  : EXPRESS");
        System.out.println("Nombre de produits : 2");

        System.out.println("- " + p6.getNom() + " : " + p6.calculerPrixFinal() + " DT");
        System.out.println("- " + p4.getNom() + " : " + p4.calculerPrixFinal() + " DT");
        System.out.println("PRIX FINAL : " + cmd3.calculerTotal() + " DT");



        System.out.println("\n AJOUT PRODUITS  ");

        catalogue.ajouterProduit(p1);
        catalogue.ajouterProduit(p2);
        catalogue.ajouterProduit(p3);
        catalogue.ajouterProduit(p4);
        catalogue.ajouterProduit(p5);
        catalogue.ajouterProduit(p6);
        catalogue.ajouterProduit(p7);
        catalogue.ajouterProduit(p8);
        catalogue.ajouterProduit(p9);
        catalogue.ajouterProduit(p10);
        catalogue.ajouterProduit(p11);
        catalogue.ajouterProduit(p12);

        catalogue.afficher();






        // TRI

        System.out.println("\n-----TRI PAR PRIX -----");
        catalogue.trierParPrix();
        catalogue.afficher();

        System.out.println("\n----- TRI PAR NOM-----");
        catalogue.trierParNom();
        catalogue.afficher();


        // RECHERCHE

        System.out.println("\n----- RECHERCHE -----");

        System.out.println("PROD1 → " + catalogue.rechercherParReference("PROD1"));
        System.out.println("PROD10 → " + catalogue.rechercherParReference("PROD10"));
        System.out.println("PROD8 → " + catalogue.rechercherParReference("PROD8"));
        System.out.println("PROD99 → " + catalogue.rechercherParReference("PROD99"));


        // SUPPRESSION SIMPLE

        System.out.println("\n----- SUPPRESSION PRODUIT ----");

        catalogue.supprimerProduit("PROD5");
        catalogue.supprimerProduit("PROD12");
        catalogue.afficher();


        // CATEGORIE

        System.out.println("\n------- CATEGORIE -----");

        catalogue.afficherParCategorie();


        // STATISTIQUES

        System.out.println("\n----- STATISTIQUES ------");

        System.out.println("Nombre de produits : " + catalogue.nombreProduits());
        System.out.println("Produit le plus cher : " + catalogue.produitLePlusCher());


        // MODIFICATION

        System.out.println("\n-----MODIFICATION------");

        System.out.println("Avant : " + catalogue.rechercherParReference("PROD3"));

        catalogue.modifierProduit("PROD3", 550);

        System.out.println("Après : " + catalogue.rechercherParReference("PROD3"));


        // SUPPRESSION CONDITIONNELLE

        System.out.println("\n---- SUPPRESSION (prix > 1000)----");

        catalogue.supprimerSiPrixSuperieur(1000);

        catalogue.afficher();

        // TEST DOUBLON

        System.out.println("\n ---- TEST DOUBLON ----");

        Catalogue testCatalogue = new Catalogue();

        testCatalogue.ajouterProduit(p5);
        testCatalogue.ajouterProduit(p5);
        testCatalogue.ajouterProduit(p8);
        testCatalogue.ajouterProduit(p8);
        testCatalogue.ajouterProduit(p12);
        testCatalogue.ajouterProduit(p10);

        testCatalogue.afficher();
    }
}
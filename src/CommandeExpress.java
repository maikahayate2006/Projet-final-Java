import java.util.*;

public class CommandeExpress extends Commande {

    private double fraisLivraison = 10;

    public CommandeExpress(int numeroCommande) {
        super(numeroCommande);
    }


    @Override
    public double calculerTotal() {

        double total = 0;

        for (Produit p : listeProduits) {
            total += p.calculerPrixFinal();
        }

        return total + fraisLivraison;
    }


    public double getFraisLivraison() {
        return fraisLivraison;
    }

    @Override
    public String toString() {
        return "Commande Express | Numero: " + numeroCommande +
                " | Frais livraison: " + fraisLivraison + " DT";
    }
}
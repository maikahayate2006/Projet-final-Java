public class ProduitElectronique extends Produit {

    private int garantie;

    public ProduitElectronique(String reference, String nom, double prix, int garantie) {
        super(reference, nom, prix);
        this.garantie = garantie;
    }

    @Override
    public double calculerPrixFinal() {
        return getPrix() + (getPrix() * 0.2);
    }

    @Override
    public String toString() {
        return getReference() + " - " + getNom() + " - " + getPrix()
                + " --- Garantie: " + garantie + " ans"
                + " --- Prix final: " + calculerPrixFinal() + " DT";
    }
}
import java.util.ArrayList;
import java.util.List;

public class Client {

    private int id;
    private String nom;
    private List<Commande> listeCommandes;

    public Client(int id, String nom) {
        this.id = id;
        this.nom = nom;
        listeCommandes = new ArrayList<>();
    }

    public void ajouterCommande(Commande c) {

        listeCommandes.add(c);
    }

    @Override
    public String toString() {
        return id + " - " + nom;
    }
}
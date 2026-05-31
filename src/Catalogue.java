import java.util.*;

public class Catalogue {

    // LIST : catalogue principal
    private List<Produit> produits = new ArrayList<>();

    // SET : éviter les doublons
    private Set<String> references = new HashSet<>();

    // MAP : accès rapide par référence
    private Map<String, Produit> index = new HashMap<>();

    // MAP : groupement par catégorie
    private Map<String, List<Produit>> categories = new HashMap<>();


    // AJOUT PRODUIT

    public void ajouterProduit(Produit p) {

        if (references.contains(p.getReference())) {
            System.out.println("DOUBLON ignoré : " + p.getReference());
            return;
        }

        produits.add(p);
        references.add(p.getReference());
        index.put(p.getReference(), p);

        String cat = p.getClass().getSimpleName();
        categories.computeIfAbsent(cat, k -> new ArrayList<>()).add(p);

        System.out.println("Produit ajouté : " + p.getNom());
    }


    // MODIFIER PRODUIT

    public void modifierProduit(String ref, double nouveauPrix) {

        Produit p = index.get(ref);

        if (p != null) {
            p.setPrix(nouveauPrix);
            System.out.println("Produit modifié : " + p.getNom());
        } else {
            System.out.println("Produit introuvable : " + ref);
        }
    }


    // SUPPRIMER PRODUIT

    public void supprimerProduit(String ref) {

        Produit p = index.get(ref);

        if (p != null) {

            produits.remove(p);
            references.remove(ref);
            index.remove(ref);

            String cat = p.getClass().getSimpleName();
            List<Produit> list = categories.get(cat);

            if (list != null) {
                list.remove(p);
                if (list.isEmpty()) {
                    categories.remove(cat);
                }
            }

            System.out.println("Produit supprimé : " + p.getNom());

        } else {
            System.out.println("Produit introuvable : " + ref);
        }
    }


    // SUPPRESSION CONDITIONNELLE

    public void supprimerSiPrixSuperieur(double seuil) {

        Iterator<Produit> it = produits.iterator();

        while (it.hasNext()) {
            Produit p = it.next();

            if (p.getPrix() > seuil) {
                it.remove();

                references.remove(p.getReference());
                index.remove(p.getReference());

                String cat = p.getClass().getSimpleName();
                List<Produit> list = categories.get(cat);

                if (list != null) {
                    list.remove(p);
                    if (list.isEmpty()) {
                        categories.remove(cat);
                    }
                }

                System.out.println("Supprimé : " + p.getNom());
            }
        }
    }


    // PARCOURIR LISTE

    public void afficher() {

        System.out.println("\n-----CATALOGUE (" + produits.size() + " produits) ----");

        for (Produit p : produits) {
            System.out.println(p);
        }
    }


    // TRI

    public void trierParPrix() {
        produits.sort(Comparator.comparingDouble(Produit::getPrix));
        System.out.println("Catalogue trié par prix.");
    }

    public void trierParNom() {
        produits.sort(Comparator.comparing(Produit::getNom));
        System.out.println("Catalogue trié par nom.");
    }


    // RECHERCHE (MAP)

    public Produit rechercherParReference(String ref) {
        return index.get(ref);
    }


    // GROUPEMENT PAR CATÉGORIE

    public void afficherParCategorie() {

        System.out.println("\n---- PRODUITS PAR CATEGORIE -----");

        for (Map.Entry<String, List<Produit>> entry : categories.entrySet()) {

            System.out.println("-- " + entry.getKey() + " --");

            for (Produit p : entry.getValue()) {
                System.out.println(p);
            }
        }
    }


    // STATISTIQUES


    public int nombreProduits() {
        return produits.size();
    }

    public Produit produitLePlusCher() {
        return produits.stream()
                .max(Comparator.comparingDouble(Produit::getPrix))
                .orElse(null);
    }


    public List<Produit> getProduits() {
        return produits;
    }
}
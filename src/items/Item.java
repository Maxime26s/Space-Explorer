package items;

import vaisseau.Vaisseau;

public abstract class Item {
    private String nom;

    public abstract void use(Vaisseau vaisseau);

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

package planetes;

import items.Item;
import main.Main;
import vaisseau.Vaisseau;

public abstract class Planete {
    private String nom;
    private int cout;
    private int chancePirate;
    private Item[] listeItem;

    public void explorer(Vaisseau vaisseau) {
        vaisseau.getListePlaneteVisite().push(this);
        System.out.println("\n"+"Vous explorez la planète "+nom+".");
        vaisseau.setCarburant(vaisseau.getCarburant()-cout);
        System.out.println("Vous dépensez "+cout+" litres d'essence");
        if (vaisseau.getCarburant()<=0)
            vide();
        int rng=(int)(Math.random()*5+1);
        if (rng<=chancePirate)
            pirates(vaisseau);
        int rng2=(int)(Math.random()*listeItem.length);
        vaisseau.getInventaire().add(listeItem[rng2]);
        System.out.println("Vous obtenez : "+listeItem[rng2].getNom());
    }

    public void pirates(Vaisseau vaisseau){
        vaisseau.setPv(vaisseau.getPv()-25);
        System.out.println("Des pirates de l’espace vous attaquent !\n" +
                "Votre vaisseau perd "+25+" points de vie !\n");
        if (vaisseau.getPv()<=0){
            System.out.println("Vous n'avez plus de points de vie.\n"+
                    "Fin de la partie");
            Main.end();
        }
    }

    public void vide(){
        System.out.println("\n"+
                "Votre vaisseau manque d’essence.\n"+
                "Fin de la partie");
        Main.end();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCout() {
        return cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public int getChancePirate() {
        return chancePirate;
    }

    public void setChancePirate(int chancePirate) {
        this.chancePirate = chancePirate;
    }

    public Item[] getListeItem() {
        return listeItem;
    }

    public void setListeItem(Item[] listeItem) {
        this.listeItem = listeItem;
    }
}

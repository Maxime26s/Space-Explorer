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
        System.out.println("Vous explorez la planète "+nom+".");
        vaisseau.setCarburant(vaisseau.getCarburant()-cout);
        System.out.println("Vous dépensez "+cout+" litres d'essence");
        if (vaisseau.getCarburant()<=0)
            vide(vaisseau);
        int rng=(int)(Math.random()*5+1);
        if (rng<chancePirate)
            pirates(vaisseau);
        int rng2=(int)(Math.random()*listeItem.length);
        vaisseau.getInventaire().add(listeItem[rng2]);
        System.out.print("Vous obtenez : "+listeItem[rng2]);
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

    public void vide(Vaisseau vaisseau){
        System.out.println("Votre vaisseau manque d’essence.\n"+
                "Fin de la partie");
        Main.end();
    }
}

package vaisseau;

import items.Item;
import main.Main;
import planetes.Planete;

import java.util.ArrayList;
import java.util.Stack;

public class Vaisseau {
    Stack<Planete> listePlaneteVisite;
    int carburant;
    int pv;
    ArrayList<Item> inventaire;
    Vaisseau vaisseauPast;

    public Vaisseau() {
        Stack<Planete> planete=new Stack<>();
        int carburant=1000;
        int pv=100;
        ArrayList<Item> inventaire = new ArrayList<>();
        Vaisseau vaisseauPast;
    }

    public Vaisseau(Stack<Planete> listePlaneteVisite, int carburant, int pv, ArrayList<Item> inventaire, Vaisseau vaisseauPast) {
        this.listePlaneteVisite = listePlaneteVisite;
        this.carburant = carburant;
        this.pv = pv;
        this.inventaire = inventaire;
        this.vaisseauPast = vaisseauPast;
    }

    public void etat(){
        System.out.print("État du vaisseau :\n" +
                "    Planète courante : "+ listePlaneteVisite +"\n" +
                "    Quantité carburant : "+carburant+"\n" +" litres\n" +
                "    Points de vie : "+pv+"\n" +
                "    Inventaire : \n");
        for(int i=0;i<inventaire.size();i++) {
            System.out.println(" "+i+1+"- " + inventaire.get(i));
        }
    }

    public void choixItem(){
        System.out.println("Quel objet voulez-vous utiliser ?");
        for(int i=0;i<inventaire.size();i++)
            System.out.println(" "+i+1+"- "+inventaire.get(i).getNom());
        System.out.print("Votre choix : ");
        inventaire.get(Main.testInt()-1).use();
    }

    public Stack<Planete> getListePlaneteVisite() {
        return listePlaneteVisite;
    }

    public void setListePlaneteVisite(Stack<Planete> listePlaneteVisite) {
        this.listePlaneteVisite = listePlaneteVisite;
    }

    public int getCarburant() {
        return carburant;
    }

    public void setCarburant(int carburant) {
        this.carburant = carburant;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public ArrayList<Item> getInventaire() {
        return inventaire;
    }

    public void setInventaire(ArrayList<Item> inventaire) {
        this.inventaire = inventaire;
    }

    public Vaisseau getVaisseauPast() {
        return vaisseauPast;
    }

    public void setVaisseauPast(Vaisseau vaisseauPast) {
        this.vaisseauPast = vaisseauPast;
    }
}

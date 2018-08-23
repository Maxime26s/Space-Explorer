package vaisseau;

import items.Item;
import planetes.Planete;

import java.util.ArrayList;
import java.util.Stack;

public class Vaisseau {
    Stack<Planete> planete;
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

    public Vaisseau(Stack<Planete> planete, int carburant, int pv, ArrayList<Item> inventaire, Vaisseau vaisseauPast) {
        this.planete = planete;
        this.carburant = carburant;
        this.pv = pv;
        this.inventaire = inventaire;
        this.vaisseauPast = vaisseauPast;
    }

    public void etat(){
        System.out.print("État du vaisseau :\n" +
                "    Planète courante : "+planete+"\n" +
                "    Quantité carburant : "+carburant+"\n" +" litres\n" +
                "    Points de vie : "+pv+"\n" +
                "    Inventaire : \n");
        for(int i=0;i<inventaire.size();i++) {
            System.out.println(" "+i+1+"- " + inventaire.get(i));
        }
    }

    public Stack<Planete> getPlanete() {
        return planete;
    }

    public void setPlanete(Stack<Planete> planete) {
        this.planete = planete;
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

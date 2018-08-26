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
        this.listePlaneteVisite=new Stack<>();
        this.carburant=1000;
        this.pv=100;
        this.inventaire = new ArrayList<>();
    }

    public Vaisseau(Stack<Planete> listePlaneteVisite, int carburant, int pv, ArrayList<Item> inventaire, Vaisseau vaisseauPast) {
        this.listePlaneteVisite=new Stack<>();
        ArrayList<Planete> tempList = new ArrayList<>();
        int tempSize = listePlaneteVisite.size();
        for(int i=0;i<tempSize;i++)
                tempList.add(listePlaneteVisite.pop());
        for(int i=tempSize-1;i>=0;i--) {
            this.listePlaneteVisite.push(tempList.get(i));
            listePlaneteVisite.push(tempList.get(i));
        }
        this.inventaire = new ArrayList<>();
        tempSize=inventaire.size();
        for(int i=0;i<tempSize;i++)
            this.inventaire.add(inventaire.get(i));
        this.carburant = carburant;
        this.pv = pv;
        this.vaisseauPast = vaisseauPast;
    }

    public void etat(){
        System.out.print("\n"+
                "État du vaisseau :\n" +
                "    Planète courante : "+ listePlaneteVisite.peek().getNom() +"\n" +
                "    Quantité carburant : "+carburant+" litres\n" +
                "    Points de vie : "+pv+"\n" +
                "    Inventaire : \n");
        for(int i=0;i<inventaire.size();i++) {
            System.out.println("     "+(i+1)+"- " + inventaire.get(i).getNom());
        }
    }

    public void choixItem(){
        System.out.println("\n"+
                "Quel objet voulez-vous utiliser ?");
        for(int i=0;i<inventaire.size();i++)
            System.out.println(" "+(i+1)+"- "+inventaire.get(i).getNom());
        System.out.print("Votre choix : ");
        int choixInt=Main.testInt()-1;
        try {
            inventaire.get(choixInt).use(this);
            inventaire.remove(choixInt);
        }catch (Exception e) {
            System.out.println("Il n'y a pas d'objet à cette emplacement");
        }
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

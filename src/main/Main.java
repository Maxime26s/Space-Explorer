package main;

import planetes.*;
import vaisseau.Vaisseau;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static Scanner sc=new Scanner(System.in);
    public static Vaisseau vaisseau=new Vaisseau();
    public static Planete[] listePlanetes=new Planete[5];
    public static void main(String[] args) {
        start();
        System.out.println("Bievenue dans Space Explorer !");
        while(true)
        choixSwitch(listeChoix());
    }

    public static int listeChoix(){
        System.out.print("Que désirez-vous faire ?\n" +
                " 1- Examiner le vaisseau\n" +
                " 2- Explorer une planète\n" +
                " 3- Utiliser un objet dans l'inventaire\n" +
                " 4- Revenir en arrière\n" +
                "Votre choix : ");
        return testInt();
    }

    public static void choixSwitch(int choixInt){
        switch(choixInt){
            case 1:
                vaisseau.etat();
                break;
            case 2:
                explorer();
                break;
            case 3:
                vaisseau.choixItem();
                break;
            case 4:
                if(vaisseau.getVaisseauPast()!=null)
                    vaisseau=vaisseau.getVaisseauPast();
                else
                    System.out.println("Vous ne pouvez pas retourner en arrière.");
                break;
            default:
                System.out.println("Veuillez entrez un nombre entre 1 et 4");
                break;
        }
    }

    public static void explorer(){
        vaisseau.setVaisseauPast(new Vaisseau(vaisseau.getListePlaneteVisite(), vaisseau.getCarburant(), vaisseau.getPv(), vaisseau.getInventaire(), vaisseau.getVaisseauPast()));
        listePlanetes[(int)(Math.random()*5+1)].explorer(vaisseau);
    }

    public static void start(){
        listePlanetes[0]=new Venus();
        listePlanetes[1]=new Mars();
        listePlanetes[2]=new Mercure();
        listePlanetes[3]=new Jupiter();
        listePlanetes[4]=new Saturne();
        System.out.println("Bievenue dans Space Explorer !");
    }

    public static void end(){
        System.out.println("Trajet parcouru :");
        Stack<Planete> tempStack = new Stack<>();
        int tempsize = vaisseau.getListePlaneteVisite().size();
        for(int i=0;i<tempsize;i++){
            tempStack.push(vaisseau.getListePlaneteVisite().pop());
        }
        for(int i=0;i<tempsize;i++){
            System.out.println(tempStack.pop()+" -> ");
            if (i==tempsize)
                System.out.println(tempStack.pop());
        }
    }

    public static int testInt(){
        try{
            String stringTemp=sc.nextLine();
            int intTemp=Integer.parseInt(stringTemp);
            return intTemp;
        } catch(Exception e){
            System.out.println("ERREUR: Entrez un nombre valide");
            return testInt();
        }
    }

}

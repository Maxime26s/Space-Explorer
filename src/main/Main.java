package main;

import planetes.Planete;
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
                break;
            case 4:
                vaisseau=vaisseau.getVaisseauPast();
                break;
            default:
                break;
        }
    }

    public static void explorer(){
        vaisseau.setVaisseauPast(new Vaisseau(vaisseau.getPlanete(), vaisseau.getCarburant(), vaisseau.getPv(), vaisseau.getInventaire(), vaisseau.getVaisseauPast()));
        listePlanetes[(int)(Math.random()*5+1)].explorer(vaisseau);
    }

    public static void start(){
        System.out.println("Bievenue dans Space Explorer !");
    }

    public static void end(){
        System.out.println("Trajet parcouru :");
        Stack<Planete> tempStack = new Stack<>();
        int tempsize = vaisseau.getPlanete().size();
        for(int i=0;i<tempsize;i++){
            tempStack.push(vaisseau.getPlanete().pop());
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

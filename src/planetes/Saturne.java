package planetes;

import items.*;

public class Saturne extends Planete{
    public Saturne(){
        setNom("Saturne");
        setCout(400);
        setChancePirate(0);
        setListeItem(new Item[3]);
        getListeItem()[0]=new GrosGaz();
        getListeItem()[1]=new PetitGaz();
        getListeItem()[2]=new PetitKit();
    }
}

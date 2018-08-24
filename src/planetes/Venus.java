package planetes;

import items.*;

public class Venus extends Planete{
    public Venus(){
        setNom("Vénus");
        setCout(100);
        setChancePirate(3);
        getListeItem()[0]=new GrosKit();
        getListeItem()[1]=new PetitGaz();
        getListeItem()[2]=new MoyenKit();
    }
}

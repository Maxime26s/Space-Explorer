package planetes;

import items.*;

public class Mars extends Planete{
    public Mars(){
        setNom("Mars");
        setCout(200);
        setChancePirate(2);
        getListeItem()[0]=new MoyenGaz();
        getListeItem()[1]=new MoyenKit();
        getListeItem()[2]=new PetitKit();
    }
}

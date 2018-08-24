package planetes;

import items.*;

public class Jupiter extends Planete{
    public Jupiter(){
        setNom("Jupiter");
        setCout(300);
        setChancePirate(1);
        getListeItem()[0]=new MoyenGaz();
        getListeItem()[1]=new PetitGaz();
        getListeItem()[2]=new PetitKit();
    }
}

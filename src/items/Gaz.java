package items;

import vaisseau.Vaisseau;

public abstract class Gaz extends Item{
    private int refill;

    public void use(Vaisseau vaisseau) {
        System.out.println("Vous ajoutez "+refill+" litres au réservoir du vaisseau.");
        vaisseau.setCarburant(vaisseau.getCarburant()+refill);
    }

    public int getRefill() {
        return refill;
    }

    public void setRefill(int refill) {
        this.refill = refill;
    }
}

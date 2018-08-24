package items;

import vaisseau.Vaisseau;

public abstract class Kit extends Item{
    private int heal;

    public void use(Vaisseau vaisseau) {
        System.out.println("Vous augmentez les points de vie du vaisseau de "+heal+".");
        vaisseau.setPv(vaisseau.getPv()+heal);
    }

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }
}

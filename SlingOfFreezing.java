import java.util.ArrayList;

public class SlingOfFreezing extends Sling {
    private double maxDimensions = 10.0;
   //TODO: override specified methods with default values

    @Override
    public double getHitBonus() {
        return 0.2;
    }

    @Override
    public int getDamage() {
        return 25;
    }

    @Override
    public boolean attack(Entity entityToAttack, double distanceInMeters) {
        //TODO: check if contents in sling, if so remove object in contents
        //, set not full, call parent method

        if (this.isEmpty()) {
            return false;
        }

        getContainedItems().remove(0);
        boolean isHit = entityToAttack.receiveAttack(this, distanceInMeters);
        return isHit;
    }

    @Override
    public double getMaxDimension() {
        return this.maxDimensions;
    }

    @Override
    public boolean addItem(Entity entity) {
        if (this.isEmpty()) {
            for (double dim : entity.getDimensions()) {
                if (dim > getMaxDimension()) {
                    return false;
                }
            }
            ArrayList<Entity> itemList = getContainedItems();
            itemList.add(0, entity);
            setContianedItems(itemList);
            return true;
        }
        return false;
    }

    @Override
    public String getName() {
        return "sling of freezing";
    }

    public static void main(String args[]) {
        Sling normalSling = new Sling();
        SlingOfFreezing magicSling = new SlingOfFreezing();

        Stone largeStone = new Stone(10,10,5);
        largeStone.setName("large stone");
        Stone smallerStone = new Stone(3,3,3);
        smallerStone.setName("smaller stone");
        Stone smallerStone2 = new Stone(3,3,3);
        smallerStone2.setName("smaller stone");

        boolean canAddStone = normalSling.addItem(smallerStone);
        System.out.println("Normal Sling: " + canAddStone);
        canAddStone = magicSling.addItem(largeStone);
        System.out.println("Magic Sling: " + canAddStone);
        boolean canRemoveStone = normalSling.removeItem(smallerStone);
        System.out.println(canRemoveStone);

        System.out.println(magicSling.toString());
    }
}

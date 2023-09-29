import java.util.ArrayList;

public class Sling extends Weapon implements Container {
    private ArrayList<Entity> containedItems;
    private static double maxDimension = 5.0;

    public Sling() {
        setName("basic sling");
        containedItems = new ArrayList<>();
    }

    public double getMaxDimension() {
        return maxDimension;
    }

    public String getAddingMessage(Entity entity) {
        return "loads a " + entity.getName() + " into the " + this.getName();
    }

    public String getCannotAddMessage(Entity entity) {
        return "cannot fit a " + entity.getName() + " into the " + this.getName();
    }

    public String getWithdrawingMessage(Entity entity) {
        return "takes a " + entity.getName() + " from the " + this.getName();
    }

    public boolean isEmpty() {
        if (containedItems.size() == 0) {
            return true;
        }
        return false;
    }

    public ArrayList<Entity> getContainedItems() {
        return containedItems;
    }

    public void setContianedItems(ArrayList<Entity> containedItems) {
        this.containedItems = containedItems;
    }

    @Override
    public int getDamage() {
        return 15;
    }

    @Override
    public double getHitBonus() {
        return 0;
    }

    @Override
    public String getHitMessage(Entity entity) {
        return "Twirling the " + this.getName() + " in a vicious arc, the ammo is released from the " + this.getName() + " with deadly force";
    }

    @Override
    public String getMissMessage(Entity entity) {
        return "The " + this.getName() + " swings wildly, and the ammo careens off into the shadows";
    }

    @Override
    public boolean removeItem(Entity entity) {
        if (this.isEmpty()) {
            return false;
        }
        getContainedItems().remove(0);
        return true;
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


	//TODO: Implement abstract methods

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

    //TODO: override ToString to contain parent ToString() plus contents of the sling
    @Override
    public String toString() {
        int i = 0;
        String outputString = "A ";
        if (this.isDestroyed()) {
            outputString += "(broken) ";
        }
        outputString += this.getName() + "\n";
        outputString += this.getDescription() + "\n";
        outputString += "It has " + this.getHealth() + " health left.\n\n";

        outputString += "The " + this.getName() + " contains:\n";
        outputString += "    A " + containedItems.get(i).getName() + "\n";
        return outputString;
    }
}


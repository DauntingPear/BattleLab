import java.util.Scanner;

public class Battle {
    public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      battle(scan.nextInt());
      
      //  System.out.println("\nBattle: " + 100234);
      //  battle(100234); //miss, miss, alive
      //  System.out.println("Battle: " + 10);
      //  battle(10); // miss, hit, alive
      //  System.out.println("Battle: " + 32131);
      //  battle(32131); //hit, hit, dead
      //  System.out.println("Battle: " + 24771232);
      //  battle(24771232); //hit, hit, alive
    }

    public static void battle(int seed) {
        StringBuilder outputText = new StringBuilder();

        Sling normalSling = new Sling();
        SlingOfFreezing magicSling = new SlingOfFreezing();

        Stone largeStone = new Stone(10,10,5);
        largeStone.setName("large stone");
        Stone smallerStone = new Stone(3,3,3);
        smallerStone.setName("smaller stone");
        Stone smallerStone2 = new Stone(3,3,3);
        smallerStone2.setName("smaller stone");

        Dragon dragon = new Dragon();
        dragon.setHealth(17);
        dragon.setSeed(seed);

        outputText.append("------------------------------------------------------------\n");

        outputText.append("Grimwink the vampire warrior stands before the " + dragon.getName() + ", ");
        outputText.append("twin slings at the ready.\n\nShe picks up a " + largeStone.getName() + " and ");

        boolean canAddStone = normalSling.addItem(largeStone);
        if(canAddStone) outputText.append(normalSling.getAddingMessage(largeStone));
        else outputText.append(normalSling.getCannotAddMessage(largeStone));

        outputText.append(".\nThen she picks up a " + smallerStone.getName() + " and ");

        canAddStone = normalSling.addItem(smallerStone);
        if(canAddStone) outputText.append(normalSling.getAddingMessage(smallerStone));
        else outputText.append(normalSling.getCannotAddMessage(smallerStone));

        outputText.append(".\n\nLastly, she picks up a " + smallerStone2.getName() + " and ");

        canAddStone = magicSling.addItem(smallerStone2);
        if(canAddStone) outputText.append(magicSling.getAddingMessage(smallerStone2));
        else outputText.append(magicSling.getCannotAddMessage(smallerStone2));

        outputText.append(".\n\nGrimwink attacks with her " + normalSling.getName() + "!\n");

        if(!normalSling.isEmpty()) {
            boolean isHit = normalSling.attack(dragon, 10.4);

            if(isHit) {
                outputText.append(normalSling.getHitMessage(dragon) + ".\n");
                dragonStatusReport(dragon, outputText);
            }
            else outputText.append(normalSling.getMissMessage(dragon) + ".\n");


        }

        if(!dragon.isDestroyed() && !magicSling.isEmpty()) {
            outputText.append("\nGrimwink jumps 5 meters closer and attacks with her other weapon, the " +
                    magicSling.getName() + "!\n");
            boolean isHit = magicSling.attack(dragon, 5.4);

            if(isHit) {
                outputText.append(magicSling.getHitMessage(dragon) + ".\n");
                dragonStatusReport(dragon, outputText);
            }
            else outputText.append(magicSling.getMissMessage(dragon) + ".\n");
        }

        outputText.append("------------------------------------------------------------\n");

        System.out.println(outputText);
    }

    private static void dragonStatusReport(Dragon dragon, StringBuilder outputText) {
        if(dragon.isDestroyed()) outputText.append("The " + dragon.getName() + " gasps one final breath before " +
                "falling loudly to the ground!\n\n");
        else outputText.append("The " + dragon.getName() + " is hurt, but has not succumbed to its wounds.\n\n");

        outputText.append(dragon);
    }
}


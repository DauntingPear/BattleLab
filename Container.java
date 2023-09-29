import java.util.ArrayList;

public interface Container {
    boolean removeItem(Entity entity);
    boolean addItem(Entity entity);
    String getAddingMessage(Entity entity);
    String getCannotAddMessage(Entity entity);
    boolean isEmpty();
    String getWithdrawingMessage(Entity entity);
    ArrayList<Entity> getContainedItems();
}

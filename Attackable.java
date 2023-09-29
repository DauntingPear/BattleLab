public interface Attackable {
    boolean isHit(Entity entityAttacking);
    boolean isHit(Entity entityAttacking, double distanceInMeters);
    boolean receiveAttack(Entity entityAttacking);
    boolean receiveAttack(Entity entityAttacking, double distanceInMeters);
}

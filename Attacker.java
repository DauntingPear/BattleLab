public interface Attacker {
    int getDamage();
    double getHitBonus();
    boolean attack(Entity entityToAttack, double distanceInMeters);
    String getHitMessage(Entity entityHit);
    String getMissMessage(Entity entityMissed);
}

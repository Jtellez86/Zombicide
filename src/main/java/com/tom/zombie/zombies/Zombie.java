package com.tom.zombie.zombies;


public interface Zombie {

    boolean isAlive();
    String getType();
    public void takeDamage(Integer damageFromRoll);
}

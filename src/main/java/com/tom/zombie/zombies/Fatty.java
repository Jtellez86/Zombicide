package com.tom.zombie.zombies;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Fatty implements Zombie {

    String type = "Fatty";
    boolean isAlive = true;
    public static final int HEALTH = 2;

    @Override
    public void takeDamage(Integer damageFromRoll) {
        if(damageFromRoll >= HEALTH) {
            isAlive = false;
            System.out.println("Killed " + this);
        }
    }
}

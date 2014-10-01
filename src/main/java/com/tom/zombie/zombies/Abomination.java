package com.tom.zombie.zombies;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Abomination implements Zombie {

    final String type = "Abomination";
    boolean isAlive = true;
    Integer HEALTH = 3;

    @Override
    public void takeDamage(Integer damageFromRoll) {
        if(damageFromRoll >= HEALTH) {
            isAlive = false;
            System.out.println("Killed " + this);
        }
    }
}

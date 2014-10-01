package com.tom.zombie.zombies;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Runner implements Zombie {

    final String type = "Runner";
    boolean isAlive = true;
    Integer HEALTH = 1;

    @Override
    public void takeDamage(Integer damageFromRoll) {
        if(damageFromRoll >= HEALTH) {
            isAlive = false;
            System.out.println("Killed " + this);
        }
    }
}

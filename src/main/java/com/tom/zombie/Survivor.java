package com.tom.zombie;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class Survivor {

    boolean isAlive = true;
    int hitPoints = 2;
    final String weaponName;

    public void attack(Zombie zombieBeingHit, int damageToZombie) {
        System.out.println("Attacking " + zombieBeingHit + " with damage of " + damageToZombie);

        switch (zombieBeingHit.getType()) {
            case "Walker" :
            case "Runner" :
                zombieBeingHit.killed();
                return;

            case "Fatty":
                if (damageToZombie >= 2) {
                    zombieBeingHit.killed();
                }
                return;

            case "Abomination":
                if (damageToZombie >= 3) {
                    zombieBeingHit.killed();
                }
                return;
        }
        throw new AssertionError("Unknown Zombie type " + zombieBeingHit.getType());
    }
}

package com.tom.zombie;

import com.tom.zombie.weapons.Weapon;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class Survivor {

    boolean isAlive = true;
    int hitPoints = 2;

    final Weapon playerWeapon;

    public void attack(Zombie zombieBeingHit) {
        System.out.println("Attacking " + zombieBeingHit + " with damage of " + playerWeapon.getDamage());

        switch (zombieBeingHit.getType()) {
            case "Walker" :
            case "Runner" :
                zombieBeingHit.killed();
                return;

            case "Fatty":
                if (playerWeapon.getDamage() >= 2) {
                    zombieBeingHit.killed();
                }
                return;

            case "Abomination":
                if (playerWeapon.getDamage() >= 3) {
                    zombieBeingHit.killed();
                }
                return;
        }
        throw new AssertionError("Unknown Zombie type " + zombieBeingHit.getType());
    }
}

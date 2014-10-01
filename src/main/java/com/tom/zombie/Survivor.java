package com.tom.zombie;

import com.tom.zombie.weapons.Weapon;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@RequiredArgsConstructor
public class Survivor {

    boolean isAlive = true;
    int hitPoints = 2;

    final Weapon playerWeapon;

    public void launchAttack(Zone zone) {

        List<Integer> damageFromWeapon = this.getPlayerWeapon().determineDamageFromWeapon();
        System.out.println("\n" + this.getPlayerWeapon().getWeaponName() + " launchAttack damage " + damageFromWeapon);

        damageFromWeapon.stream().forEach(damageFromRoll -> attackZombies(damageFromRoll, zone));
    }

    private void attackZombies(Integer damageFromRoll, Zone zone) {
        zone.getZombies().stream()
                .filter(Zombie::isAlive)
                .findFirst()
                .ifPresent(zombie -> attack(damageFromRoll ,zombie));
    }

    public void attack(Integer damageFromRoll, Zombie zombieBeingHit) {
        System.out.println("Attacking " + zombieBeingHit + " with damage of " + damageFromRoll);

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

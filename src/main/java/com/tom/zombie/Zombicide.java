package com.tom.zombie;

import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

public class Zombicide {

    @Setter
    Zone zone;

    Dice dice = new Dice();

    public void meleeCombat() {

        zone.getSurvivors().stream()
            .filter(Survivor::isAlive)
            .forEach(this::launchAttack);

        // Next the Zombies Attack
    }

    protected void launchAttack(Survivor survivor) {

        List<Integer> attackDamage = survivor.getPlayerWeapon().determineDamageFromWeapon();

        System.out.println("\n" + survivor.getPlayerWeapon().getWeaponName() + " launchAttack damage " + attackDamage);

        attackDamage.stream()
                    .forEach(this::attackZombies);

    }


    //how will the Survivor know about the zone they are in?
    protected void attackZombies(Integer attackDamage) {
         zone.getZombies()
             .stream()
             .filter(Zombie::isAlive)
             .findFirst()
             .ifPresent(aliveZombie -> attack(aliveZombie, attackDamage));
    }

    protected void attack(Zombie aliveZombie, Integer attackDamage) {
        System.out.println("Attacking " + aliveZombie + " with damage of " + attackDamage);

        switch (aliveZombie.getType()) {
            case "Walker" :
            case "Runner" :
                aliveZombie.killed();
                return;

            case "Fatty":
                if (attackDamage >= 2) {
                    aliveZombie.killed();
                }
                return;

            case "Abomination":
                if (attackDamage >= 3) {
                    aliveZombie.killed();
                }
                return;
        }
        throw new AssertionError("Unknown Zombie type " + aliveZombie.getType());
    }
}

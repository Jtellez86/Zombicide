package com.tom.zombie;

import lombok.Setter;

import java.util.List;

public class Zombicide {

    @Setter
    Zone zone;

    public void meleeCombat() {

        List<Survivor> zoneSurvivors = zone.getSurvivors();
        zoneSurvivors.stream()
                     .filter(Survivor::isAlive)
                     .forEach(survivor -> survivor.launchAttack(zone));

        // Next the Zombies Attack
    }
}

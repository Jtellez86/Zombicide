package com.tom.zombie.util;

import com.tom.zombie.Dice;

import java.util.List;
import java.util.stream.Collectors;

public class WeaponDamageCalculator {

    Dice dice = new Dice();

    public List<Integer> calculate(int diceRolled, int successfulRoll, int damage) {
        return dice.roll(diceRolled)
                .stream()
                .filter(roll -> roll >= successfulRoll)
                .map(goodRoll -> damage)
                .collect(Collectors.toList());
    }
}

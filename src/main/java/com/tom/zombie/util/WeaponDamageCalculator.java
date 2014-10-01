package com.tom.zombie.util;

import com.tom.zombie.Dice;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

public class WeaponDamageCalculator {

    @Setter
    Dice dice = new Dice();

    public List<Integer> calculateDamageFromRoll(int numberOfDice, int minScoreForDamage, int damageAmount) {
        return dice.roll(numberOfDice)
                .stream()
                .filter(roll -> roll >= minScoreForDamage)
                .map(goodRoll -> damageAmount)
                .collect(Collectors.toList());
    }
}

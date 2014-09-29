package com.tom.zombie.weapons;

import com.tom.zombie.Dice;
import com.tom.zombie.util.WeaponDamageCalculator;

import java.util.List;

public class Pan implements Weapon{


    public static final int DICE_ROLLED = 1;
    public static final int SUCCESSFUL_ROLL = 6;
    public static final int DAMAGE = 1;

    WeaponDamageCalculator calculator = new WeaponDamageCalculator();

    @Override
    public List<Integer> attemptAttack() {
        return calculator.calculate(DICE_ROLLED, SUCCESSFUL_ROLL, DAMAGE);
    }

}

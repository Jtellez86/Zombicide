package com.tom.zombie.weapons;

import com.tom.zombie.util.WeaponDamageCalculator;

import java.util.List;

public class ClawHammer implements Weapon {
    final String WEAPON_NAME = "Claw Hammer";

    public static final int DICE_ROLLED = 3;
    public static final int SUCCESSFUL_ROLL = 5;
    public static final int DAMAGE = 1;

    WeaponDamageCalculator calculator = new WeaponDamageCalculator();

    @Override
    public String getWeaponName() {
        return WEAPON_NAME;
    }

    @Override
    public int getDamage() {
        return DAMAGE;
    }

    @Override
    public List<Integer> determineDamageFromWeapon() {
        return calculator.calculate(DICE_ROLLED, SUCCESSFUL_ROLL, DAMAGE);
    }
}

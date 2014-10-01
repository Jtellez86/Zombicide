package com.tom.zombie.weapons;

import com.tom.zombie.util.WeaponDamageCalculator;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ClawHammer implements Weapon {

    @Getter
    @Setter
    public WeaponDamageCalculator calculator = new WeaponDamageCalculator();

    final String WEAPON_NAME = "Claw Hammer";
    public static final int DICE_ROLLED = 3;
    public static final int SUCCESSFUL_ROLL = 5;

    public static final int DAMAGE = 1;

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
        return calculator.calculateDamageFromRoll(DICE_ROLLED, SUCCESSFUL_ROLL, DAMAGE);
    }
}

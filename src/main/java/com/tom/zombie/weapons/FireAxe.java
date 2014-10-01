package com.tom.zombie.weapons;

import com.tom.zombie.util.WeaponDamageCalculator;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class FireAxe implements Weapon {
    final String WEAPON_NAME = "Fire axe";

    public static final int DICE_ROLLED = 1;
    public static final int SUCCESSFUL_ROLL = 4;
    public static final int DAMAGE = 2;

    @Getter
    @Setter
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
        return calculator.calculateDamageFromRoll(DICE_ROLLED, SUCCESSFUL_ROLL, DAMAGE);
    }
}

package com.tom.zombie.weapons;

import com.tom.zombie.util.WeaponDamageCalculator;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Pan implements Weapon {

    String weaponName = "Pan";

    public static final int DICE_ROLLED = 1;
    public static final int SUCCESSFUL_ROLL = 6;

    public static final int DAMAGE = 1;

    @Getter
    @Setter
    public WeaponDamageCalculator calculator = new WeaponDamageCalculator();

    @Override
    public List<Integer> determineDamageFromWeapon() {
        return calculator.calculateDamageFromRoll(DICE_ROLLED, SUCCESSFUL_ROLL, DAMAGE);
    }

    @Override
    public int getDamage() {
        return DAMAGE;
    }

    @Override
    public String getWeaponName() {
        return weaponName;
    }
}

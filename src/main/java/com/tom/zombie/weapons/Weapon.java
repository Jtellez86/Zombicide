package com.tom.zombie.weapons;

import java.util.List;

public interface Weapon {


    public String getWeaponName();
    int getDamage();

    public List<Integer> determineDamageFromWeapon();

}

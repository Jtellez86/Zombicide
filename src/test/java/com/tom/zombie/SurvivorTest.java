package com.tom.zombie;

import com.tom.zombie.weapons.Pan;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SurvivorTest {

    @Test
    public void shouldKillWalkerZombie() {
        Zombie zombie1 = new Zombie("Walker");
        Survivor survivor = new Survivor(new Pan());

        survivor.attack(zombie1);
        assertThat(zombie1.isAlive(), is(false));
    }

    @Test
    public void shouldNotKillFattyZombie() {
        Zombie fattyZombie = new Zombie("Fatty");
        Survivor survivor = new Survivor(new Pan());

        survivor.attack(fattyZombie);
        assertThat(fattyZombie.isAlive(), is(true));
    }

}
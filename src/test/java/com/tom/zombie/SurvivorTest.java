package com.tom.zombie;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SurvivorTest {

    @Test
    public void shouldKillWalkerZombie() {
        Zombie zombie1 = new Zombie("Walker");
        Survivor survivor = new Survivor("Pan");

        survivor.attack(zombie1, 1);
        assertThat(zombie1.isAlive(), is(false));
    }

    @Test
    public void shouldNotKillFattyZombie() {
        Zombie zombie1 = new Zombie("Fatty");
        Zombicide zombicide = new Zombicide();

        zombicide.attack(zombie1, 1);
        assertThat(zombie1.isAlive(), is(true));
    }

}
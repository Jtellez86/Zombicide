package com.tom.zombie;

import com.tom.zombie.util.WeaponDamageCalculator;
import com.tom.zombie.weapons.Pan;
import com.tom.zombie.weapons.Shotgun;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SurvivorTest {

    @Mock
    WeaponDamageCalculator calculator;

    @InjectMocks
    Survivor survivor;

    @Test
    public void shouldKillWalkerZombie() {
        Zombie zombie1 = new Zombie("Walker");
        Zone zoneWithZombie = new Zone();
        zoneWithZombie.getZombies().add(zombie1);

        when(calculator.calculateDamageFromRoll(1, 6, 1)).thenReturn(asList(1));

        Pan pan = new Pan();
        pan.setCalculator(calculator);

        survivor = new Survivor(pan);

        survivor.launchAttack(zoneWithZombie);
        assertThat(zombie1.isAlive(), is(false));
    }

    @Test
    public void shouldNotKillFattyZombieWithPan() {
        Zombie fattyZombie = new Zombie("Fatty");
        Zone zoneWithZombie = new Zone();

        zoneWithZombie.getZombies().add(fattyZombie);

        when(calculator.calculateDamageFromRoll(1, 6, 1)).thenReturn(asList(1));

        Pan pan = new Pan();
        pan.setCalculator(calculator);

        survivor = new Survivor(pan);

        survivor.launchAttack(zoneWithZombie);
        assertThat(fattyZombie.isAlive(), is(true));
    }

    @Test
    public void shouldKillFattyZombieWithShotgun() {
        Shotgun shotgun = new Shotgun();
        survivor = new Survivor(shotgun);
        Zombie fattyZombie = new Zombie("Fatty");

        Zone zoneWithZombie = new Zone();

        zoneWithZombie.getZombies().add(fattyZombie);

        when(calculator.calculateDamageFromRoll(2, 4, 2)).thenReturn(asList(2));

        survivor.launchAttack(zoneWithZombie);
        assertThat(fattyZombie.isAlive(), is(false));
    }
}
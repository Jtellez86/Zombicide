package com.tom.zombie;

import com.tom.zombie.util.WeaponDamageCalculator;
import com.tom.zombie.weapons.ClawHammer;
import com.tom.zombie.weapons.FireAxe;
import com.tom.zombie.weapons.Pan;
import com.tom.zombie.weapons.Shotgun;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class Zombicide_MeleeCombatTest {

    @Mock
    WeaponDamageCalculator calculator;

    @InjectMocks
    Zombicide zombicide;

    @Before
    public void given() {
        initMocks(this);
        zombicide = new Zombicide();
    }

    @Test
    public void shouldKillAllZombies() {

        zombicide = new Zombicide();

        when(calculator.calculateDamageFromRoll(1, 6, 1)).thenReturn(asList(6));
        when(calculator.calculateDamageFromRoll(3, 5, 1)).thenReturn(asList(5,4,4));

        Zone zone = new Zone();
        ClawHammer clawHammer = new ClawHammer();
        Pan pan = new Pan();

        clawHammer.setCalculator(calculator);
        pan.setCalculator(calculator);

        zone.setSurvivors(asList(
                new Survivor(clawHammer),
                new Survivor(pan)
                                ));
        zone.setZombies(asList(
                new Zombie("Runner"),
                new Zombie("Walker")
                              ));

        zombicide.setZone(zone);

        zombicide.meleeCombat();

        zone.getZombies()
            .stream()
            .filter(Zombie::isAlive)
            .findFirst()
            .ifPresent(z -> fail("All zombies should be killed "));
    }

    @Test
    public void shouldKillAllButAbomination() {
        Zombicide zombicide = new Zombicide();

        when(calculator.calculateDamageFromRoll(3, 5, 1)).thenReturn(asList(5,5,5));
        when(calculator.calculateDamageFromRoll(2, 4, 2)).thenReturn(asList(4));
        when(calculator.calculateDamageFromRoll(1, 4, 2)).thenReturn(asList(6));

        Zone zone = new Zone();

        ClawHammer clawHammer = new ClawHammer();
        clawHammer.setCalculator(calculator);

        Shotgun shotgun = new Shotgun();
        shotgun.setCalculator(calculator);

        FireAxe fireAxe = new FireAxe();
        fireAxe.setCalculator(calculator);

        zone.setSurvivors(asList(
                new Survivor(clawHammer),
                new Survivor(shotgun),
                new Survivor(fireAxe)
                                ));
        zone.setZombies(asList(
                new Zombie("Runner"),
                new Zombie("Walker"),
                new Zombie("Runner"),
                new Zombie("Fatty"),
                new Zombie("Abomination")
                              ));

        zombicide.setZone(zone);

        zombicide.meleeCombat();

        zone.getZombies()
            .stream()
            .filter(Zombie::isAlive)
            .findFirst()
            .ifPresent(z -> assertThat(z.getType(), is("Abomination")));
    }

}

package com.tom.zombie;

import com.tom.zombie.weapons.ClawHammer;
import com.tom.zombie.weapons.FireAxe;
import com.tom.zombie.weapons.Pan;
import com.tom.zombie.weapons.Shotgun;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class Zombicide_MeleeCombatTest {

    @Mock
    Dice dice;

    @Before
    public void given() {
        initMocks(this);
    }

    @Test
    public void shouldKillAllZombies() {
        Zombicide zombicide = new Zombicide();
        zombicide.dice = dice;
        when(dice.roll(1)).thenReturn(asList(6));
        when(dice.roll(3)).thenReturn(asList(5,4,4));

        Zone zone = new Zone();
        zone.setSurvivors(asList(
                new Survivor(new ClawHammer()),
                new Survivor(new Pan())
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
        zombicide.dice = dice;
        when(dice.roll(3)).thenReturn(asList(5,5,5));
        when(dice.roll(2)).thenReturn(asList(4));
        when(dice.roll(1)).thenReturn(asList(6));

        Zone zone = new Zone();
        zone.setSurvivors(asList(
                new Survivor(new ClawHammer()),
                new Survivor(new Shotgun()),
                new Survivor(new FireAxe())
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
